package com.zt.service.impl;

import com.zt.entity.Images;
import com.zt.mapper.ImagesMapper;
import com.zt.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-09 16:04
 */
@Service
public class ImagesServiceImpl implements ImagesService {
@Autowired
   private ImagesMapper imagesMapper;

    @Override
    public List<Images> getimgesone(Images images) {
        return imagesMapper.getimgesone(images);
    }

    @Override
    public String imagesall(int cid ,String src) {
        return imagesMapper.imagesall(cid,src);
    }
    /*
     * 上传图片+卖车信息
     * */


    @Override
    public Images cidget() {
        return imagesMapper.cidget();
    }

}
