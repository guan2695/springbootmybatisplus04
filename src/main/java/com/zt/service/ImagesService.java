package com.zt.service;

import com.zt.entity.Images;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-09 16:03
 */
public interface ImagesService {
    public List<Images> getimgesone (Images images);

    /*
     * 上传图片
     * */
    public String imagesall(int cid ,String src);
    public Images cidget();
}
