package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.BillMapper;
import com.billing.dao.FeatureMapper;
import com.billing.dao.RecommendMapper;
import com.billing.dao.UserMapper;
import com.billing.entity.Bill;
import com.billing.entity.Feature;
import com.billing.entity.Recommend;
import com.billing.entity.User;
import com.billing.service.ActionService;
import com.billing.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.billing.utils.Assist.print;

/**
 * @author sunLei on 2019/3/5 19:03
 * @version 1.0
 * @apiNote
 */
@Service
public class RecommendServiceImpl extends BaseService implements RecommendService {
    @Autowired
    private RecommendMapper recommendMapper;
    @Autowired
    private FeatureMapper featureMapper;
    @Autowired
    private ActionService actionService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BillMapper billMapper;
    //用户个性化推荐
    @Override
    public List<Recommend> getRecommendWithUId(Long uId) {
        //推荐引擎
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        Feature feature = featureMapper.selectByMonth(uId, String.valueOf(year), String.valueOf(month));
        if(feature==null){
            actionService.calculateFeature(uId,String.valueOf(year),String.valueOf(month));
            feature=featureMapper.selectByMonth(uId,String.valueOf(year),String.valueOf(month));
        }
        print("获取其他用户信息");
        //其他用户信息
        List<User> users=userMapper.selectAllUsers();
        Map<Double,Long> userMap=new HashMap<>();//记录对应用户
        List<Double> distances=new ArrayList<>();
        List<Feature> features=featureMapper.selectAllList(String.valueOf(year), String.valueOf(month));
        for(Feature feature1:features){
            //计算近似度
            print("计算近似度");
            double sub1=Math.pow(Double.valueOf(feature.getfParam1())-Double.valueOf(feature1.getfParam1()),2.0);
            double sub2=Math.pow(Double.valueOf(feature.getfParam2())-Double.valueOf(feature1.getfParam2()),2.0);
            double sub3=Math.pow(Double.valueOf(feature.getfParam3())-Double.valueOf(feature1.getfParam3()),2.0);
            double sub4=Math.pow(Double.valueOf(feature.getfParam4())-Double.valueOf(feature1.getfParam4()),2.0);
            double sub5=Math.pow(Double.valueOf(feature.getfParam5())-Double.valueOf(feature1.getfParam5()),2.0);
            double sub6=Math.pow(Double.valueOf(feature.getfParam6())-Double.valueOf(feature1.getfParam6()),2.0);
            double distance=Math.pow(sub1+sub2+sub3+sub4+sub5+sub6,0.5);
            print(distance);
            distances.add(distance);
            //允许覆盖:同一距离选取任何一个用户ID都可以,distance可以重复
            userMap.put(distance,feature1.getuId());
        }
        //升序排序
        Collections.sort(distances);
        //构建推荐内容
        List<Recommend> recommends=new ArrayList<>();
        for(int i=0;i<3;i++){
            //前3个最相似用户用户
            Long userId=userMap.get(distances.get(i));
            List<Bill> bills=billMapper.selectByUId(userId);
            for(Bill bill:bills){
                if(bill.getbType().equals("支出") && bill.getgType4()!=null && bill.getgType()!=null){
                    String type=bill.getgType();
                    String brand=bill.getgType4();
                    List<Recommend> recommends1=recommendMapper.selectByTypeAndBrand(type,brand);
                    recommends.addAll(recommends1);
                }
            }
        }
        if(recommends.size()<=10){
            List<Recommend> recommends1=recommendMapper.selectList();
            for(Recommend recommend:recommends1){
                if(Double.valueOf(recommend.getrLike())>0.9){
                    recommends.add(recommend);
                }
            }
        }
        return recommends;
    }

    @Override
    public List<Recommend> searchByName(String name) {
        return recommendMapper.selectByLikeName("%"+name+"%");
    }
    @Override
    public List<Recommend> getRecommend() {
        return recommendMapper.selectList();
    }
}
