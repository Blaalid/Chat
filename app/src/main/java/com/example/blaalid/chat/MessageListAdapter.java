package com.example.blaalid.chat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Blaalid on 10.09.2016.
 */

public class MessageListAdapter extends ArrayAdapter<Message> {
    public MessageListAdapter(Context context, List<Message> users){
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_layout, parent, false);
        }

    ImageView person = (ImageView)convertView.findViewById(R.id.imageView);
    TextView messageView = (TextView)convertView.findViewById(R.id.textView);

    messageView.setText(message.getMessage());

    return convertView;
    }
}
