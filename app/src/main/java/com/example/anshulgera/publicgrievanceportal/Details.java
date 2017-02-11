package com.example.anshulgera.publicgrievanceportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

public class Details extends AppCompatActivity {


    Firebase ref,ref2;
    String q;
    String url,url2;
    String iname,iaadhar,imobno,ipin,idistrict,ides,iemail,iaddress,idate,ireminder,iprogress;
    String progressinfo;
    Button submitprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        submitprogress = (Button) findViewById(R.id.button6);
        final TextView name = (TextView) findViewById(R.id.name1);
        final TextView aadhar = (TextView) findViewById(R.id.aadhar1);
        final TextView mobno = (TextView) findViewById(R.id.mobno1);
        final TextView date = (TextView) findViewById(R.id.date1);
        final TextView address = (TextView) findViewById(R.id.address1);
        final TextView pincode = (TextView) findViewById(R.id.pincode1);
        final TextView district = (TextView) findViewById(R.id.district1);
        final TextView email = (TextView) findViewById(R.id.email1);
        final TextView description = (TextView) findViewById(R.id.description1);
        final EditText progress = (EditText) findViewById(R.id.progress);
        final TextView reminder = (TextView) findViewById(R.id.textView2);
        final TextView progress1 = (TextView) findViewById(R.id.progressdetail);


        q = getIntent().getStringExtra("query");
        url = getIntent().getStringExtra("url");
        url2 = url + "/" + q;
        Toast.makeText(Details.this, q, Toast.LENGTH_SHORT).show();
        ref = new Firebase(url);
        ref2 = new Firebase(url2);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    Complaints complaints = item.getValue(Complaints.class);
                    String s = complaints.getDate() + " and " + complaints.getAadharNo();
                    if (s.equalsIgnoreCase(q)) {
                        iname = complaints.getName();
                        iaadhar = complaints.getAadharNo();
                        iaddress = complaints.getAddress();
                        idistrict = complaints.getDistrict();
                        iemail = complaints.getEmail();
                        ipin = complaints.getPincode();
                        imobno = complaints.getMobileNo();
                        idate = complaints.getDate();
                        ides = complaints.getDescription();
                        ireminder = complaints.getReminder();
                        iprogress = complaints.getProgress();

                        name.setText(iname);
                        aadhar.setText(iaadhar);
                        mobno.setText(imobno);
                        date.setText(idate);
                        address.setText(iaddress);
                        pincode.setText(ipin);
                        email.setText(iemail);
                        district.setText(idistrict);
                        description.setText(ides);
                        reminder.setText(ireminder);
                        progress1.setText(iprogress);


                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        submitprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressinfo = progress.getText().toString();
                Firebase mProgress = ref2.child("Progress");
                mProgress.setValue(progressinfo);


            }
        });


    }

}
