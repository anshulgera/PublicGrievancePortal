package com.example.anshulgera.publicgrievanceportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LodgeReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodge_reminder);
        final EditText reportnumber=(EditText)findViewById(R.id.reportnumber);
        Button lodgereminder=(Button)findViewById(R.id.reminderbutton);
        lodgereminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(reportnumber.getText().length()==0)
                    reportnumber.setError("Enter Report Number");
            }
        });
    }
}
