package com.example.taskreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    RecyclerView listView;
    ArrayAdapter<String> arrayAdapter;
    CustomAdapter adapter;
    List<Event> eventList;

    List<String> Events;
    List<String> Eventtype;
    Database base;
    int count=1;
    public void initItems()
    {
        Events = new ArrayList<>();
        Intent i1=getIntent();
        String strtask =i1.getStringExtra("message_event");
        Events.add(strtask);
        Eventtype = new ArrayList<>();
        Intent i3=getIntent();
        String streve=i3.getStringExtra("message_eventtype");
        Eventtype.add(streve);
        count=count+1;
    }
    public void init_list_view(){


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_v);
        Intent i2=getIntent();
        final String date =i2.getStringExtra("message_date");
        listView=findViewById(R.id.list_view);
        init_list_view();


        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = arrayAdapter.getItem(position);
                Toast.makeText(getApplicationContext(),"This task is scheduled for "+date,Toast.LENGTH_LONG).show();
            }
        });
         */

        base = new Database(getApplicationContext());
        eventList = new ArrayList<>();
        eventList = base.viewEvents();
        //initItems();

        //Task tsk = new Task();
        //tsk.setDate("somedate");
        //tsk.setEvent("Event Name");
        //tsk.setTask("some task");
        //taskList.add(tsk);
        Toast.makeText(getApplicationContext(), "got " + eventList.size(), Toast.LENGTH_LONG).show();
        adapter = new CustomAdapter(getApplicationContext(),eventList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        listView.setLayoutManager(manager);
        listView.setAdapter(adapter);
    }

}