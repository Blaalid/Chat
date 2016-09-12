package com.example.blaalid.chat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Blaalid on 10.09.2016.
 */

public class Message implements Serializable {
    boolean left;
    String message;
    Date timeNDate;

    public Message (boolean left, String message){
        this.message = message;
        this.timeNDate = new Date();
    }

    public Boolean getLeft() {
        return left;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimeNDate() {
        return timeNDate;
    }
}
