package com.zt.service;

import com.zt.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:38
 */
public interface AddressService {
    public List<Address> getAllAddress();
}
