package com.example.winify.cvsi.dto.builder;


import com.example.winify.cvsi.dto.ConversationDto;
import com.example.winify.cvsi.model.Conversation;

/**
 * Created by Artemie on 02.07.2016.
 */
public class ConversationBuilder {
    public ConversationDto getConversationDto(Conversation conversation)
    {
        ConversationDto conversationDto = new ConversationDto();
        conversationDto.setId(conversation.getId());
        conversationDto.setMessageList(conversation.getMessageList());
        conversationDto.setTitle(conversation.getProduct().getTitle());
        conversationDto.setReceptorSurname(conversation.getProduct().getUser().getSurname());
        return conversationDto;
    }
}
