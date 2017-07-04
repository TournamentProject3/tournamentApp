package com.example.irem.tournament;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by irem on 25.06.2017.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE="tournamnetApp";
    private static final int SURUM=1;

    public Database(Context cont){
        super(cont,DATABASE,null,SURUM);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE user(userName STRING PRIMARY KEY,password ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
