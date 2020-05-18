package com.zt.controller;

import com.zt.entity.Talk;
import com.zt.entity.User;
import com.zt.service.TalkService;
import com.zt.service.UserService;
import freemarker.template.SimpleDate;
import javafx.scene.input.DataFormat;
import org.apache.tomcat.util.descriptor.tld.TldParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author xyq
 * @create 2020-05-18 8:51
 */
@Controller
public class TalkController {

    @Autowired
    private TalkService talkService;

    @Autowired
    private UserService userService;

    /**
     * 用户进入聊天页面，查看未读消息
     * @param meid
     * @param model
     * @return
     */
    @RequestMapping("/inTalk")
    public String inTalk(int meid, Model model){
        System.out.println("查看未读消息");
        List<Talk> untalkList= talkService.getUnreadGroup(meid);
        untalkList.forEach(System.out::println);
        model.addAttribute("untalkList",untalkList);
        return "talk";
    }

    /**
     * 查看消息
     * @param meid
     * @param otherid
     * @return
     */
    @RequestMapping("/getTalkinfo")
    @ResponseBody
    public List<Talk> getTalkInfo(int meid,int otherid){
        System.out.println("查看消息");
        List<Talk> talkList= talkService.getTalkHistory(meid,otherid);
        talkList.forEach(System.out::println);
        //已读
        talkService.updTalkState(meid,otherid);
        return talkList;
    }

    /**
     * 发送消息
     * @param talk
     * @return
     */
    @RequestMapping("/sendTalk")
    @ResponseBody
    public String sendTalk(@RequestBody Talk talk){
        System.out.println("进入发送消息："+talk);

        Long l=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        String date=sdf.format(l);
        talk.setTalkdate(date);

        int num= talkService.sendTalk(talk);
        if(num>0){
            return "yes";
        }
        return "no";
    }

    /**
     * 发起聊天
     * @param otherid
     * @return
     */
    @RequestMapping("/newTalk")
    public String newTalk(int otherid, HttpSession session,Model model){
        User user= (User) session.getAttribute("list2");
        int meid= user.getUid();
        User meuser= userService.getOneUserById(meid);
        User otheruser= userService.getOneUserById(otherid);

        Long l=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        String talkdate= sdf.format(l);

        Talk talk=new Talk();
        talk.setMeuser(meuser);
        talk.setOtheruser(otheruser);
        talk.setTalkdate(talkdate);

        List<Talk> talkList= talkService.getTalkHistory(meid,otherid);

        model.addAttribute("talkList",talkList);
        model.addAttribute("t",talk);
        return "talknew";
    }

    /**
     * 得到所有消息列表
     * @param meid
     * @return
     */
    @RequestMapping("/getAllTalk")
    public String getAllTalkList(int meid,Model model){
        System.out.println("进入查看消息列表"+meid);
        List<Talk> talkList= talkService.getAllTalk(meid);
        talkList.forEach(System.out::println);
        model.addAttribute("untalkList",talkList);
        return "talknew";
    }


}
