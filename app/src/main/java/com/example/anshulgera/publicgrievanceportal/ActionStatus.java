package com.example.anshulgera.publicgrievanceportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActionStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_status);
        final EditText actionreport=(EditText)findViewById(R.id.actionreport);
        Button actionreportbutton=(Button)findViewById(R.id.actionreportbutton);
        actionreportbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(actionreport.getText().length()==0)
                    actionreport.setError("Enter Report Number");
            }
        });
    }
}
