package com.example.blaalid.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blaalid on 12.09.2016.
 */

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton newChat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Conversations");

        newChat = (FloatingActionButton) findViewById(R.id.newChatButton);
        newChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                handleChatActivity();
            }
        });

        if (DomainSingleton.getSingleton(this).getData().size() > 0) {
            listView = (ListView) findViewById(R.id.mainListView);
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DomainSingleton.getSingleton(this).getAllContacts());
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Message message = DomainSingleton.getSingleton(MainActivity.this).getMessage(position);
                    String mesContactName = arrayAdapter.getItem(position);
                    int mesConvId = message.conversationId;
                    Intent intent = new Intent(MainActivity.this, MessagingActivity.class);
                    intent.putExtra("CONVERSATION_ID", mesConvId);
                    intent.putExtra("CONTACT_NAME", mesContactName);
                    startActivity(intent);
                }
            });
        }
    }


    public void handleChatActivity() {
        Intent intent = new Intent(MainActivity.this, ContactActivity.class);
        startActivity(intent);
    }
}