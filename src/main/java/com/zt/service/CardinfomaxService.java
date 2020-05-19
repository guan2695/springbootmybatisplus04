package com.zt.service;

import com.zt.entity.Cardinfomax;

/**
 * @author guan
 * @create 2020-05-08 17:05
 */
public interface CardinfomaxService {
    public int insertCardinfomax(Cardinfomax cardinfomax);

    public String infomax(int cid,Double pailiang,String youtype,int youname,String dangtype);
    public Cardinfomax focid();
}
