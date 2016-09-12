package com.example.blaalid.chat;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
/**
 * Created by Blaalid on 12.09.2016.
 */

public class MessagingActivity extends Activity {

    private static final String TAG = "ChatActivity";

    private MessageListAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    private Button buttonSend;
    private boolean side = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messaging_activity);


        buttonSend = (Button) findViewById(R.id.sendButton);

    listView = (ListView) findViewById(R.id.listView);

    chatArrayAdapter = new MessageListAdapter(getApplicationContext(), R.layout.right);
    listView.setAdapter(chatArrayAdapter);

    chatText = (EditText) findViewById(R.id.messageText);
    chatText.setOnKeyListener(new View.OnKeyListener() {
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if ((event.getAction() == android.view.KeyEvent.ACTION_DOWN) && (keyCode == android.view.KeyEvent.KEYCODE_ENTER)) {
                return sendChatMessage();
            }
            return false;
        }
    });
    buttonSend.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            sendChatMessage();
        }
    });

    listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
    listView.setAdapter(chatArrayAdapter);

    //to scroll the list view to bottom on data change
    chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            listView.setSelection(chatArrayAdapter.getCount() - 1);
        }
    });
}

    private boolean sendChatMessage() {
        if("".equals(chatText.getText().toString())) {
            //do nothing
        }
        else{
            chatArrayAdapter.add(new Message(side, chatText.getText().toString()));
            chatText.setText("");
            side = !side;
        }
        return true;
    }
}
