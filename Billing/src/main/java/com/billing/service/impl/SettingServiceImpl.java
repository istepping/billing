package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.SettingMapper;
import com.billing.entity.Bill;
import com.billing.entity.Setting;
import com.billing.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SettingServiceImpl extends BaseService implements SettingService {

	@Autowired
	SettingMapper settingMapper;
	
	@Override
    public ServiceResult updateSetting(Long uId,int openFamily,int uPrivate) {
	    Setting setting=new Setting();
	    setting.setuId(uId);
	    setting.setuOpenFamily(openFamily);
	    setting.setuPrivate(uPrivate);
	    int result=settingMapper.updateByPrimaryKeySelective(new Setting());
	    if(result>0){
	    	return success();
		}else{
	    	return fail();
		}
    }

	@Override
	public ServiceResult addSetting(Bill bill) {
		return null;
	}
}
