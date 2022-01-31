package com.example.jobtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText company_name;
    EditText date_applied;
    ListView mylist;
    ArrayList<String> jobs;
    ArrayAdapter<String> myAdapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

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
        button.setOnClickListener(v -> {
            if(company_name.getText().length()>1 && date_applied.getText().length()>1) { // super bad way to prevent empty input
                String input = company_name.getText().toString() + " " + date_applied.getText().toString();
                jobs.add(input);
                myRef.push().setValue(input);
                myAdapter.notifyDataSetChanged();
                company_name.setText("");
                date_applied.setText("");
            }
        });

    }
}