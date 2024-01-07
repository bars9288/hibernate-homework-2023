package ru.hh.school.entity;

//TODO: оформите entity  +++++

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

 @Entity
 @Table (name = "area")
 public class Area {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "area_id")
  private Integer id;
  @Column(name = "name", length = 100, nullable = false, unique = true)
  // по хорошему можно Column не писать - но явны требования по длине и нулл
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Area() {}  // вроде бы это дб обязательно
}
