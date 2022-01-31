package com.example.jobtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText company_name;
    EditText date_applied;
    ListView mylist;
    ArrayList<String> jobs;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        company_name = findViewById(R.id.add_company_name);
        date_applied = findViewById(R.id.add_date_applied);
        mylist = (ListView) findViewById(R.id.list_view);
        jobs = new ArrayList<String>();
        final Button button = findViewById(R.id.submit);
        myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jobs);
        mylist.setAdapter(myAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                jobs.add(company_name.getText().toString() + " " + date_applied.getText().toString());
                myAdapter.notifyDataSetChanged();
            }
        });

    }
}