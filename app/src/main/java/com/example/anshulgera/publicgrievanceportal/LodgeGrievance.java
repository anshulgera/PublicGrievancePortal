package com.example.anshulgera.publicgrievanceportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LodgeGrievance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodge_grievance);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText aadhar = (EditText) findViewById(R.id.aadhar);
        final EditText address = (EditText) findViewById(R.id.address);
        final EditText pincode = (EditText) findViewById(R.id.pincode);
        final EditText district = (EditText) findViewById(R.id.district);
        final EditText mobno = (EditText) findViewById(R.id.mobile);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText description = (EditText) findViewById(R.id.description);
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().length() == 0)
                    name.setError("Required Field is Empty");
                if (aadhar.getText().length() == 0)
                    aadhar.setError("Required Field is Empty");
                if (address.getText().length() == 0)
                    address.setError("Required Field is Empty");
                if (pincode.getText().length() == 0)
                    pincode.setError("Required Field is Empty");
                if (pincode.getText().length() < 6)
                    pincode.setError("Enter valid Pincode");
                if (district.getText().length() == 0)
                    district.setError("Required Field is Empty");
                if (mobno.getText().length() == 0)
                    mobno.setError("Required Field is Empty");
                if (mobno.getText().length() < 10)
                    mobno.setError("Moblie number should consist of 10 digits");
                if (email.getText().length() == 0)
                    email.setError("Required Field is Empty");
                if (description.getText().length() == 0)
                    description.setError("Required Field is Empty");
                if(aadhar.getText().length()<12)
                    aadhar.setError("Enter Valid Aadhar Number");

                //email validation
                String target=email.getText().toString();


                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches())
                    email.setError("Enter Valid Email Address");

            }

        });

}
}

