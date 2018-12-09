package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.base.BaseService;
import com.billing.entity.Bill;

@Service
public interface SettingService{
	 BaseService.ServiceResult updateSetting(Long uId,int openFamily,int uPrivate);
	 BaseService.ServiceResult addSetting(Bill bill);
}
