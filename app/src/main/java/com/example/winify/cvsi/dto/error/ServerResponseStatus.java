package com.example.winify.cvsi.dto.error;


import com.example.winify.cvsi.enums.ErrorEnum;

import java.io.Serializable;

/**
 * Created by Artemie on 22.06.2016.
 */
public class ServerResponseStatus implements Serializable{
    private ErrorEnum error;
    private String status;

    public ServerResponseStatus() {
        status = "OK";
    }

    public ServerResponseStatus(ErrorEnum error, String status) {
        this.error = error;
        this.status = status;
    }

    public ServerResponseStatus(ServerResponseStatus serverResponseStatus){
        this.error = serverResponseStatus.getError();
        this.status = serverResponseStatus.getStatus();
    }

    public ErrorEnum getError() {
        return error;
    }

    public void setError(ErrorEnum error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
