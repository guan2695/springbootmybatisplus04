package com.zt.controller;

import com.zt.entity.History;
import com.zt.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author guan
 * @create 2020-05-13 11:24
 */
@Controller
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @RequestMapping("/selectHistory")
    public String selectHistory(History history, String uid, Model model, HttpSession session){

        if(uid==null){
            uid="0";
        }else {
            int uid2 = Integer.parseInt(uid);
            history.setUid(uid2);
           List<History> listHistory= historyService.selectHistory(history);
           model.addAttribute("listHistory",listHistory);
        }
        return "forward:index";
    }
    @RequestMapping("/deleteHistory")
    @ResponseBody
    public int deleteHistory(History history,int uid,HttpSession session){
        System.out.println("进入删除");
        System.out.println("进入删除浏览记录");
        history.setUid(uid);
        session.setAttribute("listHistory",null);
//        session.removeAttribute("listHistory");
       int num= historyService.deleteUidHistory(history);
        return num;

    }



}
