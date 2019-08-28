package com.szxs.entity;
/*
* 街道
* */

import java.util.Set;

public class Street {
  private int id;
  private String name;
private District district;
private Set<House> houseSet;

  public Set<House> getHouseSet() {
    return houseSet;
  }

  public void setHouseSet(Set<House> houseSet) {
    this.houseSet = houseSet;
  }

  public District getDistrict() {
    return district;
  }

  public void setDistrict(District district) {
    this.district = district;
  }

  public Street() {
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

  public Street(District district) {
    this.district = district;
  }

  public Street(String name, District district) {
    this.name = name;
    this.district = district;
  }

  public Street(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    return ((Street)o).getId() == this.getId();
  }

  @Override
  public int hashCode() {
    return this.getId();
  }


  public Street(String name) {
    this.name = name;

  }

  @Override
  public String toString() {
    return
            "id=" + id +
            ", name='" + name + '\'' +
            ", district=" + district;
  }
}
