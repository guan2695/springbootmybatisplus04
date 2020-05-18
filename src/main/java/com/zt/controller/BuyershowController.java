package com.zt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zt.entity.Buyershow;
import com.zt.entity.Comment;
import com.zt.service.BuyershowService;
import ikidou.reflect.TypeBuilder;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     *
     * @return
     */
    @RequestMapping("getAllShow")
    @ResponseBody
    public List<Buyershow> getAllBuyerShow(Model model) {
        System.out.println("进入查询所有买家秀的方法");
        List<Buyershow> showList = buyershowService.getAllShow();
        showList.forEach(System.out::println);
        return showList;
    }

    /**
     * 查看一个买家秀
     *
     * @param showid
     * @return
     */
    @RequestMapping("getOneShow")
    public String getOneBuyerShowByid(int showid,Model medel) {
        System.out.println("进入查询一个买家秀的方法");
        Buyershow buyershow = buyershowService.getOneShow(showid);
        System.out.println(buyershow);
        medel.addAttribute("onebuyershow",buyershow);

        System.out.println("得到所有评论");
        List<Comment> commentList = buyershowService.getAllCommentByshow(showid);
        commentList.forEach(System.out::println);
        medel.addAttribute("onecommentList",commentList);
        return "carsundetail";
    }



    @RequestMapping("/addComment")
    @ResponseBody
    public List<Comment> addComment(String showid,String uid,String comment01,Model medel) {
        System.out.println("进入添加评论方法"+showid+"\t"+uid+"\t"+comment01);
        if(showid==null&&uid==null&&comment01==null){
            System.out.println("Comment是空值");
        }

        Comment comment=new Comment();
        //得到当前时间
        Date da=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mytime=sdf.format(da);
        comment.setCdate(mytime);
        comment.setShowid(Integer.parseInt(showid));
        comment.setUid(Integer.parseInt(uid));
        comment.setComment(comment01);
        System.out.println(comment);


        System.out.println("进入添加评论方法");
        int num = buyershowService.addComment(comment);
        System.out.println(num);

        System.out.println("得到所有评论");
        List<Comment> commentList = buyershowService.getAllCommentByshow(comment.getShowid());
        commentList.forEach(System.out::println);
        return commentList;
    }

    @RequestMapping("/jlpageindex")
    public String Jlpageindex(String first3,Model medel,HttpSession session1){
        System.out.println("dsdsdsf");
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
    public List<Buyershow> Jlpageindex2(String first3,Model medel,HttpSession session1){
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

        List<Buyershow> accountlist= buyershowService.getPageIndex(first, pageSize);
        accountlist.forEach(System.out::println);

        return accountlist;
    }

    @RequestMapping("/jlpagecount2")
    @ResponseBody
    public String Jlpagecount2(String first3,Model medel,HttpSession session1){
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
       //存值
        String str=first2+"~"+count;
        return str;
        }


    @RequestMapping("/insertBuyshow")
    public String insertBuyshow(Buyershow buyershow, HttpServletRequest request) {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        //得到上传文件
        MultipartFile file = req.getFile("pic");
        //得到上传文件名
        String filename = file.getOriginalFilename();
        System.out.println("图片的名称" + filename);
        //上传目录的路径
        String path = request.getRealPath("templates/images") + "/" + filename;

        System.out.println("路径" + path);
        //创建目标路径
        File destfile = new File(path);
        //执行上传
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), destfile);
            System.out.println("上传成功");

            System.out.println(buyershow);

            buyershow.setImg(filename);
            int num = buyershowService.insertBuyershow(buyershow);
            System.out.println("成功与否"+num);
            if (num == 0) {
                return "forward:selectTranctionseller";
            }


        } catch (IOException e) {
            System.out.println("上传失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "forward:index";
    }
}

