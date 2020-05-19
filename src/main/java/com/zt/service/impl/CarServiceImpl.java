package com.zt.service.impl;

import com.zt.entity.Car;
import com.zt.entity.Transaction;
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
    public List<Car> manyCar(Car car, int first, int pageSize) {
         return carMapper.manyCar(car,first,pageSize);
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

    @Override
    public List<Car> adminGetCarByPage(int pageIndex, int pageSize) {
        pageIndex=(pageIndex-1)*pageSize;
        return carMapper.adminGetCarByPage(pageIndex,pageSize);
    }

    @Override
    public List<Car> adminGetPageCount() {
        return carMapper.adminGetPageCount();
    }

    @Override
    public Car GetOneCarAllInfo(int cid) {
        return carMapper.GetOneCarAllInfo(cid);
    }

    @Override
    public int adminUpdCar(Car car) {
        return carMapper.adminUpdCar(car);
    }

    @Override
    public List<Car> selectTranction(Transaction transaction) {
        return carMapper.selectTranction(transaction);
    }

    @Override
    public List<Car> selectTranctionseller(Transaction transaction) {
        return carMapper.selectTranctionseller(transaction);
    }

    @Override
    public List<Car> jiangPageconut(Car car) {
        return carMapper.jiangPageconut(car);
    }

    @Override
    public String carall(int bid, int csid, int corolid, int uid, Double oprice, Double price, int addressid, int carage, String img){return carMapper.carall(bid, csid, corolid, uid, oprice, price, addressid, carage, img); }
    @Override
    public String carimg(int cid ,String src) {
        return carMapper.carimg(cid,src);
    }

    @Override
    public Car carcid() {
        return carMapper.carcid();
    }
}
