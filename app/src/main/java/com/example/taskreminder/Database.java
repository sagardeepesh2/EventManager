package com.example.taskreminder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Database extends SQLiteOpenHelper {
    public static String DATABASE_NAME="MY_DB";
    public static int DATABASE_VERSION=1;

    private String TABLE="TASKS";
    private String COLUMN_ONE="ID";
    private String COLUMN_TWO="TASK";
    private String COLUMN_THREE="EVENT";
    private String COLUMN_FOUR="DATE";


    SQLiteDatabase db;


    public Database(Context context) {
        super(context, null, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = " CREATE TABLE "+TABLE+"("+COLUMN_ONE+" INTEGER PRIMARY KEY,"+COLUMN_TWO+"TASK"+COLUMN_THREE+"EVENTS"+COLUMN_FOUR+"DATE";
    db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS'"+TABLE+"'");
    onCreate(db);
    }
}
