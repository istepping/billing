package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.PrankMapper;
import com.billing.dao.UserInfoMapper;
import com.billing.dao.UserMapper;
import com.billing.dto.MonthRankDto;
import com.billing.dto.PersonRankDto;
import com.billing.entity.Prank;
import com.billing.entity.User;
import com.billing.entity.UserInfo;
import com.billing.enums.FailInfoEnum;
import com.billing.service.PrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.billing.utils.Assist.print;
import static com.billing.utils.Auth.isNumber;

/**
 * @author sunLei on 2018/11/22 17:04
 * @version 1.0
 * @apiNote
 */
@Service
public class PrankServiceImpl extends BaseService implements PrankService {
    @Autowired
    PrankMapper prankMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public ServiceResult getPrank(String year, String month,Long uId) {
        if(!isNumber(year) || !isNumber(month)){
            return fail(FailInfoEnum.fail1.getInfo());
        }
        List<Prank> pranks=prankMapper.selectByMonth(year,month,uId);
        //首次请求处理部分,计算比零评分
        if(pranks.size()<=0){
            //计算评分，插入数据
            Prank prank=new Prank();
            prank.setrYear(year);
            prank.setrMonth(month);
            prank.setrDate(new Date());
            prank.setrState(0);
            Integer score;

        }
        //首次请求处理部分结束
        //首次请求处理部分,计算排名信息
        if(pranks.size()>0 && pranks.get(0).getrRank()==null){
            List<Prank> prankAll=prankMapper.selectAllByMonth(year,month);
            for(int i=0;i<prankAll.size();i++){
                prankAll.get(i).setrRank(i+1);
                prankMapper.updateByPrimaryKey(prankAll.get(i));
            }
            pranks=prankMapper.selectByMonth(year,month,uId);
        }
        //首次请求处理部分结束
        Map<String,Object> data=new HashMap<>();
        data.put("pranks",pranks);
        return success(data);
    }

    @Override
    public ServiceResult getPre10Ranks(String year, String month) {
        if(!isNumber(year) || !isNumber(month)){
            return fail(FailInfoEnum.fail1.getInfo());
        }
        List<Prank> pranks=prankMapper.selectPre10(year,month);
        //处理数据
        List<PersonRankDto> personRankDtos=new ArrayList<>();
        for (int i=0;i<pranks.size();i++){
            Prank prank=pranks.get(i);
            PersonRankDto personRankDto=new PersonRankDto();
            personRankDto.setRank(i+1);
            if(prank.getrScore()!=null){
                personRankDto.setScore(String.valueOf(prank.getrScore()));
            }
            UserInfo userInfo=userInfoMapper.selectByPrimaryKey(prank.getuId());
            if(userInfo==null){
                personRankDto.setNickName("暂无");
                personRankDto.setAvatarUrl("https://upload-images.jianshu.io/upload_images/7795819-879486be51c41aa7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
            }else{
                if(userInfo.getuNickname()!=null){
                    personRankDto.setNickName(userInfo.getuNickname());
                }
                if(userInfo.getuAvatarurl()!=null){
                    personRankDto.setAvatarUrl(userInfo.getuAvatarurl());
                }
            }
            personRankDtos.add(personRankDto);
        }
        Map<String,Object> data=new HashMap<>();
        data.put("pranks",personRankDtos);
        return success(data);
    }

    @Override
    public ServiceResult getRankChange(Long uId) {
       //确定时间
        Calendar now=Calendar.getInstance();
        int year=now.get(Calendar.YEAR);
        int month=now.get(Calendar.MONTH)+1;//当前月
        //12个月前
        for(int i=0;i<12;i++){
            if(month>1){
                month-=1;//上个月开始
            }else{
                year-=1;
                month=12;
            }
        }
        //准备模型
        List<MonthRankDto> monthRankDtos=new ArrayList<>();
        Integer lastRank=0;
        for(int m=0;m<12;m++){
            List<Prank> pranks=prankMapper.selectByMonth(String.valueOf(year),String.valueOf(month),uId);
            if(pranks.size()>0 && pranks.get(0).getrRank()==null){
                List<Prank> prankAll=prankMapper.selectAllByMonth(String.valueOf(year),String.valueOf(month));
                for(int i=0;i<prankAll.size();i++){
                    prankAll.get(i).setrRank(i+1);
                    prankMapper.updateByPrimaryKey(prankAll.get(i));
                }
                pranks=prankMapper.selectByMonth(String.valueOf(year),String.valueOf(month),uId);
            }
            MonthRankDto monthRankDto1=new MonthRankDto();
            monthRankDto1.setYear(String.valueOf(year));
            monthRankDto1.setMonth(String.valueOf(month));
            if(pranks.size()>0){
                monthRankDto1.setIsHasRank("1");
                monthRankDto1.setRank(pranks.get(0).getrRank());
                if(lastRank==0){
                    monthRankDto1.setIsRankUp("0");
                    monthRankDto1.setRankUpNum(0);
                }else{
                    Integer rankUpNum=lastRank-pranks.get(0).getrRank();
                    monthRankDto1.setRankUpNum(rankUpNum);
                    if(rankUpNum>0){
                        monthRankDto1.setIsRankUp("1");
                    }else{
                        monthRankDto1.setIsRankUp("0");
                    }
                }
                lastRank=pranks.get(0).getrRank();
            }else{
                monthRankDto1.setIsHasRank("0");
                monthRankDto1.setIsRankUp("0");
                monthRankDto1.setRank(0);
                monthRankDto1.setRankUpNum(0);
            }
            //添加条目
            monthRankDtos.add(monthRankDto1);
            if(month<12){
                month+=1;//上个月开始
            }else{
                year+=1;
                month=1;
            }
        }
        Map<String,Object> data=new HashMap<>();
        User user=userMapper.selectByPrimaryKey(uId);
        data.put("school",user.getuSchool());
        data.put("monthRanks",monthRankDtos);
        return success(data);
    }
}
