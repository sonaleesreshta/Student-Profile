package com.example.sqlll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MultiRow_ListAdapter extends ArrayAdapter<Event> {
    private LayoutInflater mInflater;
    private ArrayList<Event> events;
    private int mViewResourceId;

    public MultiRow_ListAdapter(Context context, int textViewResourceId, ArrayList<Event> events) {
        super(context, textViewResourceId, events);
        this.events = events;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parents) {
        convertView = mInflater.inflate(mViewResourceId, null);
        Event event = events.get(position);
        if(event != null) {
            TextView name= (TextView) convertView.findViewById(R.id.nameTextID);
            TextView year= (TextView) convertView.findViewById(R.id.yearTextID);
            TextView email= (TextView) convertView.findViewById(R.id.emailTextID);
            TextView number= (TextView) convertView.findViewById(R.id.numberTextID);
            //TextView content= (TextView) convertView.findViewById(R.id.contentTextID);
            if(name != null) {
                name.setText(("Name: " + event.getName()));
            }
            if(year != null) {
                year.setText(("Year: " + event.getYear()));
            }
            if(email != null) {
                email.setText(("Email: " + event.getEmail()));
            }
            if(number != null) {
                number.setText(("Number: " + event.getNumber()));
            }
            //if(content != null) {
              //  content.setText(("Content: " + event.getContent()));
            //}
        }
        return convertView;
    }
}