package com.example.winify.cvsi.model;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Artemie on 30.06.2016.
 */
public class ForgotPassword implements Serializable {
    private Long id;
    private String email;
    private String hash;
    private Date requestCreatedDate;

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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getRequestCreatedDate() {
        return requestCreatedDate;
    }

    public void setRequestCreatedDate(Date requestCreatedDate) {
        this.requestCreatedDate = requestCreatedDate;
    }
}
