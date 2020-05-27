package com.example.sqlll;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "DatabaseHelper";
    public static final String DATABASE_NAME = "event.db";
    public static final String TABLE_NAME = "event_table";
    //Table of database's add event column name
    private static final String COL1 = "ID";
    private static final String COL2 = "Name";
    private static final String COL3 = "Year";
    private static final String COL4 = "Email";
    private static final String COL5 = "Number";

    public DatabaseHelper(Context context) {

        super(context, TABLE_NAME, null, 1);
    }
    //Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL2 + " TEXT, "
                + COL3 + " TEXT, "
                + COL4 + " TEXT, "
                + COL5 + " TEXT )";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //Add data to the database
    public boolean addData(String name, String year, String email, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, year);
        contentValues.put(COL4, email);
        contentValues.put(COL5, number);


        long result = db.insert(TABLE_NAME, null, contentValues);
        //To check if the data is inserted correctly, if correct, it returns -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public Cursor getItemID(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME + " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    public void updateEventList(int id, String newName, String newYear, String newEmail, String newNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 + " = '" + newName + "', " +
                COL3 + " = '" + newYear + "', " +
                COL4 + " = '" + newEmail + "', " +
                COL5 + " = '" + newNumber + "', " +
                COL1 + " = '" + id + "'";
        Log.d(TAG, "update: query: " + query);
        db.execSQL(query);
//        int result = db.update(TABLE_NAME, null, COL1 + " = " + id, null);
    }
}