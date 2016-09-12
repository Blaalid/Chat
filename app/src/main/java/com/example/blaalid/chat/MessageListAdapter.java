package com.example.blaalid.chat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blaalid on 10.09.2016.
 */

public class MessageListAdapter extends ArrayAdapter<Message> {

    private TextView chatText;
    private List<Message> chatMessageList = new ArrayList<Message>();
    private Context context;

    @Override
    public void add(Message object) {
        chatMessageList.add(object);
        super.add(object);
    }

    public MessageListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
    }

    public int getCount() {
        return this.chatMessageList.size();
    }

    public Message getItem(int index) {
        return this.chatMessageList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Message chatMessageObj = getItem(position);
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (chatMessageObj.left) {
            row = inflater.inflate(R.layout.right, parent, false);
        }else{
            row = inflater.inflate(R.layout.left, parent, false);
        }
        chatText = (TextView) row.findViewById(R.id.msgr);
        chatText.setText(chatMessageObj.message);
        return row;
    }
}

//public class MessageListAdapter extends ArrayAdapter<Message> {
//    public MessageListAdapter(Context context, List<Message> users){
//        super(context, 0, users);
//    }
//
//    private List<Message> chatMessageList = new ArrayList<Message>();
//
//    public void add(Message object){
//        chatMessageList.add(object);
//        super.add(object);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Message message = getItem(position);
//
//        if(convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_layout, parent, false);
//        }
//
//    ImageView person = (ImageView)convertView.findViewById(R.id.imageView);
//    TextView messageView = (TextView)convertView.findViewById(R.id.textView);
//
//    messageView.setText(message.getMessage());
//
//    return convertView;
//    }
//}
