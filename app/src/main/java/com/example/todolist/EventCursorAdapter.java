package com.example.todolist;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EventCursorAdapter extends CursorAdapter {

    public EventCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.listview_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView eventName = view.findViewById(R.id.eventName);
        eventName.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.TITLE_COL)));

        TextView textView = view.findViewById(R.id.textView3);
        textView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.DATE_COL)));




    }





}