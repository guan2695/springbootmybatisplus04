package com.zt.controller;

import com.zt.entity.Brand;
import com.zt.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 车品牌控制器
 * @author xyq
 * @create 2020-05-08 9:35
 */
@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有车牌
     * @return
     */
    @RequestMapping("getAllBrand")
    @ResponseBody
    public List<Brand> getAllBrand(){
        System.out.println("进入查询所有车牌");
        List<Brand> brandList= brandService.getAllBrand();
        brandList.forEach(System.out::println);
        return brandList;
    }

    @RequestMapping("getOneBrand")
    @ResponseBody
    public Brand getOneBrandById(int bid){
        System.out.println("进入查询一个车牌和他的车系");
        Brand brand= brandService.getOneBrandById(bid);
        System.out.println(brand);
        return brand;
    }

}
