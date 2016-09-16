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

import java.util.ArrayList;

/**
 * Created by Blaalid on 12.09.2016.
 */

public class MessagingActivity extends AppCompatActivity {

    private static final String TAG = "ChatActivity";

    private MessageListAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    private Button buttonSend;
    private String newString;
    ArrayList<Message> messageList = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messaging_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.messageToolbar);
        setSupportActionBar(toolbar);



        Bundle extras = getIntent().getExtras();
        Intent i = getIntent();
     //   setTitle(i.getStringExtra("CONTACT_NAME"));
        setTitle(extras.getString("CONTACT_NAME"));

        if(savedInstanceState == null){
            if(extras == null){
                newString= null;
            }
            else{
                newString= extras.getString("CONTACT_NAME");
            }
        }

        else{
            newString= (String) savedInstanceState.getSerializable("CONTACT_NAME");
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

    listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

    //to scroll the list view to bottom on data change
    chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            listView.setSelection(chatArrayAdapter.getCount() - 1);
        }
    });
}

    private void sendChatMessage() {
        if("".equals(chatText.getText().toString())) {
            //do nothing
        }
        else{
            messageList.add(new Message(chatText.getText().toString(), newString));
            chatText.setText("");
        }
    }
 }


