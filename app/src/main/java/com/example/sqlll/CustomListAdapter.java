package com.example.sqlll;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter {
    //Add new variables that are properties of this Class:
    //to reference the Activity
    private final Activity context;
    List<String> nameArray = new ArrayList<String>();
    List<String> yearArray = new ArrayList<String>();
    List<String> emailArray = new ArrayList<String>();
    List<String> numberArray = new ArrayList<String>();

    public CustomListAdapter(MainActivity context, List<String> nameArrayParam, List<String> yearArrayParam, List<String> emailArrayParam, List<String> numberArrayParam) {
        super(context, R.layout.event_listview, nameArrayParam);
        this.context = context;
        this.nameArray = nameArrayParam;
        this.yearArray = yearArrayParam;
        this.emailArray = emailArrayParam;
        this.numberArray = numberArrayParam;
    }

    //This method is used automatically by the app to populate the data into each row.
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.event_listview, null, true);
        //This code gets references to objects in the event_listview.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextID);
        TextView yearTextField = (TextView) rowView.findViewById(R.id.yearTextID);
        TextView emailTextField = (TextView) rowView.findViewById(R.id.emailTextID);
        TextView numberTextField = (TextView) rowView.findViewById(R.id.numberTextID);
        //TextView contentTextField = (TextView) rowView.findViewById(R.id.contentTextID);
        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray.get(position));
        yearTextField.setText(yearArray.get(position));
        emailTextField.setText(emailArray.get(position));
        numberTextField.setText(numberArray.get(position));

        return rowView;
    }
}