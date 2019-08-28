package com.szxs.entity;


import java.util.Set;

public class Users {

  private int id;
  private String name;
  private String passWord;
  private String telePhone;
  private String userName;
  private int isAdmin;
  private Set<House> houseSet;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public String getTelePhone() {
    return telePhone;
  }

  public void setTelePhone(String telePhone) {
    this.telePhone = telePhone;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(int isAdmin) {
    this.isAdmin = isAdmin;
  }

  public Set<House> getHouseSet() {
    return houseSet;
  }

  public void setHouseSet(Set<House> houseSet) {
    this.houseSet = houseSet;
  }

  @Override
  public String toString() {
    return "Users{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", passWord='" + passWord + '\'' +
            ", telePhone='" + telePhone + '\'' +
            ", userName='" + userName + '\'' +
            ", isAdmin=" + isAdmin +
            '}';
  }

  public Users(String name, String passWord) {
    this.name = name;
    this.passWord = passWord;
  }

  public Users(String name, String passWord, String telePhone, String userName) {
    this.name = name;
    this.passWord = passWord;
    this.telePhone = telePhone;
    this.userName = userName;
  }

  public Users() {
  }
}
