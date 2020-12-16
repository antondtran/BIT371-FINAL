package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

public class eventCreatedActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    public static TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_created);





        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();

            }
        });


        DatabaseHelper databaseHelper = new DatabaseHelper(this, DatabaseHelper.DATABASE_NAME, null, 1);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        EditText title = findViewById(R.id.event_title_edit);
        Button createBtn = findViewById(R.id.create_btn);
        textView = findViewById(R.id.textView2);



        createBtn.setOnClickListener((view)->{
            String titleStr = title.getText().toString();
            String dateStr = textView.getText().toString();






            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.TITLE_COL, titleStr);
            cv.put(DatabaseHelper.DATE_COL, dateStr);


            db.insert(DatabaseHelper.TABLE_NAME, null, cv);
            db.insert(DatabaseHelper.TITLE_COL, null, cv);
            db.insert(DatabaseHelper.DATE_COL, null, cv);
            db.insert(DatabaseHelper.DONE_COL, null, cv);


        });
    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
        textView.setText(date);



    }




}