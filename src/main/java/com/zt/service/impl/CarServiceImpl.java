package com.zt.service.impl;

import com.zt.entity.Car;
import com.zt.mapper.CarMapper;
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
    public int insertCar(Car car) {
        return carMapper.insertCar(car);
    }
}
