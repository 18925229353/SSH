package com.szxs.entity;


public class Type {

  private int id;
  private String name;

  public Type() {
  }

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

  public Type(int id) {
    this.id = id;
  }
}
