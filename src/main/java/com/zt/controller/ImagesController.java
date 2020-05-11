package com.zt.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zt.entity.Images;
import com.zt.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
