package com.example.blaalid.chat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Blaalid on 12.09.2016.
 */

public class ContactActivity extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    ArrayList<Contact> contactList = new ArrayList();
    ListView conversationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        conversationView = (ListView) findViewById(R.id.contactsView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.contactActivityToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Select contact");
        listContacts();
    }

    private void listContacts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            readContacts();
        }
    }

    private void readContacts() {
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);  // gives you the list of contacts who has phone numbers

        while (cursor.moveToNext()) {

            String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            Contact contact = new Contact(contactName);

            if (!contact.getContactName().contains("@")) {
                System.out.println(contact.getContactName());
                contactList.add(contact);
            }
        }
        showContacts();
    }

    private void showContacts() {
        final ContactListAdapter contactLAdapter = new ContactListAdapter(ContactActivity.this, contactList);

        conversationView.setAdapter(contactLAdapter);
        conversationView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String contactName = contactLAdapter.getItem(position).getContactName();
                Intent intent = new Intent(ContactActivity.this, MessagingActivity.class);

                if (DomainSingleton.getSingleton(ContactActivity.this).getAllContacts().contains(contactName)) {
                    int mesConvId = DomainSingleton.getSingleton(ContactActivity.this).getIdByName(contactName);
                    intent.putExtra("CONTACT_NAME", contactName);
                    intent.putExtra("CONVERSATION_ID", mesConvId);
                } else {
                    intent.putExtra("CONTACT_NAME", contactName);


                }
                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
