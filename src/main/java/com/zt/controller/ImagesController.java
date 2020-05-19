package com.zt.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zt.entity.Images;
import com.zt.service.ImagesService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
        //得到上传文件名
        System.out.println("图片的名称" + src);
        Images Cid = imagesService.cidget();
        String img=imagesService.imagesall(Cid.getCid(),src);
        if(img!=null){
            System.out.println("添加成功");
            return "yes";
        }
        return "no";
    }
}
