package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{

    ListView lv;
    int eventLocate;
    int finishTask;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper = new DatabaseHelper(this, DatabaseHelper.DATABASE_NAME, null, 1);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();


        lv = findViewById(R.id.event_list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox checkBox = view.findViewById(R.id.checkBox);
                ContentValues cv = new ContentValues();
                if(checkBox.isChecked() == false){
                    checkBox.setChecked(true);
                    Log.i("INFO", "CHECK");
                    String doneStr = "1";
                    cv.put(DatabaseHelper.DONE_COL, doneStr);

                    db.update(DatabaseHelper.TABLE_NAME, cv, "_id = ?", new String[]{doneStr});


                } else {
                    checkBox.setChecked(false);
                    Log.i("INFO", "UNCHECK");
                    String doneStr = "0";
                    /*cv.put(DatabaseHelper.DONE_COL, doneStr);
                    db.insert(DatabaseHelper.DONE_COL, null, cv);
                    db.update(databaseHelper.DONE_COL, cv, "_id = ?", new String[]{});*/
                }



            }
        });











    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, eventCreatedActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseHelper db = new DatabaseHelper(this, DatabaseHelper.DATABASE_NAME, null, 1);
        SQLiteDatabase reader = db.getReadableDatabase();
        String[] columns = {"_id", DatabaseHelper.TITLE_COL, DatabaseHelper.DATE_COL, DatabaseHelper.DONE_COL};
        Cursor cursor = reader.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        EventCursorAdapter cursorAdapter = new EventCursorAdapter(this, cursor, true);
        lv.setAdapter(cursorAdapter);




    }




}


