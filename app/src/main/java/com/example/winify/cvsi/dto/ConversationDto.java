package com.example.winify.cvsi.dto;


import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.model.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artemie on 02.07.2016.
 */
public class ConversationDto extends ServerResponseStatus implements Serializable {
    private Long id;
    private String receptorSurname;
    private String title;
    private List<Message> messageList = new ArrayList<Message>();

    public String getReceptorSurname() {
        return receptorSurname;
    }

    public void setReceptorSurname(String receptorSurname) {
        this.receptorSurname = receptorSurname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
