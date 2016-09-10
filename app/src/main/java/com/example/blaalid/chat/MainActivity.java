package com.example.blaalid.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List data = Arrays.asList(
                new Message("Inge","Message #1"),
                new Message("Inge","Message #2"),
                new Message("Inge","Message #3"),
                new Message("Inge","Message #4"),
                new Message("Inge","Message #5"),
                new Message("Inge","Message #6"),
                new Message("Inge","Message #7"),
                new Message("Inge","Message #8"),
                new Message("Inge","Message #9"),
                new Message("Inge","Message #10")
                );
        MessageListAdapter mla = new MessageListAdapter(getApplicationContext(),data);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(mla);
    }
}
