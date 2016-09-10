package com.example.blaalid.chat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Blaalid on 10.09.2016.
 */

public class Message implements Serializable {
    String user;
    String message;
    Date timeNDate;

    public Message (String user, String message){
        this.user = user;
        this.message = message;
        this.timeNDate = new Date();
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimeNDate() {
        return timeNDate;
    }
}
