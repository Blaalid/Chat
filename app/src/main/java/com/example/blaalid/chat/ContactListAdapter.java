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
    private Context mContext;
    public ContactListAdapter( Context context, ArrayList<Contact> contactList){
        super(context, 0, contactList);
        this.contactList = contactList;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Contact currentContact = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_contact_view, parent, false);
        }
        TextView contactName = (TextView) convertView.findViewById(R.id.tvContactName);
        TextView tvPhonenr = (TextView) convertView.findViewById(R.id.tvPhoneNumber);

        // Populate the data into the template view using the data object
        contactName.setText(currentContact.getContactName());//
        tvPhonenr.setText("121212"); //Take in para
        // Return the completed view to render on screen
        return convertView;
    }

    public Contact getItem(int position){

        return contactList.get(position);
    }




    /*@Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_contact_view,null);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position){
        Contact contact = contactList.get(position);
        holder.tvContactName.setText(contact.getContactName());
        holder.tvPhoneNumber.setText(contact.getContactNumber());
    }

    @Override
    public int getItemCount(){
        return contactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView ivContactImage;
        TextView tvContactName;
        TextView tvPhoneNumber;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ivContactImage = (ImageView) itemView.findViewById(R.id.ivContactImage);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
        }
    }*/

}
