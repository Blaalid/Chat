package com.example.blaalid.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton newChat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chat");

        newChat = (FloatingActionButton) findViewById(R.id.newChatButton);
        listView = (ListView) findViewById(R.id.mainListView);

        newChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                handleChatActivity();
            }
        });
    }

    public void handleChatActivity(){
    Intent intent = new Intent(MainActivity.this, ContactActivity.class);
        startActivity(intent);
    }
}