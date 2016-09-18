package com.example.blaalid.chat;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Blaalid on 17.09.2016.
 */


public class DomainSingleton {
    public static DomainSingleton SINGLETON;
    private List<String> allContactNames = new ArrayList<>();
    private List<List<Message>> data = new ArrayList<>();

    private DomainSingleton() {
    }


    public static synchronized DomainSingleton getSingleton(Context context) {
        if (SINGLETON == null) {
            SINGLETON = new DomainSingleton();
        }

        return SINGLETON;
    }

    public synchronized List<List<Message>> getData() {
        return data;
    }

    public synchronized List<Message> getConversation(int conversationId) {
        return getData().get(conversationId);
    }

    public synchronized List<String> getAllContacts() {
        String contactName;
        if (getData().size() > 0) {
            for (int i = 0; i < getData().size(); i++) {
                contactName = getMessage(i).getName();
                if (!allContactNames.contains(contactName)) {
                    allContactNames.add(contactName);
                }
            }
        }
        return allContactNames;
    }

    public synchronized List<Message> createConversation() {
        List<Message> result = new ArrayList<>();
        getData().add(result);
        return result;
    }

    public synchronized int getIdByName(String contactName) {
        Message message;
        int convId = 0;
        int i;
        for (i = 0; i < getData().size(); i++) {
            message = getMessage(i);
            if (contactName == message.getName()) {
                convId = message.getConversationId();
            }
        }
        return convId;
    }


    public synchronized Message getMessage(int i) {

        Message message = getData().get(i).get(0);
        return message;
    }


}

