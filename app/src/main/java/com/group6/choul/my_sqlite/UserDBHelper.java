package com.group6.choul.my_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class UserDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "user_db";
    public static final String TABLE_USER = "tbluser";
    public static final String USER_NAME = "name";
    public static final String USER_EMAIL = "email";
    public static final String USER_AGE = "age";

    public UserDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +  TABLE_USER + "(id integer primary key autoincrement,name text, email text,age integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public void insertUser(int age, String name, String email){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME,name);
        values.put(USER_AGE,age);
        values.put(USER_EMAIL,email);
        db.insert(TABLE_USER, null, values);
        db.close();
        Log.d("INSERT DATA:: ", "Insert Successful");
    }

//    public ArrayList<UserModel> getAllUser(){
//        ArrayList<UserModel> users = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER , null);
//        cursor.moveToFirst();
//
//        while(cursor.isAfterLast() == false){
//            UserModel user = new UserModel(cursor.getInt(3),cursor.getString(1),cursor.getString(2));
//            cursor.moveToNext();
//            users.add(user);
//        }
//
//        return users;
//    }
}
