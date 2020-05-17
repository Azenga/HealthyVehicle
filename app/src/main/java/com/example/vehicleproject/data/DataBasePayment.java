package com.example.vehicleproject.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBasePayment extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data";
    private static final int DATABASE_VERSION = 1;
    public static final String COL_1 = "cost";
    public static final String COL_2 = "cost_1";
    private Object SQLiteDatabase;
    SQLiteDatabase mydb;

    public DataBasePayment(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mydb = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String DATABASE_CREATE =
                "Create table calculator(_cost integer primary key autoincrement," +
                        "cost integer,cost_1 text);";
        sqLiteDatabase.execSQL(DATABASE_CREATE);
        Log.w("DB", " Cost calculated");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table if EXISTS calculator");
        onCreate(sqLiteDatabase);
        Log.w("DB", "Cost upgraded");
    }

    public void open() throws SQLException {
        mydb = this.getWritableDatabase();
    }

    public void Create(int cost, String cost_1) {
        String insert = "insert into calculator values('')";
        mydb.execSQL(insert);
        Log.v("DB", "Record added");
    }

    public void Update(int cost, String cost_1) {
        String update = "update customers set cost=='" + cost + "' where cost_1==" + cost_1 + "";
        mydb.execSQL(update);
        Log.v("DB", "Cost updated");
    }

    public void Delete(int cost_1) {
        String delete = "delete from customers where cost_1==" + cost_1 + "";
        mydb.execSQL(delete);
        Log.v("DB", "Cost deleted");
    }

    public String Read(String cost_1) {
        Cursor cursor = null;
        String CCost = "";
        if (cursor.moveToFirst()) {
            CCost = cursor.getString(cursor.getColumnIndex("cost"));
        } else {
            CCost = "Cost Not in Existence";
        }
        return CCost;

    }
}
