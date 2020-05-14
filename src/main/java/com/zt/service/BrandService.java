package com.zt.service;

import com.zt.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:42
 */
public interface BrandService {
    public List<Brand> getAllBrand();
    public Brand getOneBrandById(int bid);
    public int insertbrand(String bname);
    public int updatebrand(String bname,int bid);
    public int deletebrand(int bid);
}
