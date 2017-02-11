package com.example.anshulgera.publicgrievanceportal;

import android.text.style.TtsSpan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by AnshulGera on 30-11-2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Complaints {
    String AadharNo,Name,Date,Description,District,Email,MobileNo,Pincode,Address,Reminder,Progress;

    public String getName(){
        return Name;
    }
    public String getDate(){
        return Date;
    }
    public String getAadharNo(){
        return AadharNo;
    }
    public String getDescription(){
        return Description;
    }
    public String getDistrict(){
        return District;
    }
    public String getEmail(){
        return Email;
    }
    public String getMobileNo(){
        return MobileNo;
    }
    public String getPincode(){
    return Pincode;
    }
    public String getAddress(){
        return Address;
    }
    public String getReminder(){
        return Reminder;
    }
    public String getProgress(){
        return Progress;
    }
}
