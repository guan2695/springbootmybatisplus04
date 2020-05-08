package com.zt.mapper;

import com.zt.entity.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-07 19:43
 */
@Mapper
public interface CarMapper {
    /**
     * 首页查询九辆车
     * @return
     */
    public List<Car> selectlimit();

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
}
