package com.billing.service;

import com.billing.base.BaseService;
import com.billing.entity.Grank;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunLei on 2018/11/21 11:25
 * @version 1.0
 * @apiNote
 */
@Service
public interface GrankService {
    BaseService.ServiceResult getGrank(String year, String month);
}
