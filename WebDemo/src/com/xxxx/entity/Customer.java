package com.xxxx.entity;

public class Customer {
    private Integer customerId;
    private Integer userId;
    private String name;
    private String address;
    private String registeredTime;
    private String updatedTime;

    public Customer() {
    }

    public Customer(Integer customerId, Integer userId, String name, String address, String registeredTime, String updatedTime) {
        this.customerId = customerId;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.registeredTime = registeredTime;
        this.updatedTime = updatedTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
