package com.szxs.entity;


import java.util.Date;

public class House {

  private Integer id;
  private String title;
  private String description;
  private int price;
  private Date pubDate;
  private int floorage;
  private String contact;
  private Users users;
  private int typeId;
  private Street street;
  private int streetId;
  private String houseImg;

    public String getHouseImg() {
        return houseImg;
    }

    public void setHouseImg(String houseImg) {
        this.houseImg = houseImg;
    }

    public int getStreetId() {
    return streetId;
  }

  public void setStreetId(int streetId) {
    this.streetId = streetId;
  }

  public House() {
  }

  public Street getStreet() {
    return street;
  }

  public void setStreet(Street street) {
    this.street = street;
  }

  public House(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Date getPubDate() {
    return pubDate;
  }

  public void setPubDate(Date pubDate) {
    this.pubDate = pubDate;
  }

  public int getFloorage() {
    return floorage;
  }

  public void setFloorage(int floorage) {
    this.floorage = floorage;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public int getTypeId() {
    return typeId;
  }

  public void setTypeId(int typeId) {
    this.typeId = typeId;
  }


  @Override
  public String toString() {
    return "House{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            ", pubDate=" + pubDate +
            ", floorage=" + floorage +
            ", contact='" + contact + '\'' +
            ", users=" + users +
            ", typeId=" + typeId +
            ", street=" + street +
            '}';
  }
}