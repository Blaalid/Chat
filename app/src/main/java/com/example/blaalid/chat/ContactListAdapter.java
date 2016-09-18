package com.example.blaalid.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Blaalid on 12.09.2016.
 */

public class ContactListAdapter extends ArrayAdapter<Contact> {

    private List<Contact> contactList;
    private Context Context;

    public ContactListAdapter(Context context, ArrayList<Contact> contactList) {
        super(context, 0, contactList);
        this.contactList = contactList;
        this.Context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_contact_view, parent, false);
        }
        TextView contactName = (TextView) convertView.findViewById(R.id.tvContactName);
        TextView tvPhoneNr = (TextView) convertView.findViewById(R.id.tvPhoneNumber);

        contactName.setText(contact.getContactName());
        tvPhoneNr.setText(contact.getContactNumber());
        return convertView;
    }

}
