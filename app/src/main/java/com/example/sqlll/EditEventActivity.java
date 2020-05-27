package com.example.sqlll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditEventActivity extends AppCompatActivity {
    private static String TAG = "EditEventActivity";
    private Button btnEditSave;
    private EditText getEdit_name, getEdit_year, getEdit_email, getEdit_number;
    DatabaseHelper myDB;

    //private String selectedName;
    private int selectedID;
    private String selectedName, selectedYear, selectedEmail, selectedNumber;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_event_layout);
        btnEditSave = (Button) findViewById(R.id.btnEditSave);
        //tide the edit text id
        getEdit_name = (EditText) findViewById(R.id.editText);
        getEdit_year = (EditText) findViewById(R.id.editText3);
        getEdit_email = (EditText) findViewById(R.id.editText2);
        getEdit_number = (EditText) findViewById(R.id.editText4);

        myDB = new DatabaseHelper(this);
        //get the intent extra from the MainActivity
        Intent receivedIntent = getIntent();
        //get all items we passed as an extra from MainActivity
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");
        selectedYear = receivedIntent.getStringExtra("year");
        selectedEmail = receivedIntent.getStringExtra("email");
        selectedNumber = receivedIntent.getStringExtra("number");

        //set the text to show the current selected data
        getEdit_name.setText(selectedName);
        getEdit_year.setText(selectedYear);
        getEdit_email.setText(selectedEmail);
        getEdit_number.setText(selectedNumber);

        btnEditSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = getEdit_name.getText().toString();
                String year = getEdit_year.getText().toString();
                String email = getEdit_email.getText().toString();
                String number = getEdit_number.getText().toString();
                if(name.length() != 0 && year.length() != 0 && email.length() != 0 && number.length() != 0) {
                    myDB.updateEventList(selectedID, name, year, email, number);
                    Toast.makeText(EditEventActivity.this, "Successfully Edited the Profile!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(EditEventActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(EditEventActivity.this, "You must put something in each text.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
