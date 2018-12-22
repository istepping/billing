package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.manager.UserMgr;
import com.billing.service.SettingService;
import com.billing.utils.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunLei on 2018/11/22 19:44
 * @version 1.0
 * @apiNote
 */
@Controller
@RequestMapping("/setting")
public class SettingController extends BaseController {
    @Autowired
    SettingService settingService;
    //获取设置信息
    @RequestMapping("/getSetting")
    @ResponseBody
    public Result getSetting() {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result = settingService.getSetting(uId);
        return successResponse(result.getData());
    }

    //设置父母Id
    @RequestMapping("/setParentId")
    @ResponseBody
    public Result setParentId(String flag,String parentId) {
        if (!Auth.isNumber(flag) || !Auth.isNumber(parentId)){
            return failInputResponse();
        }
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result = settingService.setParentId(uId,Integer.parseInt(flag),Long.valueOf(parentId));
        if (result.isSuccess()) {
            return successResponse();
        } else {
            return failResponse(result.getInfo());
        }
    }

    //设置家校互通
    @RequestMapping("/setOpenFamily")
    @ResponseBody
    public Result setOpenFamily(String content) {
        if (content.equals("0") || content.equals("1")) {
            Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
            BaseService.ServiceResult result = settingService.setOpenFamily(uId, Integer.valueOf(content));
            if (result.isSuccess()) {
                return successResponse();
            } else {
                return failResponse(result.getInfo());
            }
        } else {
            return failInputResponse();
        }
    }

    //设置账单私密
    @RequestMapping("/setBillPrivate")
    @ResponseBody
    public Result setBillPrivate(String content) {
        if (content.equals("0") || content.equals("1")) {
            Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
            BaseService.ServiceResult result = settingService.setBillPrivate(uId, Integer.valueOf(content));
            if (result.isSuccess()) {
                return successResponse();
            } else {
                return failResponse(result.getInfo());
            }
        } else {
            return failInputResponse();
        }
    }
}
