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
    private int conversationId;
    public static DomainSingleton SINGLETON;

    private List<List<Message>> data = new ArrayList<>();

    private DomainSingleton() {}


    public static synchronized DomainSingleton getSingleton(Context context) {
        if(SINGLETON == null) {
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

    public synchronized List<Message> createConversation() {
        List<Message> result = new ArrayList<>();
        getData().add(result);
        return result;
    }

//    public String getNameAndMessage(){
//        String tempName;
//        List<Message> tempList = new ArrayList<>();
//        for (List<Message> temp : data) {
//            tempList = temp;
//            for(Message tempMessage : tempList){
//                tempMessage.getName();
//                return tempName;
//            }
//            return tempName;
//        }
//        return tempName;
//    }

    public synchronized String getMessageName(){
        String name = "";
        if(getData().size() != 0) {
            for(int i = 0; i < getData().size(); i++) {
                Message message = getData().get(conversationId).get(i);
                name = message.getName();
           }
            return name;
        }
        else {
            return name;
        }
    }
}