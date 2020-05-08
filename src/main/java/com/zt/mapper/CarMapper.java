package com.zt.mapper;

import com.zt.entity.Car;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-07 19:43
 */
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
}
