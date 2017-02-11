package com.example.anshulgera.publicgrievanceportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class ProgressDetails extends AppCompatActivity {

    String url5,name,aadhar,mobno,address,district,desc,date,progress;
    Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_details);
        url5=getIntent().getStringExtra("url");
        name=getIntent().getStringExtra("name");
        progress=getIntent().getStringExtra("pro");
        aadhar=getIntent().getStringExtra("aadhar");
        mobno=getIntent().getStringExtra("mob");
        address=getIntent().getStringExtra("address");
        district=getIntent().getStringExtra("dist");
        desc=getIntent().getStringExtra("des");
        date=getIntent().getStringExtra("date");

        final TextView name1= (TextView) findViewById(R.id.name3);
        final TextView aadhar1= (TextView) findViewById(R.id.aadhar3);
        final TextView mobno1= (TextView) findViewById(R.id.mobno3);
        final TextView date1= (TextView) findViewById(R.id.date3);
        final TextView address1= (TextView) findViewById(R.id.address3);
        final TextView district1= (TextView) findViewById(R.id.district3);
        final TextView description1= (TextView) findViewById(R.id.description3);
        final TextView progress1 = (TextView) findViewById(R.id.progressdetail3);

        name1.setText(name);
        aadhar1.setText(aadhar);
        mobno1.setText(mobno);
        date1.setText(date);
        address1.setText(address);
        district1.setText(district);
        description1.setText(desc);
        progress1.setText(progress);




    }
}
