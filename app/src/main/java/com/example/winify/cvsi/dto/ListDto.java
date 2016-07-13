package com.example.winify.cvsi.dto;


import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.enums.ErrorEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artemie on 01.07.2016.
 */
public class ListDto<T> extends ServerResponseStatus implements Serializable {

    private List<T> list;

    public ListDto(){
        list = new ArrayList<T>();
    }

    public ListDto(List<T> list) {
        this.list = list;
    }

    public ListDto(ErrorEnum error, String status, List<T> list) {
        super(error, status);
        this.list = list;
    }

    public ListDto(ServerResponseStatus serverResponseStatus, List<T> list) {
        super(serverResponseStatus);
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> genericList) {
        this.list = genericList;
    }
}
