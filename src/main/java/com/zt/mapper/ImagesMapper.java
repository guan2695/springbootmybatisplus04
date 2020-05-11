package com.zt.mapper;

import com.zt.entity.Images;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-09 16:02
 */
@Mapper
public interface ImagesMapper {
    public List<Images> getimgesone (Images images);
}
