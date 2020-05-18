package com.zt.mapper;

import com.zt.entity.Car;
import com.zt.entity.Images;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-09 16:02
 */
@Mapper
public interface ImagesMapper {
    public List<Images> getimgesone (Images images);

    public String imagesall(int cid,String src);
    public Images cidget();
    /**
     * 根据车id得到他的六张图片
     * @param cid
     * @return
     */
    @Select("SELECT * FROM images WHERE cid=#{cid}")
    public List<Images> getImagesByCarid(int cid);
}
