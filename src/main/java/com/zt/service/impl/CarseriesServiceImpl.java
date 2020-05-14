package com.zt.service.impl;

import com.zt.entity.Cardseries;
import com.zt.mapper.CardseriesMapper;
import com.zt.service.CarseriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-13 19:17
 */
@Service
public class CarseriesServiceImpl implements CarseriesService {
    @Autowired
    private CardseriesMapper cardseriesMapper;

    @Override
    public List<Cardseries> getCardSeriesByBrand(int bid) {
        return cardseriesMapper.getCardSeriesByBrand(bid);
    }
}
