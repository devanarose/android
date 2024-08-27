package com.example.database1;
//import the following
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;
import android.content.Context;
import android.view.View;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper{

    //create constant variables
    //db name
    private static final String DB_NAME="student_db";
    //db version
    private static final int DB_VERSION=1;
    //table name
    private static final String TABLE_NAME = "student_details";
    //columns
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String COURSE = "course";
    private static final String SEMESTER = "semester";
    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query ="CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+ " TEXT,"+COURSE+" TEXT,"+SEMESTER+" INTEGER)";
        //execute above query without return value
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //check if the table already exist
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    //function for inserting
    public void addNewStudent(String name,String course,int semester){
        SQLiteDatabase db = this.getWritableDatabase(); //open db with permission of write
        ContentValues values = new ContentValues();
        //passing data as key-value pairs
        values.put(NAME,name);
        values.put(COURSE,course);
        values.put(SEMESTER,semester);
        ///pass content values to the table
        db.insert(TABLE_NAME,null,values);
        //db.close();
    }
}
