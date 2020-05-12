package com.zt.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zt.entity.Car;
import com.zt.entity.Images;
import com.zt.entity.User;
import com.zt.mapper.CarMapper;
import com.zt.service.CarService;
import com.zt.service.ImagesService;
import com.zt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author guan
 * @create 2020-05-08 9:20
 */
@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private ImagesService imagesService;
    @Autowired
    private UserService userService;

    /**
     *  首页的查询车辆
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String  homePage(Model model,HttpSession session){
        System.out.println("进入多表查询车");
        List<Car> carList = carService.selectlimit();
        carList.forEach(System.out::println);
        model.addAttribute("carList",carList);
        List<Car> carListagr=carService.selectCarage();
        model.addAttribute("carListagr",carListagr);
        List<Car> carlistPrice=carService.selectOprice();
        model.addAttribute("carlistPrice",carlistPrice);
        System.out.println("一共输出了"+carList.size()+"条数据");
        return "index";
    }

    /**
     * 账户退出时走的方法
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/index2")
    public String  homePage2(Model model,HttpSession session){
        System.out.println("进入多表查询车");
        List<Car> carList = carService.selectlimit();
        carList.forEach(System.out::println);
        model.addAttribute("carList",carList);
        List<Car> carListagr=carService.selectCarage();
        model.addAttribute("carListagr",carListagr);
        List<Car> carlistPrice=carService.selectOprice();
        model.addAttribute("carlistPrice",carlistPrice);
        System.out.println("一共输出了"+carList.size()+"条数据");
        session.removeAttribute("list2");
        return "index";
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

    /**
     * 查询评估或者未评估的车辆
     * @param model
     * @param car
     * @return
     */
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

    /**
     * 查询上架或者下架的车辆
     * @param model
     * @param car
     * @return
     */
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

    /**
     * 多条件查询
     * @param model
     * @param car
     * @return
     */
    @RequestMapping("/manyConditions")
    public String manyConditions(Model model,Car car){
        car.setBid(2);
        car.setCsid(5);
        /**
         * 区间 0-3是(1)
         * 区间 3-5是(2)
         * 区间 5-10是(3)
         * 区间 10-20是(4)
         * 区间 大于20万是(5)
         */

        car.setPrice(3D);
        car.setAddressid(3);
        car.setCorolid(9);
        /**
         * 区间 0-3是(1)
         * 区间 3-5是(2)
         * 区间 5-10是(3)
         * 区间 大于10万是(4)
         */
        car.setCarage(3);
        System.out.println("价格"+car.getPrice());
        List<Car> listmanyQuery =carService.manyConditions(car);
        model.addAttribute("listmanyQuery",listmanyQuery);
        System.out.println("多条件查询共"+listmanyQuery.size()+"条数据");
        return "show3";
    }

    /**
     *
     */
    @RequestMapping("/listhtml")
    public String listhtml(HttpSession session, User user) {
        System.out.println(" --------进入查询--------- ");
        return "list";
    }

    /**
     * 查询一辆车的详细信息
     * @param model
     * @param car
     * @param session
     * @param images
     * @return
     */
    @RequestMapping("/getCarone")
        public String getCarone(Model model, Car car, HttpSession session,Images images,int cid){
        System.out.println("车的id"+cid);
        car.setCid(cid);
        Car getone = carService.getCarone(car);
        model.addAttribute("getone",getone);
        System.out.println("车的id"+car.getCid());
        images.setCid(car.getCid());
        List<Images> listimages = imagesService.getimgesone(images);
        String string1 =listimages.get(0).getSrc();
        String string2 =listimages.get(1).getSrc();
        String string3 =listimages.get(2).getSrc();
        String string4 =listimages.get(3).getSrc();
        String string5 =listimages.get(4).getSrc();
        String string6 =listimages.get(5).getSrc();

        model.addAttribute("string1",string1);
        model.addAttribute("string2",string2);
        model.addAttribute("string3",string3);
        model.addAttribute("string4",string4);
        model.addAttribute("string5",string5);
        model.addAttribute("string6",string6);
        //model.addAttribute("listimages",listimages);


        Car carone1 = carService.getCarinfo(car);
        Car carinfomax =carService.getCardinfomax(car);
      // System.out.println("共1"+carone+"条数据");
        //基本数据类型长宽高
        model.addAttribute("carinfo1",carone1);
        //详细


        model.addAttribute("carinfomax",carinfomax);
        System.out.println(carone1.getCarinfo().getLength());
        return "infor";
    }


}
