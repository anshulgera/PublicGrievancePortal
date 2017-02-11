package com.example.anshulgera.publicgrievanceportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Citizen_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_home);
        Button lodgegrievance= (Button) findViewById(R.id.lodgegrievance);
        Button lodgereminder= (Button) findViewById(R.id.lodgereminder);
        Button actionstatus= (Button) findViewById(R.id.actionstatus);
        lodgegrievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(Citizen_home.this,LodgeGrievance.class);
                startActivity(i3);
            }
        });
        lodgereminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(Citizen_home.this,LodgeReminder.class);
                startActivity(i4);
            }
        });
        actionstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5=new Intent(Citizen_home.this,ActionStatus.class);
                startActivity(i5);
            }
        });
    }
}
