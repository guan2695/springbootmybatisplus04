package com.zt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zt.entity.Buyershow;
import com.zt.entity.Comment;
import com.zt.service.BuyershowService;
import ikidou.reflect.TypeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 19:24
 */
@Controller
public class BuyershowController {

    @Autowired
    private BuyershowService buyershowService;

    /**
     * 得到所有的买家秀
     * @return
     */
    @RequestMapping("getAllShow")
    @ResponseBody
    public List<Buyershow> getAllBuyerShow(Model model){
        System.out.println("进入查询所有买家秀的方法");
        List<Buyershow> showList= buyershowService.getAllShow();
        showList.forEach(System.out::println);
        return showList;
    }

    /**
     * 查看一个买家秀
     * @param showid
     * @return
     */
    @RequestMapping("getOneShow")
    @ResponseBody
    public Buyershow getOneBuyerShowByid(int showid){
        System.out.println("进入查询一个买家秀的方法");
        Buyershow buyershow= buyershowService.getOneShow(showid);
        System.out.println(buyershow);
        System.out.println("得到所有评论");
        List<Comment> commentList= buyershowService.getAllCommentByshow(showid);
        commentList.forEach(System.out::println);
        return buyershow;
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @RequestMapping("/addComment")
    @ResponseBody
    public int addComment(Comment comment){
        System.out.println("进入添加评论方法");
        int num= buyershowService.addComment(comment);
        System.out.println(num);
        return num;
    }

    @RequestMapping("/jlpageindex")
    public String Jlpageindex(String first3,Model medel,HttpSession session1){
        if(first3==null){
            first3="0";
        }
        int first1 = Integer.parseInt(first3);
        //分页
        int pageSize=6;
        //查询页码
        System.out.println(first1);
        int first=0;
        if(first1!=0){
            first=(first1-1)*pageSize;
        }
        //总页数
        int count=buyershowService.getPageCount();
        if(count<=0){
            System.out.println("获取总页数失败！！！");
           // return "redirect:index.jsp";
        }
        if(count%pageSize==0){
            count=count/pageSize;
        }else{
            count=count/pageSize+1;
        }
        System.out.println("总页数"+count);

        //显示页码
        int first2=0;
        if(first!=0){
            first2=(first/pageSize+1);
        }else{
            first2=1;
        }
        System.out.println("显示页数"+first2);

        List<Buyershow> accountlist= buyershowService.getPageIndex(first, pageSize);
        accountlist.forEach(System.out::println);
        //存值
        medel.addAttribute("accountlist",accountlist);  //保存数组
        medel.addAttribute("carsunconnt",count);              //总页数
        medel.addAttribute("firstxs",first2);              //页码

        session1.setAttribute("first", first);  //实际页码


        //转发跳转（不经过后端控制器）
        return "carsun";
    }

    @RequestMapping("/jlpageindex2")
    @ResponseBody
    public String Jlpageindex2(String first3,Model medel,HttpSession session1){
        if(first3==null){
            first3="0";
        }
        int first1 = Integer.parseInt(first3);
        //分页
        int pageSize=6;
        //查询页码
        System.out.println(first1);
        int first=0;
        if(first1!=0){
            first=(first1-1)*pageSize;
        }
        //总页数
        int count=buyershowService.getPageCount();
        if(count<=0){
            System.out.println("获取总页数失败！！！");
            // return "redirect:index.jsp";
        }
        if(count%pageSize==0){
            count=count/pageSize;
        }else{
            count=count/pageSize+1;
        }
        System.out.println("总页数"+count);

        //显示页码
        int first2=0;
        if(first!=0){
            first2=(first/pageSize+1);
        }else{
            first2=1;
        }
        System.out.println("显示页数"+first2);

        List<Buyershow> accountlist= buyershowService.getPageIndex(first, pageSize);
        accountlist.forEach(System.out::println);

        //存值
        String str=first2+"~"+count+"~"+ JSONArray.toJSONString(accountlist);
        System.out.println(str);
        return str;
    }



}
