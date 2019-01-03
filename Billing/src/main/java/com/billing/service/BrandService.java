package com.billing.service;

import com.billing.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2019/1/3 18:25
 * @version 1.0
 * @apiNote
 */
@Service
public interface BrandService {
    //获取全部品牌
    BaseService.ServiceResult getBrands();
    //通过分类获取品牌
    BaseService.ServiceResult getBrandByType(String type1,String type2,String type3);
}
