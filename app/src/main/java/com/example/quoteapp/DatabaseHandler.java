package com.example.quoteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QuoteDatabase";
    private static final String TABLE_Quote = "Quotes";
    private static final String KEY_ID = "Quote_Id";
    private static final String KEY_Quote = "Quote";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_Quote_TABLE = "CREATE TABLE " + TABLE_Quote + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_Quote + " TEXT "
                + ")";
        db.execSQL(CREATE_Quote_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Quote);

        // Create tables again
        onCreate(db);
    }

    // code to add the new student
    void addqote(quote q) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Quote, q.getquote());


        // Inserting Row
        db.insert(TABLE_Quote, null, values);

        db.close(); // Closing database connection
    }


    quote getStudent(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Quote, new String[] { KEY_Quote,
                        }, KEY_Quote + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        quote student = new quote(cursor.getString(0));
        // return student
        return student;
    }


    public ArrayList<quote> getAllqotes() {
        ArrayList<quote> qList = new ArrayList<quote>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Quote;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                quote q = new quote();
                q.setId(Integer.parseInt(cursor.getString(0)));
                q.setquote(cursor.getString(1));


                qList.add(q);
            } while (cursor.moveToNext());
        }


        return qList;
    }


    // Deleting single quote
    public void deletequote(quote q) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Quote, KEY_ID + " = ?",
                new String[] { String.valueOf(q.getId()) });
        db.close();
    }
    public int deleteall()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_Quote,null,null);
    }




}
