package com.example.winify.cvsi.model;


import com.example.winify.cvsi.model.enums.RoleEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Artemie on 24.06.2016.
 */
public class User implements Serializable {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String name;
    private Boolean isOnline;
    private String surname;
    private Date createdDate;
    private Date updatedDate;
    private List<Conversation> conversationList = new ArrayList<Conversation>();
    private List<Product>  productList = new ArrayList<Product>();
    private List<RoleEnum> roleEnumList = new ArrayList<RoleEnum>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Conversation> getConversationList() {
        return conversationList;
    }

    public void setConversationList(List<Conversation> conversationList) {
        this.conversationList = conversationList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<RoleEnum> getRoleEnumList() {
        return roleEnumList;
    }

    public void setRoleEnumList(List<RoleEnum> roleEnumList) {
        this.roleEnumList = roleEnumList;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }
}
