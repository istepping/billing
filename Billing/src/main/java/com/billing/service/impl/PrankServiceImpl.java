package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.*;
import com.billing.dto.MonthRankDto;
import com.billing.dto.PersonRankDto;
import com.billing.dto.PrankInfo;
import com.billing.entity.*;
import com.billing.enums.FailInfoEnum;
import com.billing.service.ActionService;
import com.billing.service.MonthFeatureService;
import com.billing.service.PrankService;
import com.billing.utils.MathUtil;
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
    private PrankMapper prankMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MonthFeatureMapper monthFeatureMapper;
    @Autowired
    private MonthFeatureService monthFeatureService;
    @Autowired
    BillMapper billMapper;

    @Override
    public ServiceResult getPrankByMonth(String year, String month, Long uId) {
        if (!isNumber(year) || !isNumber(month)) {
            return fail(FailInfoEnum.fail1.getInfo());
        }
        //预处理
        ServiceResult result = preHandle(year, month);
        if (!result.isSuccess()) {
            return fail(result.getInfo());
        }
        List<Prank> pranks = prankMapper.selectPre10(year, month);
        List<PersonRankDto> personRankDtos = new ArrayList<>();
        for (int i = 0; i < pranks.size(); i++) {
            Prank prank = pranks.get(i);
            PersonRankDto personRankDto = new PersonRankDto();
            personRankDto.setRank(i + 1);
            personRankDto.setPrank(prank);
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(prank.getuId());
            if (userInfo == null) {
                personRankDto.setNickName("暂无");
                personRankDto.setAvatarUrl("https://upload-images.jianshu.io/upload_images/7795819-879486be51c41aa7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
            } else {
                personRankDto.setNickName(userInfo.getuNickname());
                personRankDto.setAvatarUrl(userInfo.getuAvatarurl());
            }
            if (prank.getrScore() != null) {
                personRankDto.setScore(String.valueOf(prank.getrScore()));
            }
            personRankDtos.add(personRankDto);
        }
        List<Prank> prank = prankMapper.selectByMonth(year, month, uId);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uId);
        Map<String, Object> data = new HashMap<>();
        data.put("pranks", personRankDtos);
        data.put("prank",prank);
        data.put("userInfo",userInfo);
        return success(data);
    }

    @Override
    public ServiceResult getPrank(String year, String month, Long uId) {
        if (!isNumber(year) || !isNumber(month)) {
            return fail(FailInfoEnum.fail1.getInfo());
        }
        ServiceResult result = preHandle(year, month);
        if (!result.isSuccess()) {
            return fail(result.getInfo());
        }
        List<Prank> pranks = prankMapper.selectByMonth(year, month, uId);
        int score = pranks.get(0).getrScore();
        int score1 = pranks.get(0).getrScore1();
        int score2 = pranks.get(0).getrScore2();
        int score3 = pranks.get(0).getrScore3();
        int score4 = pranks.get(0).getrScore4();
        int score5 = pranks.get(0).getrScore5();
        int score6 = pranks.get(0).getrScore6();
        PrankInfo prankInfo = new PrankInfo(pranks.get(0), String.valueOf(score), String.valueOf(score1), String.valueOf(score2), String.valueOf(score3), String.valueOf(score4), String.valueOf(score5), String.valueOf(score6));
        Map<String, Object> data = new HashMap<>();
        data.put("prankInfo", prankInfo);
        return success(data);
    }

    @Override
    public ServiceResult getPre10Ranks(String year, String month) {
        if (!isNumber(year) || !isNumber(month)) {
            return fail(FailInfoEnum.fail1.getInfo());
        }
        //预处理
        ServiceResult result = preHandle(year, month);
        if (!result.isSuccess()) {
            return fail(result.getInfo());
        }
        List<Prank> pranks = prankMapper.selectPre10(year, month);
        //处理数据
        List<PersonRankDto> personRankDtos = new ArrayList<>();
        for (int i = 0; i < pranks.size(); i++) {
            Prank prank = pranks.get(i);
            PersonRankDto personRankDto = new PersonRankDto();
            personRankDto.setRank(i + 1);
            if (prank.getrScore() != null) {
                personRankDto.setScore(String.valueOf(prank.getrScore()));
            }
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(prank.getuId());
            if (userInfo == null) {
                personRankDto.setNickName("暂无");
                personRankDto.setAvatarUrl("https://upload-images.jianshu.io/upload_images/7795819-879486be51c41aa7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
            } else {
                if (userInfo.getuNickname() != null) {
                    personRankDto.setNickName(userInfo.getuNickname());
                }
                if (userInfo.getuAvatarurl() != null) {
                    personRankDto.setAvatarUrl(userInfo.getuAvatarurl());
                }
            }
            personRankDtos.add(personRankDto);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("pranks", personRankDtos);
        return success(data);
    }

    @Override
    public ServiceResult getRankChange(Long uId) {
        //确定时间
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;//当前月
        //12个月前
        for (int i = 0; i < 12; i++) {
            if (month > 1) {
                month -= 1;//上个月开始
            } else {
                year -= 1;
                month = 12;
            }
        }
        //准备模型
        List<MonthRankDto> monthRankDtos = new ArrayList<>();
        Integer lastRank = 0;
        for (int m = 0; m < 12; m++) {
            List<Prank> pranks = prankMapper.selectByMonth(String.valueOf(year), String.valueOf(month), uId);
            if (pranks.size() > 0 && pranks.get(0).getrRank() == null) {
                List<Prank> prankAll = prankMapper.selectAllByMonth(String.valueOf(year), String.valueOf(month));
                for (int i = 0; i < prankAll.size(); i++) {
                    prankAll.get(i).setrRank(i + 1);
                    prankMapper.updateByPrimaryKey(prankAll.get(i));
                }
                pranks = prankMapper.selectByMonth(String.valueOf(year), String.valueOf(month), uId);
            }
            MonthRankDto monthRankDto1 = new MonthRankDto();
            monthRankDto1.setYear(String.valueOf(year));
            monthRankDto1.setMonth(String.valueOf(month));
            if (pranks.size() > 0) {
                monthRankDto1.setIsHasRank("1");
                monthRankDto1.setRank(pranks.get(0).getrRank());
                if (lastRank == 0) {
                    monthRankDto1.setIsRankUp("0");
                    monthRankDto1.setRankUpNum(0);
                } else {
                    Integer rankUpNum = lastRank - pranks.get(0).getrRank();
                    monthRankDto1.setRankUpNum(rankUpNum);
                    if (rankUpNum > 0) {
                        monthRankDto1.setIsRankUp("1");
                    } else {
                        monthRankDto1.setIsRankUp("0");
                    }
                }
                lastRank = pranks.get(0).getrRank();
            } else {
                monthRankDto1.setIsHasRank("0");
                monthRankDto1.setIsRankUp("0");
                monthRankDto1.setRank(0);
                monthRankDto1.setRankUpNum(0);
            }
            //添加条目
            monthRankDtos.add(monthRankDto1);
            if (month < 12) {
                month += 1;//上个月开始
            } else {
                year += 1;
                month = 1;
            }
        }
        Map<String, Object> data = new HashMap<>();
        User user = userMapper.selectByPrimaryKey(uId);
        data.put("school", user.getuSchool());
        data.put("monthRanks", monthRankDtos);
        return success(data);
    }

    @Override
    public ServiceResult preHandle(String year, String month) {
        //year,month合法
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;
        if (Integer.parseInt(year) > nowYear || (Integer.parseInt(year) == nowYear && Integer.parseInt(month) > nowMonth)) {
            return fail("暂无该月份的排名信息");
        }
        List<Prank> pranks = prankMapper.selectAllByMonth(year, month);
        if (pranks.size() > 5 && pranks.get(0).getrScore1() != null) {
            //5，容错数
            return success("已有排名信息");
        }
        //统计排名信息[计算评分][计算排名]
        List<User> users = userMapper.selectAllUsers();
        for (User user : users) {
            //过滤无用数据
            String time;
            if(month.length()==1){
                time=year + "-0" + month + "%";
            }else{
                time=year + "-" + month + "%";
            }
            List<Bill> bills=billMapper.selectByMonth(user.getuId(),time);
            if(bills==null || bills.size()<3){
                continue;
            }
            Long uId = user.getuId();
            Prank prank = new Prank();
            prank.setrYear(year);
            prank.setrMonth(month);
            prank.setrDate(new Date());
            prank.setrState(0);
            prank.setuId(uId);
            float score;
            print("用户"+user.getuId());
            MonthFeature feature = monthFeatureMapper.selectByMonth(uId,year,month);
            if (feature == null) {
                monthFeatureService.calculateMonthFeature(uId,year,month);
                feature = monthFeatureMapper.selectByMonth(uId,year,month);
            }
            Float score1 = MathUtil.INSTANCE.getScore(feature.getfParam1(), 0.5f);
            Float score2 = MathUtil.INSTANCE.getScore(feature.getfParam2(), 0.2f);
            Float score3 = MathUtil.INSTANCE.getScore(feature.getfParam3(), 0.3f);
            Float score4 = MathUtil.INSTANCE.getScore(feature.getfParam4(), 0.2f);
            Float score5 = MathUtil.INSTANCE.getScore(feature.getfParam5(), 0.95f);
            Float score6 = MathUtil.INSTANCE.getScore(feature.getfParam6(), 0.9f);
            score = score1 + score2 + score3 + score4 + score5 + score6;
            prank.setrScore((int) score);
            prank.setrScore1((int) (float) score1);
            prank.setrScore2((int) (float) score2);
            prank.setrScore3((int) (float) score3);
            prank.setrScore4((int) (float) score4);
            prank.setrScore5((int) (float) score5);
            prank.setrScore6((int) (float) score6);
            pranks = prankMapper.selectByMonth(year, month, uId);
            if (pranks.size() <= 0) {
                prankMapper.insert(prank);
            } else {
                prank.setrId(pranks.get(0).getrId());
                prankMapper.updateByPrimaryKeySelective(prank);
            }
        }
        //计算排名
        List<Prank> prankAll = prankMapper.selectAllByMonth(year, month);
        for (int i = 0; i < prankAll.size(); i++) {
            prankAll.get(i).setrRank(i + 1);
            prankMapper.updateByPrimaryKey(prankAll.get(i));
        }
        return success();
    }
}
