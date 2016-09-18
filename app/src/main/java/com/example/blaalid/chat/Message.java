package com.example.blaalid.chat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Blaalid on 10.09.2016.
 */

public class Message implements Serializable {
    String message;
    String name;
    int conversationId;
    Date timeNDate;

    public Message(String message, String name, int conversationId) {
        this.message = message;
        this.timeNDate = new Date();
        this.name = name;
        this.conversationId = conversationId;
    }

    public int getConversationId() {
        return conversationId;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public Date getTimeNDate() {
        return timeNDate;
    }
}
