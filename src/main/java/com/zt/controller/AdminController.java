package com.zt.controller;

import com.alibaba.fastjson.JSONArray;
import com.zt.entity.Admin;
import com.zt.entity.Car;
import com.zt.entity.User;
import com.zt.mapper.AdminMapper;
import com.zt.service.AdminService;
import com.zt.service.CarService;
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
        int pageSize=3;
        int pageCount=userService.selectall().size();//总条数
        pageCount=pageCount%pageSize==0?pageCount/pageSize:pageCount/pageSize+1;//总页数
        model.addAttribute("pageIndex",pageIndex);
        model.addAttribute("pageCount",pageCount);
        List<User> userList= userService.selectUserByPage(pageIndex,pageSize);
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
        int pageSize=3;
        List<User> userList= userService.selectUserByPage(pageIndex,pageSize);
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

}
