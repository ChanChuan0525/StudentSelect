package com.chanchuan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id
    Long id;
    String number;
    String name;
    String specialty;
    String sClass;
    @Generated(hash = 1569373135)
    public Student(Long id, String number, String name, String specialty,
            String sClass) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.specialty = specialty;
        this.sClass = sClass;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecialty() {
        return this.specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getSClass() {
        return this.sClass;
    }
    public void setSClass(String sClass) {
        this.sClass = sClass;
    }
}
