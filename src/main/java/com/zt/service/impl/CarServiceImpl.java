package com.zt.service.impl;

import com.zt.entity.Car;
import com.zt.mapper.CarMapper;
import com.zt.mapper.UsersMapper;
import com.zt.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guan
 * @create 2020-05-08 14:15
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;
    @Override
    public List<Car> selectlimit() {
        return carMapper.selectlimit();
    }

    @Override
    public List<Car> selectCarage() {
        return carMapper.selectCarage();
    }

    @Override
    public List<Car> selectOprice() {
        return carMapper.selectOprice();
    }

    @Override
    public int insertCar(Car car) {
        return carMapper.insertCar(car);
    }

    @Override
    public int updateCarassesstate(Car car) {
        return carMapper.updateCarassesstate(car);
    }

    @Override
    public int updateCarputstate(Car car) {
        return carMapper.updateCarputstate(car);
    }

    @Override
    public List<Car> selectgetAssesstate(Car car) {
        return carMapper.selectgetAssesstate( car);
    }

    @Override
    public List<Car> selectgetPutstate(Car car) {
        return carMapper.selectgetPutstate(car);
    }

    @Override
    public List<Car> manyConditions(Car car) {
        return carMapper.manyConditions(car);
    }

    @Override
    public Car getCarone(Car car) {
        return carMapper.getCarone(car);
    }

    @Override
    public Car getCarinfo(Car car) {
        return carMapper.getCarinfo(car);
    }

    @Override
    public Car getCardinfomax(Car car) {
        return carMapper.getCardinfomax(car);
    }
}
