package com.example.anshulgera.publicgrievanceportal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class AdminLoginSuccess extends AppCompatActivity {

    private ListView listView;
    private Button button;
    private Firebase mRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private ArrayList<String> complaints=new ArrayList<>();
    Button button1,button2,button3;
    String url;
    String x,y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_success);




        mAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


                if(firebaseAuth.getCurrentUser()!=null)
                {
                    Toast.makeText(AdminLoginSuccess.this,"Login Successful",Toast.LENGTH_SHORT).show();
                }
            }
        };

        button1= (Button) findViewById(R.id.button3);
        button2= (Button) findViewById(R.id.button4);
        button3= (Button) findViewById(R.id.button5);
        listView = (ListView) findViewById(R.id.listView);


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,complaints);
        listView.setAdapter(arrayAdapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               url="https://publicgrievancesystem.firebaseio.com/WaterDept";
                Toast.makeText(AdminLoginSuccess.this,"WaterDept",Toast.LENGTH_SHORT).show();
                complaints.clear();
                mRef=new Firebase(url);
                mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot users) {
                        for(DataSnapshot user : users.getChildren()){
                            Complaints complaint=user.getValue(Complaints.class);
                            String s=complaint.getDate()+" and "+complaint.getAadharNo();
                            complaints.add(s);
                            arrayAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url="https://publicgrievancesystem.firebaseio.com/PWD";
                Toast.makeText(AdminLoginSuccess.this,"PWD",Toast.LENGTH_SHORT).show();
                complaints.clear();
                mRef=new Firebase(url);
                mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot users) {
                        for(DataSnapshot user : users.getChildren()){
                            Complaints complaint=user.getValue(Complaints.class);
                            String s=complaint.getDate()+" and "+complaint.getAadharNo();
                            complaints.add(s);
                            arrayAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url="https://publicgrievancesystem.firebaseio.com/MunicipalCorp";
                Toast.makeText(AdminLoginSuccess.this,"MunicipalCorporation",Toast.LENGTH_SHORT).show();
                complaints.clear();
                mRef=new Firebase(url);
                mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot users) {
                        for(DataSnapshot user : users.getChildren()){
                            Complaints complaint=user.getValue(Complaints.class);
                            String s=complaint.getDate()+" and "+complaint.getAadharNo();
                            complaints.add(s);
                            arrayAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });


            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = ((TextView)view ).getText().toString();
                Intent intent = new Intent(AdminLoginSuccess.this,Details.class);
                intent.putExtra("query",item);
                intent.putExtra("url",url);
                Toast.makeText(AdminLoginSuccess.this,item,Toast.LENGTH_SHORT);
                startActivity(intent);


            }
        });


    }

    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Tap back button in order to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }
}
