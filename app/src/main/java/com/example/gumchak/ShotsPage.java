package com.example.gumchak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShotsPage extends AppCompatActivity {
    ImageView shotsnext;
Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shots_page);

        //back button
        back=findViewById(R.id.ba);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //navigate to position page
        shotsnext = (ImageView) findViewById(R.id.Sitting);
        shotsnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentshots = new Intent(ShotsPage.this, InstrumentsPage.class);
                startActivity(intentshots);

            }
        });
    }
}