package com.example.blaalid.chat;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blaalid on 12.09.2016.
 */

public class MessagingActivity extends AppCompatActivity {
    public static final String CONVERSATION_ID = "conversationid";
    public static final String CONTACT_NAME = "contactname";
    private static final String TAG = "ChatActivity";

    private MessageListAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    private Button buttonSend;
    private String newString;
    private List<Message> messageList = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messaging_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.messageToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra("CONTACT_NAME"));

        if(savedInstanceState == null){
            if(intent == null){
                newString= null;
            }
            else{
                newString= intent.getStringExtra("CONTACT_NAME");
            }
        }

        else{
            newString= (String) savedInstanceState.getSerializable("CONTACT_NAME");
        }

        int conversationId = intent.getIntExtra(CONVERSATION_ID,-1);
        DomainSingleton service = DomainSingleton.getSingleton(this);

        if(conversationId != -1) {
            messageList = service.getConversation(conversationId);
        }  else {
            messageList = service.createConversation();
            conversationId = service.getData().size() -1; // OBS not threadsafe

        }


    buttonSend = (Button) findViewById(R.id.sendButton);
    listView = (ListView) findViewById(R.id.messageListView);

    chatArrayAdapter = new MessageListAdapter(this, messageList);
    listView.setAdapter(chatArrayAdapter);
    chatText = (EditText) findViewById(R.id.messageText);

    buttonSend.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sendChatMessage();
        }
    });



    //to scroll the list view to bottom on data change

}

    private void sendChatMessage() {
        if("".equals(chatText.getText().toString())) {
            //do nothing
        }
        else{
            messageList.add(new Message(chatText.getText().toString(), newString));
            chatText.setText("");
            updateScrollDown();

        }
    }

    private void updateScrollDown(){
    listView.postDelayed(new Runnable(){
            @Override
            public void run(){
                listView.setSelection(listView.getCount());
                listView.smoothScrollToPosition(listView.getCount());
            }
        }, 100);
        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
                onBackPressed();

                return true;

            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}


