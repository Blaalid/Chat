//package com.example.blaalid.chat;
//
///**
// * Created by Blaalid on 12.09.2016.
// */
//
//import android.content.ContentResolver;
//import android.database.Cursor;
//import android.provider.ContactsContract;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List; .....xD ska eg aktivere d? nai ekje so viktig, funka d?

//
//public class AllContacts extends AppCompatActivity {
//
//    RecyclerView rvContacts;
//
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_all_contacts);
////
////        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
////
////        getAllContacts();
////    }
//
//    public void getAllContacts() {
//        List<Contact> contactList = new ArrayList();
//        Contact contact;
//
//        ContentResolver contentResolver = getContentResolver();
//        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
//        if (cursor.getCount() > 0) {
//            while (cursor.moveToNext()) {
//
//                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
//                if (hasPhoneNumber > 0) {
//                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//
//                    contact = new Contact();
//                    contact.setContactName(name);
//
//                    Cursor phoneCursor = contentResolver.query(
//                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                            null,
//                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
//                            new String[]{id},
//                            null);
//                    if (phoneCursor.moveToNext()) {
//                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        contact.setContactNumber(phoneNumber);
//                    }
//
//                    phoneCursor.close();
//
//                    Cursor emailCursor = contentResolver.query(
//                            ContactsContract.CommonDataKinds.Email.CONTENT_URI,
//                            null,
//                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
//                            new String[]{id}, null);
//                    while (emailCursor.moveToNext()) {
//                        String emailId = emailCursor.getString(emailCursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
//                    }
//                    contactList.add(contact);
//                }
//            }
//
//            ContactListAdapter contactAdapter = new ContactListAdapter(getApplicationContext(),contactList);
//            rvContacts.setLayoutManager(new LinearLayoutManager(this));
//            rvContacts.setAdapter(contactAdapter);
//        }
//    }
//}