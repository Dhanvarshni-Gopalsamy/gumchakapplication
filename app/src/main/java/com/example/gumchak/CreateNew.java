package com.example.gumchak;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateNew extends AppCompatActivity {

    Button next,back;
    static EditText pro_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        next = (Button) findViewById(R.id.next);
        //project name
        pro_name = (EditText) findViewById(R.id.project_name);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = pro_name.getText().toString();
                Intent intent2 = new Intent(CreateNew.this, PerformancePage.class);
                intent2.putExtra("message_key", str);
                startActivity(intent2);

            }
        });

        back=findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //logout dialog
        findViewById(R.id.logout11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CreateNew.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.logout, viewGroup, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });


    }


    }
