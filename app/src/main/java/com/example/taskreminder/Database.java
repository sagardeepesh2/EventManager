package com.example.taskreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class Database extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "MY_DB";
    public static int DATABASE_VERSION = 1;

    private String TABLE = "TASKS";
    private String COLUMN_ONE = "ID";
    private String COLUMN_TWO = "EVENT";
    private String COLUMN_THREE = "EVENTTYPE";
    private String COLUMN_FOUR = "DATE";


    SQLiteDatabase db1;


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " + TABLE + "(" + COLUMN_ONE + " INTEGER PRIMARY KEY," + COLUMN_TWO + " TEXT, " + COLUMN_THREE + " TEXT, " + COLUMN_FOUR + " TEXT" + ")";
        db.execSQL(sql);
        Log.d("Database","Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS'" + TABLE + "'");
        onCreate(db1);
    }
    public long saveEvent(Event event) {
        db1 = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TWO, event.getEvent());
        values.put(COLUMN_THREE, event.getEventty());
        values.put(COLUMN_FOUR, event.getDate());

        long rowCount = db1.insert(TABLE, null, values);

        db1.close();

        return rowCount;

    }

    public ArrayList<Event> viewEvents()
    {
        ArrayList<Event> eventList = new ArrayList<>();
        String query = "SELECT * FROM " +TABLE;
        db1 = getReadableDatabase();

        Cursor cursor = db1.rawQuery(query,null);

        if (cursor != null)
        {
            if (cursor.moveToFirst())
            {
                do
                {
                    Event e =new Event();
                    e.setID(cursor.getInt(cursor.getColumnIndex(COLUMN_ONE)));
                    e.setEvent(cursor.getString(cursor.getColumnIndex(COLUMN_TWO)));
                    e.setEventty(cursor.getString(cursor.getColumnIndex(COLUMN_THREE)));
                    e.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_FOUR)));
                    eventList.add(e);
                }
                while (cursor.moveToNext());
            }
            cursor.close();
        }
        Log.d("DBHelper", "viewContacts: " + eventList);
        return eventList;
    }

    public void deleteContact(int id)
    {

        db1 = getWritableDatabase();
        db1.delete(TABLE, COLUMN_ONE + " = ?", new String[] {String.valueOf(id)});
    }
}


