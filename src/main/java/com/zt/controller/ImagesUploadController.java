package com.zt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ImagesUploadController {

    @RequestMapping("/imagesUpload")
    public String imagesUpload(MultipartFile[] uploadFiles, HttpServletRequest request){
        System.out.println(uploadFiles.length);
        if (uploadFiles.length > 0&&uploadFiles==null) {
            for (int i = 0; i < uploadFiles.length; i++) {
                MultipartFile uploadFile = uploadFiles[i];
                //设置上传文件的位置在该项目目录下的uploadFile文件夹下，并根据上传的文件日期，进行分类保存
                String realPath = "D:/springbootmybatisplus04/src/main/resources/templates/images";
                System.out.println("相对路径："+realPath);
                String oldName = uploadFile.getOriginalFilename();
                System.out.println("文件名 = " + oldName);
                File folder = new File(realPath+"/"+oldName);
                if (!folder.isDirectory()) {
                    folder.mkdirs();
                }
//                String newName = UUID.randomUUID().toString() + oldName.
//                        substring(oldName.lastIndexOf("."), oldName.length());
//                System.out.println("newName = " + newName);
                try {
                    //保存文件
                    uploadFile.transferTo(folder);
                    //生成上传文件的访问路径
//                    String filePath = request.getScheme() + "://" + request.getServerName() + ":"+ request.getServerPort() + "/uploadFile" ;
//                    list.add(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    } else if (uploadFiles.length == 0) {
            return "forward:getusercarall";
        }
        return "forward:getusercarall";
    }

}

