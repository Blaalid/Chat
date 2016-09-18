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

import java.util.ArrayList;
import java.util.List;


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
        newChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                handleChatActivity();
            }
        });

        if(DomainSingleton.getSingleton(this).getData().size() > 0) {
                listView = (ListView) findViewById(R.id.mainListView);
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DomainSingleton.getSingleton(this).getAllContacts());
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


    public void handleChatActivity(){
    Intent intent = new Intent(MainActivity.this, ContactActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                return true;

            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}