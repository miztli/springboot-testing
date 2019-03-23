package com.example.testing.models;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "User")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")	
  private Long id;

  @Column(name = "name", nullable = false, length = 50)	
  private String name;
  
  @Column(name = "address", nullable = false, length = 100)	
  private String address;

  @Column(name = "age")	
  private Integer age;

  @Column(name = "active")	
  private Boolean active;

  public void setId(Long id) {
    this.id = id; 
  }

  public Long getId() {
    return id; 
  }
  public void setName(String name) {
    this.name = name; 
  }

  public String getName(String name) {
    return name; 
  }
  
  public void setAddress(String address) {
    this.address = address; 
  }
   
  public String getAddress(String address) {
    return address; 
  } 
  
  public void setAge(Integer age) {
    this.age = age; 
  }
   
  public Integer getAge() {
    return age; 
  } 

  public void setActive(Boolean active) {
    this.active = active; 
  }
  
  public Boolean isActive() {
    return active; 
  }
} 
