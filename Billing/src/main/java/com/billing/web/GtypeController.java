package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.service.GtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.billing.utils.Auth.isNumber;

/**
 * @author sunLei on 2018/11/22 19:39
 * @version 1.0
 * @apiNote
 */
@Service
@RequestMapping("/gtype")
public class GtypeController extends BaseController {
    @Autowired
    GtypeService gtypeService;
    //获取主分类
    @RequestMapping("/getType")
    @ResponseBody
    public Result getType(){
        BaseService.ServiceResult result=gtypeService.getType();
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
    //获取子分类
    @RequestMapping("/getChildType")
    @ResponseBody
    public Result getChildType(String pTypeId){
        if(!isNumber(pTypeId)){
            return failResponse("输入不正确");
        }
        BaseService.ServiceResult result=gtypeService.getChildType(Long.valueOf(pTypeId));
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
}
