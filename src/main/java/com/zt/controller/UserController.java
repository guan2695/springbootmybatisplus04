package com.zt.controller;

import com.zt.entity.User;
import com.zt.mapper.UsersMapper;
import com.zt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    @RequestMapping("/remove")
    public String login2(HttpSession session, User user) {
        session.setAttribute("list2",null);
        return "forward:index";
    }
    @RequestMapping("/login3")
    public String login3(HttpSession session, User user) {
        System.out.println(" --------login--------- ");
        System.out.println("phone" + user.getPhone());
        User list2 = userService.selectlogin(user);
        session.setAttribute("list2", list2);
        return "user_account";
    }
    @RequestMapping("/login4")
    public String login4(HttpSession session, User user) {
        System.out.println(" --------login--------- ");
        System.out.println("phone" + user.getPhone());
        User list2 = userService.selectlogin(user);
        session.setAttribute("list2", list2);
        return "user_bus";
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
//    @RequestMapping("/delete")
//    public String delete(Users users){
//        System.out.println("进入删除控制器");
//        System.out.println("页面传送的uid是"+users.getUid());
//         int uid=users.getUid();
//        QueryWrapper qw = new QueryWrapper();
//        qw.eq("uid",users.getUid());
//       int num= usersmapper.delete(qw);
//        System.out.println("num的值为"+num);
//        if(num==0){
//            return "forward:login.html";
//        }
//        return  "forward:/free";
//    }
//    @RequestMapping("/update")
//    public String update(String uname,String upassword){
//        Users users = new Users();
//        System.out.println("进入修改控制器");
//       System.out.println("页面传送的uid是"+users.getUid());
//        System.out.println("页面传送的uname是"+users.getUname());
//        System.out.println("页面传送的密码是"+users.getUpassword());
////        EmptyWrapper wq = new EmptyWrapper();
////wq.eq("uid",users.getUid());
////wq.eq("uname",users.getUname());
////wq.eq("upassword",users.getUpassword());
//        System.out.println(uname);
//        users.setUname(uname);
//        users.setUpassword(upassword);
//       int num= usersmapper.updateById(users);
//       System.out.println("num的值为"+num);
//        if(num==0){
//           return "succes";
//       }
//       return  "forward:/free";
//    }
//
//    @RequestMapping("/update2")
//    public String update2(Users users,Model model){
//        System.out.println("进入修改控制器");
//        System.out.println("页面传送的uid是"+users.getUid());
//        //System.out.println("页面传送的uname是"+users.getUname());
//        QueryWrapper wq = new QueryWrapper();
//        wq.eq("uid",users.getUid());
//        Users sers = usersmapper.selectOne(wq);
//        model.addAttribute("item",sers);
//        System.out.println("num的值为"+sers);
//        if(sers==null){
//            return "succes";
//        }
//        return  "show";
//    }
//
//

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
