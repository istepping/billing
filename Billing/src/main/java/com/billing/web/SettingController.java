package com.billing.web;

import com.billing.base.BaseControl;
import com.billing.base.BaseService;
import com.billing.manager.UserMgr;
import com.billing.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/setting")
public class SettingController extends BaseControl{
	@Autowired
	private SettingService settingService;
	

	@RequestMapping("/updateSetting")
	@ResponseBody
	public Result updateSetting(String isOpen){
		String token=getRequest().getHeader("authorization");
        if (token==null){
            return failResponse("authorization不能为空");
        }
        if(UserMgr.isLogin(token)){
            Long uId= UserMgr.getUId(token);
            int openFamily=Integer.parseInt(isOpen);
            if(openFamily==0 || openFamily==1){
                BaseService.ServiceResult result=settingService.updateSetting(uId,openFamily);
                if(result.isSuccess()){
                    return successResponse();
                }else{
                    return failResponse(result.getInfo());
                }
            }
            else {
                return failResponse("输入无效");
            }

        }else{
            return failResponse("授权失败");
        }
    }
	}
