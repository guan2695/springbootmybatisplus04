package com.zt.controller;

import com.zt.entity.User;
import com.zt.mapper.Usersmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author guan
 * @create 2020-04-24 14:54
 */
@Controller
public class Usercontroller {
    @Autowired
    private Usersmapper usersmapper;

@RequestMapping("/free")
    public String testfreemake(Model modelmap){
    System.out.println(" --------Select--------- ");
            List<User> list=usersmapper.selectList(null);
    for (User users : list) {
       // System.out.println(users.getUpassword());
    }
    modelmap.addAttribute("list",list);
return "succes";

}
    @RequestMapping("/login")
    public String login(Model modelmap,User user){
        System.out.println(" --------login--------- ");
        System.out.println("uname"+user.getUname());
       User list2=usersmapper.selectlogin(user);
        modelmap.addAttribute("list2",list2);
        return "success";

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
//    @RequestMapping("/add")
//    public String add(Users users,Model model){
//        System.out.println("add()");
//        System.out.println("页面传送的uid是"+users.getUid());
//        System.out.println("页面传送的uname是"+users.getUname());
//
//        int num= usersmapper.insert(users);
//        System.out.println("num的值为"+num);
//        if(num==0){
//            return "succes";
//        }
//        return  "forward:/free";
//    }
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
