package com.billing.web;

import com.billing.base.BaseController;
import com.billing.manager.UserMgr;
import com.billing.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunLei on 2019/3/5 19:01
 * @version 1.0
 * @apiNote
 */
@Controller
@RequestMapping("/recommend")
public class RecommendController extends BaseController {
    @Autowired
    private RecommendService recommendService;
    @RequestMapping("getRecommend")
    @ResponseBody
    public Result getRecommend(){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        Map<String,Object> data=new HashMap<>();
        data.put("recommend",recommendService.getRecommend(uId));
        return successResponse(data);
    }
}
