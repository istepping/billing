package com.billing.web;

import com.billing.base.BaseController;
import com.billing.entity.Good;
import com.billing.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.billing.utils.Auth.isNumber;

/**
 * @author sunLei on 2018/11/22 15:51
 * @version 1.0
 * @apiNote
 */
@Controller
@RequestMapping("/good")
public class GoodController extends BaseController {
    @Autowired
    //分类查询
    private GoodService goodService;
    @RequestMapping("/getGoods")
    @ResponseBody
    public Result  getGoods(String level,String typeId){
        if(!isNumber(level) || !isNumber(typeId)){
            return failResponse("参数错误");
        }
        Map<String,Object> data=new HashMap<>();
        List<Good> goods=goodService.getGoods(Integer.parseInt(level),Long.valueOf(typeId));
        data.put("goods",goods);
        return successResponse(data);
    }
}
