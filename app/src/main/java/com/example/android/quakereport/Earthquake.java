package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by awasthi's on 9/29/2017.
 */

public class Earthquake {
     private double mMagnitude;
    private String mlocation;
    private long mdate;
    private String url;

    public Earthquake(double mMagnitude, String mlocation, long mdate,String url) {
        this.mMagnitude = mMagnitude;
        this.mlocation = mlocation;
        this.mdate = mdate;
        this.url=url;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }
    public String getUrl(){return this.url;}


    public String getMlocation() {
        return mlocation;
    }

    public String getMdate() {
        Date dateobj = new Date(mdate);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String displayDate = dateFormatter.format(dateobj);
        return displayDate;
    }
    public String getTime(){
        Date dateobj = new Date(mdate);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("hh:m a");
        String displaytime = dateFormatter.format(dateobj);
        return displaytime;
    }

}
