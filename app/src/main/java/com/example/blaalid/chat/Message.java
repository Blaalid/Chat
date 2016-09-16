package com.example.blaalid.chat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Blaalid on 10.09.2016.
 */

public class Message implements Serializable {
    String message;
    String name;
    Date timeNDate;

    public Message (String message, String name){
        this.message = message;
        this.timeNDate = new Date();
        this.name = name;
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
