package com.example.gumchak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PositionPage extends AppCompatActivity {
    ImageView positionnext;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_page);

        //back button
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //navigate to shots page
        positionnext = (ImageView) findViewById(R.id.Sitting);
        positionnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentposition = new Intent(PositionPage.this, ShotsPage.class);
                startActivity(intentposition);

            }
        });
    }
}