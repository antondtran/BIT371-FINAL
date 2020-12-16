package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Events";
    public static final String TABLE_NAME = "Todo_list";
    public static final String TITLE_COL = "Title";
    public static final String DATE_COL = "Date";
    public static final String DONE_COL = "DONE";


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DatabaseHelper.TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                DatabaseHelper.TITLE_COL + " TEXT," +
                DatabaseHelper.DATE_COL + " TEXT," +
                DatabaseHelper.DONE_COL + " TEXT" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
