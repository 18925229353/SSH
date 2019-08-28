package com.szxs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.szxs.entity.House;
import com.szxs.entity.Users;
import com.szxs.service.HouseService;
import com.szxs.service.impl.HouseServiceImpl;
import com.szxs.utils.Pager;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.util.Date;


public class HouseAction extends ActionSupport {
    private HouseService houseServiceBiz = new HouseServiceImpl();
    private Pager<House> pager=null;
    private  House house;
    private int number=1;
    private File houseImg;//上传文件
    private  String houseImgFileName;//文件名
    private  String houseImgContentType;//文件类型


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Pager<House> getHouses() {
        return pager;
    }

    public String showListHouse() {
        pager=houseServiceBiz.queryAllHouses(house,number,5);
        for (House h:pager.getDatas()){
            System.out.println(h.getHouseImg());
        }
        return SUCCESS;
    }
    public String addHouse() throws  Exception{
        house.setPubDate(new Date());
        house.setHouseImg(houseImgFileName);
        String path=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("images");
        FileUtil.copyFile(houseImg,new File(path+File.separator+houseImgFileName));
        house.setUsers((Users) ServletActionContext.getRequest().getSession().getAttribute("users"));
        if(houseServiceBiz.saveHouse(house)){
            return "toHouseList";
        }
        return "add";
    }
    public Pager<House> getPager() {
        return pager;
    }

    public void setPager(Pager<House> pager) {
        this.pager = pager;
    }

    public File getHouseImg() {
        return houseImg;
    }

    public void setHouseImg(File houseImg) {
        this.houseImg = houseImg;
    }

    public String getHouseImgFileName() {
        return houseImgFileName;
    }

    public void setHouseImgFileName(String houseImgFileName) {
        this.houseImgFileName = houseImgFileName;
    }

    public String getHouseImgContentType() {
        return houseImgContentType;
    }

    public void setHouseImgContentType(String houseImgContentType) {
        this.houseImgContentType = houseImgContentType;
    }
}
