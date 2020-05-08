package com.zt.service.impl;

import com.zt.entity.Brand;
import com.zt.mapper.BrandMapper;
import com.zt.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:43
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getAllBrand() {
        return brandMapper.getAllBrand();
    }

    @Override
    public Brand getOneBrandById(int bid) {
        return brandMapper.getOneBrandById(bid);
    }
}
