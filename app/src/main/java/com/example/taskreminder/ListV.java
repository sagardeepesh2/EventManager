package com.example.taskreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListV extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    List<String> tasks;
    List<String> Event;
    Database base;
    int count=1;
    public void initItems()
    {
        tasks = new ArrayList<>();
        Intent i1=getIntent();
        String strtask =i1.getStringExtra("message_task");
        tasks.add(strtask);
        Event = new ArrayList<>();
        Intent i3=getIntent();
        String streve=i3.getStringExtra("message_event");
        Event.add(streve);
        count=count+1;
    }
    public void init_list_view(){
        initItems();
        arrayAdapter=new ArrayAdapter(this,R.layout.list_view,R.id.custom_text,tasks);
        listView.setAdapter(arrayAdapter);
        arrayAdapter=new ArrayAdapter(this,R.layout.list_view,R.id.event_text,Event);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_v);
        Intent i2=getIntent();
        final String date =i2.getStringExtra("message_date");
        listView=findViewById(R.id.list_view);
        init_list_view();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = arrayAdapter.getItem(position);
                Toast.makeText(getApplicationContext(),"This task is scheduled for "+date,Toast.LENGTH_LONG).show();
            }
        });
    }

}