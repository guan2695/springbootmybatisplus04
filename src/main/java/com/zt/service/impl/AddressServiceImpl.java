package com.zt.service.impl;

import com.zt.entity.Address;
import com.zt.mapper.AddressMapper;
import com.zt.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-08 9:39
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAllAddress() {
        return addressMapper.getAllAddress();
    }
}
