package com.szxs.service.impl;

import com.szxs.dao.HouseDao;
import com.szxs.dao.impl.HouseDaoImpl;
import com.szxs.entity.House;
import com.szxs.service.HouseService;
import com.szxs.utils.Pager;

public class HouseServiceImpl implements HouseService {
    private HouseDao dao=new HouseDaoImpl();
    public Pager<House> queryAllHouses(House house, int pageNo, int pageSize) {
    Pager<House> pager=new Pager<House>();
    pager.setPageNo(pageNo);//设置当前页码
    pager.setPageSize(pageSize);//设置页大小
    pager.setTotalRows(dao.countHouseRows(house));//s设置总行数`
    pager.setTotalPage((pager.getTotalRows()+pageSize-1)/pageSize);//总页数

    pager.setDatas(dao.queryAllHouses(house,pageNo,pageSize));
        return pager;
    }

    public boolean saveHouse(House house) {

        return dao.saveHouse(house)>0;
    }
}
