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
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout L1;
    EditText edttask, edtdate;
    Button btnsubmittask;
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
        edttask = findViewById(R.id.edt_task);
        edtdate = findViewById(R.id.edt_date);
        btnsubmittask = findViewById(R.id.btn_submittask);
        boolean rbbdaystate=rbbday.isChecked();
        if(rbbdaystate==true)
        {
                String strEvent="Birthday";
                Intent i3 = new Intent(getApplicationContext(), ListV.class);
                i3.putExtra("message_event",strEvent);
                startActivity(i3);
            }
        boolean rbannstate=rbann.isChecked();
        if(rbannstate==true)
        {
                String strEvent="Anniversary";
                Intent i3 = new Intent(getApplicationContext(), ListV.class);
                i3.putExtra("message_event",strEvent);
                startActivity(i3);
            }
        boolean rbappstate=rbapp.isChecked();
            if(rbappstate==true)
            {
                String strEvent="Appointment";
                Intent i3 = new Intent(getApplicationContext(), ListV.class);
                i3.putExtra("message_event",strEvent);
                startActivity(i3);
            }
        btnsubmittask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strtask = edttask.getText().toString();
                String strtime = edtdate.getText().toString();
                Intent i1 = new Intent(getApplicationContext(), ListV.class);
                i1.putExtra("message_task", strtask);
                startActivity(i1);
                Intent i2 = new Intent(getApplicationContext(), ListV.class);
                i2.putExtra("message_date", strtime);
                startActivity(i2);
            }
        });
    }
}