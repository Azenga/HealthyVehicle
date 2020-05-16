package com.example.vehicleproject.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Vehicle";
    private static final String TABLE_NAME = "UserRegister";

    private static final String COL_1 = "ID";
    private static final String COL_2 = "FirstName";
    private static final String COL_3 = "LastName";
    private static final String COL_4 = "Username";
    private static final String COL_5 = "Password";


    public DataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE UserRegister (ID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName TEXT,LastName TEXT,Username TEXT, Password TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS UserRegister");
    }

    public boolean InsertData(String FirstName, String LastName, String Username, String Password) {

        try (
                SQLiteDatabase db = this.getWritableDatabase()

        ) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, FirstName);
            contentValues.put(COL_3, LastName);
            contentValues.put(COL_4, Username);
            contentValues.put(COL_5, Password);

            return db.insert(TABLE_NAME, null, contentValues) != -1;
        }
    }

    public boolean checkUsername(String Username) {

        SQLiteDatabase db = this.getWritableDatabase();

        try (
                Cursor cursor = db.rawQuery("Select * from UserRegister where Username=?", new String[]{Username});

        ) {
            return cursor.getCount() == 0;

        }

    }

    public boolean login(String User, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        try (
                Cursor cursor = db.rawQuery("Select * from UserRegister where Username=? and Password=?", new String[]{User, Password});

        ) {

            return cursor.getCount() > 0;
        }
    }

}

