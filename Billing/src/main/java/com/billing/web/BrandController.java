package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunLei on 2019/1/3 18:22
 * @version 1.0
 * @apiNote
 */
@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController {
    @Autowired
    private BrandService brandService;
    @RequestMapping("/getBrands")
    @ResponseBody
    public Result  getBrands(){
        BaseService.ServiceResult result=brandService.getBrands();
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse();
        }
    }
    @RequestMapping("/getBrandByType")
    @ResponseBody
    public Result  getBrandByType(String type1,String type2,String type3){
        BaseService.ServiceResult result=brandService.getBrandByType(type1,type2,type3);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse();
        }
    }
}
