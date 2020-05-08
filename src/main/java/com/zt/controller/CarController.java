package com.zt.controller;

import com.zt.entity.Car;
import com.zt.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-08 9:20
 */
@Controller
public class CarController {
    @Autowired
    private CarMapper carMapper;

    /**
     *  首页的查询车辆
     * @param model
     * @return
     */
    @RequestMapping("/HomePage")
    @ResponseBody
    public List<Car> homePage(Model model){
        System.out.println("进入多表查询车");
        List<Car> carList = carMapper.selectlimit();
        carList.forEach(System.out::println);
        System.out.println("一共输出了"+carList.size()+"条数据");
        return carList;
    }
}
