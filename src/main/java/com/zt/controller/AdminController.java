package com.zt.controller;

import com.zt.entity.Admin;
import com.zt.mapper.AdminMapper;
import com.zt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author guan
 * @create 2020-05-07 19:08
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param admin
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/adminlogin")
    public String adminlogin(Admin admin, Model model, HttpSession session) {
        System.out.println("aaa");
        System.out.println("进入管理员登录");
        Admin admin1 = adminService.adminlogin(admin);
        session.setAttribute("admin1", admin1);
        if (admin1 == null) {
            return "error";
        }
        return "adminsuccess";
    }

}
