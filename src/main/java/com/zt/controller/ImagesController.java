package com.zt.controller;

import com.zt.entity.Images;
import com.zt.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-09 16:07
 */
@Controller
public class ImagesController {
    @Autowired
    private ImagesService imagesService;

    @RequestMapping("/getimages")
    public String getimages(Model model, Images images){
        images.setCid(1);
        List<Images> listimages = imagesService.getimgesone(images);
        model.addAttribute("listimages",listimages);
        return "images";
    }
    @RequestMapping("/imagesall")
    @ResponseBody
    public String imagesall(String src){
        System.out.println("--------------imagesall--------------");
        Images Cid = imagesService.cidget();
        String img=imagesService.imagesall(Cid.getCid(),src);
        if(img!=null){
            System.out.println("添加成功");
            return "yes";
        }
        return "no";
    }
}
