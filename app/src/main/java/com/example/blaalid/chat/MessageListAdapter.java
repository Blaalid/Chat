package com.example.blaalid.chat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blaalid on 10.09.2016.
 */

public class MessageListAdapter extends ArrayAdapter<Message> {

    private List<Message> chatMessageList;
    private Context context;

    public MessageListAdapter(Context context, ArrayList<Message> chatMessageList) {
        super(context, 0, chatMessageList);
        this.context = context;
    }



    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_layout, parent, false);
        }

        TextView chatText = (TextView) convertView.findViewById(R.id.textView);
        chatText.setText(message.getMessage());
        return convertView;
    }
}

