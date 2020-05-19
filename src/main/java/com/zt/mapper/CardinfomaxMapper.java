package com.zt.mapper;

import com.zt.entity.Cardinfomax;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author guan
 * @create 2020-05-08 17:04
 */
@Mapper
public interface CardinfomaxMapper {
    /**
     * 插入车的详细信息
     * @param cardinfomax
     * @return
     */
    public int insertCardinfomax(Cardinfomax cardinfomax);

    /**
     * 得到一辆车的高级信息
     * @param cid
     * @return
     */
    @Select("SELECT * FROM cardinfomax WHERE cid=#{cid}")
    public Cardinfomax getOneCardinfoMax(int cid);

    public String infomax(int cid,Double pailiang,String youtype,int youname,String dangtype);
    public Cardinfomax focid();
}
