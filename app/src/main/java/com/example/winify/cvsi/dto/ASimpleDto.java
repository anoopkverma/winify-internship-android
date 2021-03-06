package com.example.winify.cvsi.dto;


import com.example.winify.cvsi.dto.error.ServerResponseStatus;

/**
 * Created by Artemie on 22.06.2016.
 */
public class ASimpleDto extends ServerResponseStatus {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Long createTime;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
