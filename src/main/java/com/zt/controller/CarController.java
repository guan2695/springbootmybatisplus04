package com.zt.controller;

import com.zt.entity.Car;
import com.zt.entity.User;
import com.zt.mapper.CarMapper;
import com.zt.service.CarService;
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
    private CarService carService;

    /**
     *  首页的查询车辆
     * @param model
     * @return
     */
    @RequestMapping("/HomePage")
    @ResponseBody
    public List<Car> homePage(Model model){
        System.out.println("进入多表查询车");
        List<Car> carList = carService.selectlimit();
        carList.forEach(System.out::println);
        System.out.println("一共输出了"+carList.size()+"条数据");
        return carList;
    }

    /**
     * 修改车的评估状态
     * @param model
     * @param car
     * @return
     */
    @RequestMapping("/updateAssesstate")
    public String updateCarassesstate(Model model,Car car){
        car.setCid(1);
        car.setAssesstate(0);
        int num=carService.updateCarassesstate(car);
        System.out.println("成功"+num+"失败"+num);
        return "login";
    }

    /**
     * 修改车的上架状态
     * @param model
     * @param car
     * @return
     */
    @RequestMapping("/updatePutstate")
    public String updateCarputstate(Model model,Car car){
        car.setCid(1);
        car.setPutstate(0);
        int num=carService.updateCarputstate(car);
        System.out.println("成功"+num+"失败"+num);
        return "login";
    }
    @RequestMapping("/getAssesstate")
    public String getAssesstate(Model model,Car car){
        car.setAssesstate(0);
       List<Car> listAssesstate= carService.selectgetAssesstate(car);
       model.addAttribute("listAssesstate",listAssesstate);
               if(listAssesstate.size()==0){
                   return "error";
               }
       return "show";
    }
    @RequestMapping("/getPutstate")
    public String getPutstate(Model model,Car car){
        car.setPutstate(0);
        List<Car> listputstate = carService.selectgetPutstate(car);
        model.addAttribute("listputstate",listputstate);
        if(listputstate.size()==0){
            return "error";
        }
        return "show2";
    }
}
