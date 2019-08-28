package com.szxs.service;

import com.szxs.entity.House;
import com.szxs.utils.Pager;

public interface HouseService {
    /**
     * 查询所有房屋信息
     * @return
     */
    Pager<House> queryAllHouses(House house, int pageNo, int pageSize);
    /**
     * 增加房屋信息
     * @param house
     * @return
     */
    boolean saveHouse(House house);
}
