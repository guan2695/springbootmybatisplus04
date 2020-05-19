package com.zt.mapper;

import com.zt.entity.Car;
import com.zt.entity.Transaction;
import com.zt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-07 19:43
 */
@Mapper
public interface CarMapper  {
    /**
     * 首页查询九辆车
     * @return
     */
    public List<Car> selectlimit();

    /**首页根据车龄查询
     *
     */
    public List<Car> selectCarage();

    /**首页根据降价大于十万查询
     *
     */
    public List<Car> selectOprice();

    /**
    * 卖车
     *
    */
public int insertCar(Car car);

    /**评估状态修改
     *
     */
    public int updateCarassesstate(Car car);

    /**
     * 上架状态修改
     */
    public int updateCarputstate(Car car);

    /**
     * 查询评估完成的车辆或已评估的车辆
     */
    public List<Car> selectgetAssesstate(Car car);

    /**
     * 查询已评估未上架的车辆或已上架的车辆
     */
    public List<Car> selectgetPutstate(Car car);

    /**
     * 多条件查询车辆
     */
    public List<Car> manyConditions(Car car);

    /**
     * 多条件查询车辆且分页
     * @param car
     * @param first
     * @param pageSize
     * @return
     */
    public List<Car> manyCar(Car car,@Param("first") int first, @Param("pageSize") int pageSize);


    /**
     * 查询一辆车的六张图片
     * 后续跳进查询一辆车的详细信息方法
     */
    public Car getCarone(Car car);

    /**
     * 查询一辆车的详细信息
     */
    public Car getCarinfo(Car car);

    /**
     * 查询一辆车的详细信息
     */
    public Car getCardinfomax(Car car);


    /**
     * 分页遍历所有车的信息
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM car limit #{pageIndex},#{pageSize}")
    @Results({
            @Result(column = "bid",property = "brand",one = @One(select = "com.zt.mapper.BrandMapper.getOneBrandById")),
            @Result(column = "csid",property = "cardseries",one = @One(select = "com.zt.mapper.CardseriesMapper.getCarseriesByid")),
            @Result(column = "corolid",property = "corol",one = @One(select = "com.zt.mapper.CorolMapper.getCorolByid")),
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "addressid",property = "address",one = @One(select = "com.zt.mapper.AddressMapper.getAddressByid")),
            @Result(column = "cid",property = "imagesList",many = @Many(select = "com.zt.mapper.ImagesMapper.getImagesByCarid"))
    })
    public List<Car> adminGetCarByPage(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);


    /**
     * 模糊查询
     * @param search
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM car WHERE bid IN (SELECT bid FROM brand WHERE bname LIKE '%${search}%') \n" +
            "OR csid IN (SELECT csid FROM cardseries WHERE csname LIKE '%${search}%') limit #{pageIndex},#{pageSize}")
    @Results({
            @Result(column = "bid",property = "brand",one = @One(select = "com.zt.mapper.BrandMapper.getOneBrandById")),
            @Result(column = "csid",property = "cardseries",one = @One(select = "com.zt.mapper.CardseriesMapper.getCarseriesByid")),
            @Result(column = "corolid",property = "corol",one = @One(select = "com.zt.mapper.CorolMapper.getCorolByid")),
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "addressid",property = "address",one = @One(select = "com.zt.mapper.AddressMapper.getAddressByid")),
            @Result(column = "cid",property = "imagesList",many = @Many(select = "com.zt.mapper.ImagesMapper.getImagesByCarid"))
    })
    public List<Car> searchCarByPage(@Param("search") String search,@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);

    /**
     * 模糊查询总页数
     * @param search
     * @return
     */
    @Select("SELECT count(*) carage FROM car WHERE bid IN (SELECT bid FROM brand WHERE bname LIKE '%${search}%') OR csid IN (SELECT csid FROM cardseries WHERE csname LIKE '%${search}%')")
    public Car searchCarPageCount(@Param("search") String search);


    /**
     * 得到一辆车的所有信息，所有！！！
     * @param cid
     * @return
     */
    @Select("SELECT * FROM car where cid=#{cid}")
    @Results({
            @Result(column = "bid",property = "brand",one = @One(select = "com.zt.mapper.BrandMapper.getOneBrandById")),
            @Result(column = "csid",property = "cardseries",one = @One(select = "com.zt.mapper.CardseriesMapper.getCarseriesByid")),
            @Result(column = "corolid",property = "corol",one = @One(select = "com.zt.mapper.CorolMapper.getCorolByid")),
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "addressid",property = "address",one = @One(select = "com.zt.mapper.AddressMapper.getAddressByid")),
            @Result(column = "cid",property = "imagesList",many = @Many(select = "com.zt.mapper.ImagesMapper.getImagesByCarid")),
            @Result(column = "cid",property = "carinfo",one = @One(select = "com.zt.mapper.CarinfoMapper.getOneCarinfo")),
            @Result(column = "cid",property = "cardinfomax",one = @One(select = "com.zt.mapper.CardinfomaxMapper.getOneCardinfoMax"))
    })
    public Car GetOneCarAllInfo(@Param("cid") int cid);

    /**
     * 得到所有的车集合，获取总条数
     * @return
     */
    @Select("SELECT * FROM car")
    public List<Car> adminGetPageCount();

    /**
     * 管理员修改车的四个属性
     * @param car
     * @return
     */
    @Update("UPDATE car SET bid=#{bid},csid=#{csid},corolid=#{corolid},addressid=#{addressid} WHERE cid=#{cid}")
    public int adminUpdCar(Car car);

    /**
     * 查询对应用户所买的车
     *
     */
    public List<Car> selectTranction(Transaction transaction);
    /**
     *  查询对应用户所卖的车
     */
    public List<Car> selectTranctionseller(Transaction transaction);

    /**
     * 多条件查询车辆得总页数
     */
    public List<Car> jiangPageconut(Car car);
}
