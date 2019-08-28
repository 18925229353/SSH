package com.szxs.dao;

import com.szxs.entity.House;
import com.szxs.entity.Users;

import java.util.List;

public interface HouseDao {
    /**
     * 查询所有房屋信息
     * @return
     */
    List<House> queryAllHouses(House house,int pageNo,int PageSize);

    /**
     * 统计所有房屋总行数
     * @return
     */
    int countHouseRows(House house);

    /**
     * 增加房屋信息
     * @param house
     * @return
     */
    int saveHouse(House house);

}
