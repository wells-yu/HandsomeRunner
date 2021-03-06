package com.weiyu.handsomerunner.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * created by Sam on 4/14/2016
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final int VERSION = 3;
    public static final String DATABASE_NAME = "id27315932";
    public static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS user(" +
            "_id integer primary key autoincrement," +
            "userName varchar(50) not null," +
            "password varchar(50) not null," +
            "age integer not null," +
            "height double not null," +
            "weight double not null," +
            "gender varchar(50) not null," +
            "level integer not null," +
            "steps double null default 0," +
            "updateTime datetime default CURRENT_TIMESTAMP not null," +
            "latitude double null default 190," +
            "longitude double null default 180" +
            ");";


    public static final String CREATE_TABLE_CALORIE_GOAL = "CREATE TABLE IF NOT EXISTS calorie_goal(" +
            "_id integer primary key autoincrement," +
            "userName varchar(50) not null," +
            "calorie double not null," +
            "updateTime varchar(50) not null" +
            ");";


    public static final String CREATE_TABLE_STEPS = "CREATE TABLE IF NOT EXISTS steps_record(" +
            "_id integer primary key autoincrement," +
            "userName varchar(50) not null," +
            "steps int not null," +
            "updateTime datetime default CURRENT_TIMESTAMP not null" +
            ");";


    public static final String CREATE_TABLE_DAILY_DIET = "CREATE TABLE IF NOT EXISTS daily_diet(" +
            "_id integer primary key autoincrement," +
            "foodId varchar(50) not null," +
            "foodName varchar(100) not null," +
            "userName varchar(50) not null," +
            "counts int not null," +
            "updateTime datetime default CURRENT_TIMESTAMP not null" +
            ");";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create a user table
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_CALORIE_GOAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("on upgrade");
        if(1 == oldVersion && 2 == newVersion) {
            db.execSQL(CREATE_TABLE_STEPS);
        }else if(2 == oldVersion && 3 == newVersion){
            db.execSQL(CREATE_TABLE_DAILY_DIET);
        }
    }
}
