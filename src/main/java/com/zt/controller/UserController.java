package com.zt.controller;

import com.zt.entity.User;
import com.zt.mapper.UsersMapper;
import com.zt.service.UserService;
import org.apache.ibatis.lang.UsesJava7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.util.List;

/**
 * @author guan
 * @create 2020-04-24 14:54
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 得到所有用户
     *
     * @param modelmap
     * @return
     */
    @RequestMapping("/selectAll")
    public String testfreemake(Model modelmap) {
        System.out.println(" --------Select--------- ");
        List<User> list = userService.selectall();
        for (User users : list) {
        }
        modelmap.addAttribute("list", list);
        return "succes";

    }

    /**
     * 用户登录
     *
     * @param
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session, User user) {
        System.out.println(" --------login--------- ");
        System.out.println("phone" + user.getPhone());
        User userlist2 = userService.selectlogin(user);
        session.setAttribute("list2", userlist2);
        return "forward:index";
    }

    /**
     * 退出账号走的方法
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/remove")
    public String login2(HttpSession session, User user) {
        session.setAttribute("list2",null);
        return "forward:index2";
    }

    /**
     * 后台进入用户页面
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/userinfo")
    public String userinfo(HttpSession session, User user) {
        return "user";
    }
    @RequestMapping("/userinfoCar")
    public String userinfoCar(HttpSession session, User user) {
        return "user_bus";
    }
    @RequestMapping("/userinfoPwd")
    public String userinfoPwd(HttpSession session, User user) {
        return "user_account";
    }

    @RequestMapping("/wymchtml")
    public String wymchtml(HttpSession session, User user) {
        return "wymc";
    }
    /**
     * 用户注册
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String add(User user, Model model) {
        System.out.println("页面传送的uname是" + user.getUname());
        int num = userService.userregister(user);
        System.out.println("num的值为" + num);
        if (num == 0) {
            return "index";
        }
        return "index";
    }
    /**
     * 修改用户密码
     */
    @RequestMapping("/updatepwd")
    public String updateUpwd(Model model, User user,int uid){
        user.setUid(uid);
        int num = userService.updateUserpwd(user);
        if(num==0){
            return "404";
        }
        return "user";
    }
//    //分页
//    @RequestMapping("fenye")
//    public String fentye(Integer pageindex,Model model){
//   int  pagesize=3;
//        Page<Users> page;
//if(pageindex==null){
//    pageindex=1;
//    page=new Page<>(pageindex,pagesize);
//}
//        page=new Page<>(pageindex,pagesize);
//        IPage iPage=usersmapper.selectPage(page,null);
//        System.out.println("总ge数"+iPage.getTotal());
//    long total=iPage.getTotal();
//    int count= (int) (total%pagesize==0?total/pagesize:total/pagesize+1);
//        System.out.println("总页数为"+count);
//    List<Users> listu=   iPage.getRecords();
//        model.addAttribute("count",count);
//        model.addAttribute("pageindex",pageindex);
//        model.addAttribute("listu",listu);
//    return "fenye";
//
//    }

}
