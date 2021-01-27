package com.example.gumchak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Button logout;
    Dialog dialog;
    private static final String  TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bottom nav
        BottomNavigationView btnNav=findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemReselectedListener(navListener);

        //Selecting Home Fragment as main Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,new HomeFragment()).commit();

        Bundle bundle=getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("cre")!=null){
                Toast.makeText(getApplicationContext(),"data:"+bundle.getString("cre"), Toast.LENGTH_LONG).show();
            }
        }

        //logout dialog
        Button logout=(Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.logout);
                dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations=R.style.animation;
                Button n=dialog.findViewById(R.id.cancel);
                Button y=dialog.findViewById(R.id.yes);

                n.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"cancel",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                y.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


        }

    //Listen Nav bar
    private BottomNavigationView.OnNavigationItemReselectedListener navListener=new
            BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;

                    switch (item.getItemId()) {
                        case R.id.item1:
                            selectFragment = new HomeFragment();
                            break;
                        case R.id.item2:
                            selectFragment = new MyvideosFragment();
                            break;
                        case R.id.item3:
                            selectFragment = new DownloadsFragment();
                            break;
                        case R.id.item4:
                            selectFragment = new UpdatesFragment();
                            break;
                        case R.id.item5:
                            selectFragment = new MyaccountFragment();
                            break;
                    }
                    //Begin Transaction
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_layout,
                                    selectFragment).commit();

                }

            };


}