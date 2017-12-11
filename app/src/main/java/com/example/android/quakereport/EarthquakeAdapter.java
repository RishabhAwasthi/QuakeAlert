package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by awasthi's on 9/29/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

     Earthquake currentquake;



    public EarthquakeAdapter(Context context, List<Earthquake> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        currentquake = getItem(position);


        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        String mag =magnitudeFormat.format(currentquake.getmMagnitude());
        magnitude.setText(mag);

        TextView location = (TextView) listItemView.findViewById(R.id.location);
        TextView subloc = (TextView) listItemView.findViewById(R.id.offset);


         String root = currentquake.getMlocation();
        if(root.contains("of"))
        {String[] sub = root.split("of");
            String ploc= sub[0] + "of";
            String loc =sub[1];
            subloc.setText(ploc);
            location.setText(loc);
        }
        else
        {String ploc ="Near ";
            subloc.setText(ploc);
            location.setText(root);
        }


        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentquake.getmMagnitude());

        //Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView date = (TextView) listItemView.findViewById(R.id.date);

        date.setText(currentquake.getMdate());

        TextView time =(TextView) listItemView.findViewById(R.id.time);

        time.setText(currentquake.getTime());

        
        return listItemView;

    }
    public int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor( getContext() , magnitudeColorResourceId);

    }
}
