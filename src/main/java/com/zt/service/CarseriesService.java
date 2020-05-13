package com.zt.service;

import com.zt.entity.Cardseries;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-13 19:16
 */
public interface CarseriesService {
    public List<Cardseries> getCardSeriesByBrand(int bid);
}
