package com.billing.service.impl;

import com.auth0.jwt.internal.org.bouncycastle.asn1.x509.ObjectDigestInfo;
import com.billing.base.BaseService;
import com.billing.dao.BrandMapper;
import com.billing.entity.Brand;
import com.billing.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunLei on 2019/1/3 18:30
 * @version 1.0
 * @apiNote
 */
@Service
public class BrandServiceImpl extends BaseService implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public ServiceResult getBrands() {
        List<Brand> brands =brandMapper.selectAll();
        Map<String, Object> data=new HashMap<>();
        data.put("brands",brands);
        return success(data);
    }

    @Override
    public ServiceResult getBrandByType(String type1, String type2, String type3) {
        List<Brand> brands =brandMapper.selectByType(type1,type2,type3);
        Map<String, Object> data=new HashMap<>();
        data.put("brands",brands);
        return success(data);
    }
}
