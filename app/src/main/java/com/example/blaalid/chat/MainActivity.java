package com.example.blaalid.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton newChat;
    private List<String> contactNames = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chat");

        newChat = (FloatingActionButton) findViewById(R.id.newChatButton);
        newChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                handleChatActivity();
            }
        });

        if(DomainSingleton.getSingleton(this).getData().size() != 0) {
            for(int i = 0; i < DomainSingleton.getSingleton(this).getData().size(); i++) {
                contactNames.add(DomainSingleton.getSingleton(this).getMessageName());
                listView = (ListView) findViewById(R.id.mainListView);
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contactNames);
                listView.setAdapter(arrayAdapter);
            }
        }
    }

    public void handleChatActivity(){
    Intent intent = new Intent(MainActivity.this, ContactActivity.class);
        startActivity(intent);
    }
}