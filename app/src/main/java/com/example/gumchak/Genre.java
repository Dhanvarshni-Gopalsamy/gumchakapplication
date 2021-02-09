package com.example.gumchak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Genre extends AppCompatActivity {
    ImageView genrenext;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        //back button
        back=findViewById(R.id.b);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //navigate to position page
        genrenext = (ImageView) findViewById(R.id.LongShot);
        genrenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentgenre = new Intent(Genre.this, PositionPage.class);
                startActivity(intentgenre);

            }
        });


    }
}