package com.example.blaalid.chat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.blaalid.chat.R.id.listView;

public class ContactActivity extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    RecyclerView rvContacts;

    ArrayList<Contact> contactList = new ArrayList();
    ListView conversationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        conversationView = (ListView) findViewById(R.id.contactsView);

        System.out.println("GÅR TIL ACT");
        listContacts();


    }




    private void listContacts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            readContacts();
        }
    }

    private void readContacts()
    {
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);  // gives you the list of contacts who has phone numbers

        while (cursor.moveToNext()) {

            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            Contact contact = new Contact(contactName);

            if(!contact.getContactName().contains("@")) {
                System.out.println(contact.getContactName());
                contactList.add(contact);
            }
        }
        showContacts();
    }

    private void showContacts(){
        ContactListAdapter contactLAdapter = new ContactListAdapter(ContactActivity.this, contactList);

        //rvContacts.setLayoutManager(new LinearLayoutManager(this));
        conversationView.setAdapter(contactLAdapter);

        conversationView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Contact contactName= (Contact) parent.getAdapter().getItem(position);
                Intent intent = new Intent(ContactActivity.this, MessagingActivity.class);
                startActivity(intent);
            }
        });




    }




}
