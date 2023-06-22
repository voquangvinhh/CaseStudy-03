package com.example.casestudy.model.entity;


public class Staff {
    private int id;
    private String name;
    private String birthday;
    private String sex;
    private String phoneNumber;
    private String email;
    private String address;

    public Staff() {
    }

    public Staff(int id, String name, String birthday, String sex, String phoneNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Staff(String name, String birthday, String sex, String phoneNumber, String email, String address) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
