package com.example.anshulgera.publicgrievanceportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Idle extends AppCompatActivity {

    ProgressBar progressBar;
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idle);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        thread = new Thread()
        {
            @Override
            public void run() {
                for(int i=0;i<5;i++)
                {
                    progressBar.setProgress(i);
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {

                    }
                }

                Intent i =  new Intent(Idle.this,MainActivity.class);
                startActivity(i);
            }

        };
        thread.start();
    }
}
