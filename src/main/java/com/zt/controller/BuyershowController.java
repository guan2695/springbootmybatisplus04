package com.zt.controller;

import com.zt.entity.Buyershow;
import com.zt.entity.Comment;
import com.zt.service.BuyershowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
