package com.zt.service;

import com.zt.entity.Car;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-08 14:14
 */
public interface CarService {
    /**
     * 首页查询前九辆
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
     */
    public int insertCar(Car car);

    /**
     * 评估状态修改
     */
    public int updateCarassesstate(Car car);

    /**
     * 上架状态修改
     */
    public int updateCarputstate(Car car);

    /**
     * 查询评估完成的车辆或者未完成的车辆
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
     * 查询一辆车的六张图片
     * 后续跳进查询一辆车的详细信息方法
     */
    public Car getCarone(Car car);

    /**
     * 查询一辆车的详细信息
     */
    public Car getCarinfo(Car car);
    /**
     * 查询一辆车的详细信息max
     */
    public Car getCardinfomax(Car car);
}
