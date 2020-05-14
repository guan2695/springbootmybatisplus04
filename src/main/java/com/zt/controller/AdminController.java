package com.zt.controller;

import com.alibaba.fastjson.JSONArray;
import com.zt.entity.*;
import com.zt.mapper.AdminMapper;
import com.zt.service.*;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author guan
 * @create 2020-05-07 19:08
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CorolService corolService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CarseriesService carseriesService;


    private int userpageSize=3;
    private int carPageSize=9;


    /**
     * 管理员登录
     * @param admin
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/adminlogin")
    public String adminlogin(Admin admin, Model model, HttpSession session) {
        System.out.println("进入管理员登录");
        Admin admin1 = adminService.adminlogin(admin);
        session.setAttribute("admin1", admin1);
        if (admin1 == null) {
            return "error";
        }
        return "redirect:adminIndex?pageIndex=1";
    }

    /**
     * 管理员第一次进入页面，对用户分页
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/adminIndex")
    public String adminIndexAllUser(int pageIndex,Model model){
        System.out.println("进入用户分页");
        int pageCount=userService.selectall().size();//总条数
        pageCount=pageCount%userpageSize==0?pageCount/userpageSize:pageCount/userpageSize+1;//总页数
        model.addAttribute("pageIndex",pageIndex);
        model.addAttribute("pageCount",pageCount);
        List<User> userList= userService.selectUserByPage(pageIndex,userpageSize);
        userList.forEach(System.out::println);
        model.addAttribute("userList",userList);
        return "admin";
    }

    /**
     * 异步刷新，用户列表页码跳转
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/adminIndex2")
    @ResponseBody
    public List<User> adminIndexAllUser2(int pageIndex,Model model){
        System.out.println("进入异步刷新跳转页码");
        List<User> userList= userService.selectUserByPage(pageIndex,userpageSize);
        userList.forEach(System.out::println);
        model.addAttribute("userList",userList);
        return userList;
    }

    /**
     * 管理员查看一个用户详情
     * @param uid
     * @param model
     * @return
     */
    @RequestMapping("/adminLookUser")
    public String adminLookUserInfo(int uid,Model model){
        System.out.println("进入查看一个用户的方法"+uid);
        User user= userService.getOneUserById(uid);
        model.addAttribute("user",user);
        return "adminUserInfo";
    }

    /**
     * 管理员删除用户
     * @param uid
     * @return
     */
    @RequestMapping("/adminDelUser")
    @ResponseBody
    public String adminDelUserByUid(int uid){
        System.out.println("进入管理员删除用户方法"+uid);
        int num= userService.delUserByid(uid);
        return num>0?"yes":"no";
    }

    /**
     * 获得用户列表总页码
     * @return
     */
    @RequestMapping("/adminUserPageCount")
    @ResponseBody
    public int adminGetUserPageCount(){
        System.out.println("进入获取用户总页码");
        int pageCount=userService.selectall().size();
        pageCount=pageCount%userpageSize==0?pageCount/userpageSize:pageCount/userpageSize+1;
        System.out.println("用户页码："+pageCount);
        return pageCount;
    }

    /**
     * 得到车辆页面的页码
     * @return
     */
    @RequestMapping("/adminCarPageCount")
    @ResponseBody
    public int adminGetCarPageCount(){
        System.out.println("进入获取车辆总页码");
        int pageCount= carService.adminGetPageCount().size();
        pageCount=pageCount%carPageSize==0?pageCount/carPageSize:pageCount/carPageSize+1;
        return pageCount;
    }

    /**
     * 车辆列表分页
     * @param pageIndex
     * @return
     */
    @RequestMapping("/adminCarList")
    @ResponseBody
    public List<Car> adminAllCarByPage(int pageIndex){
        System.out.println("进入管理员车辆分页查询");
        List<Car> carList= carService.adminGetCarByPage(pageIndex,carPageSize);
        carList.forEach(System.out::println);
        return carList;
    }

    /**
     * 管理员查看一辆车的信息
     * @param cid
     * @param model
     * @return
     */
    @RequestMapping("/adminGetOneCar")
    public String adminLookOneCar(int cid,Model model){
        System.out.println("进入查询一辆车信息");
        Car car= carService.GetOneCarAllInfo(cid);
        System.out.println(car);
        model.addAttribute("car",car);
        return "adminCarInfo";
    }

    /**
     * 管理员修改一辆车之前，得到一辆车的信息
     * @param cid
     * @return
     */
    @RequestMapping("/adminUpdCarBefo")
    public String adminUpdCarBefo(int cid,Model model){
        System.out.println("修改车之前："+cid);
        Car car= carService.GetOneCarAllInfo(cid);
        System.out.println(car);
        model.addAttribute("car",car);

        List<Brand> brandList=brandService.getAllBrand();
        List<Cardseries> cardseriesList=car.getBrand().getCardseries();
        List<Corol> corolList=corolService.getAllcorol();
        List<Address> addressList= addressService.getAllAddress();

        model.addAttribute("brandList",brandList);
        model.addAttribute("cardseriesList",cardseriesList);
        model.addAttribute("corolList",corolList);
        model.addAttribute("addressList",addressList);
        return "adminUpdCar";
    }

    /**
     * 管理员修改车辆信息
     * @param car
     * @return
     */
    @RequestMapping("/adminUpdCar")
    public String adminUpdCar(Car car){
        System.out.println("进入管理员修改车："+car);
        int num=carService.adminUpdCar(car);
        System.out.println(num>0?"修改成功":"修改失败");
        return "redirect:adminIndex?pageIndex=1";
    }

    /**
     *管理员根据一个车牌得到车系集合
     * @param bid
     * @return
     */
    @RequestMapping("/adminByBrandCarSeries")
    @ResponseBody
    public List<Cardseries> adminByBrandCarSeries(int bid){
        System.out.println("进入管理员根据一个品牌得到车系方法："+bid);
        List<Cardseries> cardseriesList= carseriesService.getCardSeriesByBrand(bid);
        cardseriesList.forEach(System.out::println);
        return cardseriesList;
    }

    /**
     * 管理员下架方法
     * @param
     * @return
     */
    @RequestMapping("/adminDelCar")
    @ResponseBody
    public String adminDelCar(Car car){
        System.out.println("进入管理员下架方法："+car);
        car.setPutstate(0);
        int num= carService.updateCarputstate(car);
        if(num>0){
            return "yes";
        }else {
            return "no";
        }

    }

    /**
     * 管理员上架方法
     * @param
     * @return
     */
    @RequestMapping("/adminUpCar")
    @ResponseBody
    public String adminUpCar(Car car){
        System.out.println("进入管理员上架方法："+car);
        car.setPutstate(1);
        int num= carService.updateCarputstate(car);
        if(num>0){
            return "yes";
        }else {
            return "no";
        }

    }

}
