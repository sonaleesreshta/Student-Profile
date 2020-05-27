package com.example.sqlll;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Collator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;

public class AddEventActivity extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        myDB = new DatabaseHelper(this);
        //Save Event List Click Listener
        Button save_btn = (Button) findViewById(R.id.save_button);
        save_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Add Event detail into MainActivity
                addToEventList();
            }
        });
    }
    //Pass event detail into Event Main Page(database)
    public void addToEventList() {
        //Get the EditText Content in Adding Page
        EditText editName = (EditText) findViewById(R.id.editText);
        String name = editName.getText().toString();

        EditText editYear = (EditText) findViewById(R.id.editText3);
        String year = editYear.getText().toString();

        EditText editEmail = (EditText) findViewById(R.id.editText2);
        String email = editEmail.getText().toString();

        EditText editNumber = (EditText) findViewById(R.id.editText4);
        String number = editNumber.getText().toString();

        //EditText editContent = (EditText) findViewById(R.id.editText6);
        //String content = editContent.getText().toString();
        if(name.length() != 0 && year.length() != 0 && email.length() != 0 && number.length() != 0) {
            boolean insertData = myDB.addData(name,year,email,number);
            if(insertData == true) {
                Toast.makeText(AddEventActivity.this, "Successfully Saved the Profile!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(AddEventActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(AddEventActivity.this, "You must put something in each text.", Toast.LENGTH_LONG).show();
        }

    }

}