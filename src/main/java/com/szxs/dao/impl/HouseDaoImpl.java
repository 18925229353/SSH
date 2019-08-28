package com.szxs.dao.impl;

import com.szxs.dao.HouseDao;
import com.szxs.entity.House;
import com.szxs.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class HouseDaoImpl implements HouseDao {

    public List<House> queryAllHouses(House house,int pageNo,int pageSize) {
        Session session= HibernateUtil.openSession();
      StringBuilder hql=new StringBuilder("from House where 1=1 ");
      if(house!=null){


      if(house.getTitle()!=null && !"".equals(house.getTitle())){
          house.setTitle("%"+house.getTitle()+"%");
          hql.append(" and title like :title");
      }
      if(house.getPrice()>0){
          switch (house.getPrice()){
              case 1:
                  hql.append(" and price <=100");
                  break;
              case 2:
                  hql.append(" and price >100 and price <= 200");
                  break;
              case 3:
                  hql.append(" and price > 200");
                  break;
          }
      }
      if( house.getStreetId()>0){
          hql.append(" and street.id = :streetId");
      }
      if(house.getTypeId()>0){
          hql.append(" and typeId = :typeId");
      }
      if(house.getFloorage()>0){
          switch (house.getFloorage()){
              case 1:
                  hql.append(" and floorage < 40");
                  break;
              case 2:
                  hql.append(" and floorage >= 40 and floorage < 500");
                  break;
              case 3:
                  hql.append(" and floorage > 500");
                  break;
          }
      }
      }
        hql.append(" order by id desc ");
        Query query = session.createQuery(hql.toString());
      if(house!=null){
          query.setProperties(house);
      }
        query.setFirstResult((pageNo-1)*pageSize);//设置当前页码
        query.setMaxResults(pageSize); //设置页大小
        List<House> list = query.list();
        return list;
    }

    public int countHouseRows(House house) {
        Session session= HibernateUtil.openSession();
        StringBuilder hql=new StringBuilder("select count(id) from House where 1= 1");
        if(null!=house){
        if(house.getTitle()!=null && !"".equals(house.getTitle())){
            house.setTitle("%"+house.getTitle()+"%");
            hql.append(" and title like :title");
        }
        if(house.getPrice()>0){
            switch ( house.getPrice()){
                case 1:
                    hql.append(" and price <= 100");
                    break;
                case 2:
                    hql.append(" and price >100 and price <= 200");
                    break;
                case 3:
                    hql.append(" and price > 200");
                    break;
            }
        }
        if( house.getStreetId()>0){
            hql.append(" and street.id = :streetId");
        }
        if(house.getTypeId()>0){
            hql.append(" and typeId = :typeId");
        }
        if(house.getFloorage()>0){
            switch (house.getFloorage()){
                case 1:
                    hql.append(" and floorage < 40");
                    break;
                case 2:
                    hql.append(" and floorage >= 40 and floorage < 500");
                    break;
                case 3:
                    hql.append(" and floorage > 500");
                    break;
            }
        }
}
        Query query = session.createQuery(hql.toString());
        if(house!=null){
            query.setProperties(house);
        }
        return ((Long)query.uniqueResult()).intValue();
    }

    public int saveHouse(House house) {
        Session session = HibernateUtil.getSession();
        Integer id =(Integer)session.save(house);
        return id;
    }
}
