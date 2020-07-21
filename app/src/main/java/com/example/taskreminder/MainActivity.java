package com.example.taskreminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout L1;
    EditText edtevent, edtdate;
    String streventtype;
    Button btnsubmitevent;
    Database base;
    RadioGroup rg_event;
    RadioButton rbbday,rbann,rbapp;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.darkmode:
                L1.setBackgroundColor(Color.GRAY);
                break;
            case R.id.lightmode:
                L1.setBackgroundColor(Color.WHITE);
                break;
            case R.id.Exit:
                finish();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbbday=findViewById(R.id.rb_bday);
        rbann=findViewById(R.id.rb_ann);
        rbapp=findViewById(R.id.rb_app);
        edtevent = findViewById(R.id.edt_event);
        edtdate = findViewById(R.id.edt_date);
        rg_event = findViewById(R.id.rg_event);
        btnsubmitevent = findViewById(R.id.btn_submitevent);

        base = new Database(getApplicationContext());
        int id = rg_event.getCheckedRadioButtonId();
        if(id == R.id.rb_bday)
        {
                streventtype="Birthday";
                Intent i3 = new Intent(getApplicationContext(), ListV.class);
                i3.putExtra("message_eventtype",streventtype);
                startActivity(i3);
            }
        if((id == R.id.rb_ann))
        {
                streventtype="Anniversary";
                Intent i3 = new Intent(getApplicationContext(), ListV.class);
                i3.putExtra("message_eventtype",streventtype);
                startActivity(i3);
            }
        if(id == R.id.rb_app)
            {
                streventtype="Appointment";
                Intent i3 = new Intent(getApplicationContext(), ListV.class);
                i3.putExtra("message_eventtype",streventtype);
                startActivity(i3);
            }
        btnsubmitevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strevent = edtevent.getText().toString();
                String strdate = edtdate.getText().toString();
                addTask();
                Intent i1 = new Intent(getApplicationContext(), ListV.class);
                i1.putExtra("message_event", strevent);
                startActivity(i1);
                Intent i2 = new Intent(getApplicationContext(), ListV.class);
                i2.putExtra("message_date", strdate);
                startActivity(i2);
            }
        });
    }

    private void addTask() {
        String events = edtevent.getText().toString();
        String date = edtdate.getText().toString();
        String eventtype = streventtype;
        Toast.makeText(this, "tye" + eventtype, Toast.LENGTH_SHORT).show();
        Event e = new Event();
        e.setEvent(events);
        e.setDate(date);
        e.setEventty(eventtype);
        long rowCount=base.saveEvent(e);
        if(rowCount>0)
        {
            Toast.makeText(this, rowCount+"Event created", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"no event created",Toast.LENGTH_LONG).show();
        }
    }
}