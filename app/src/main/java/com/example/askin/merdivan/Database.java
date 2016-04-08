package com.example.askin.merdivan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class Database extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "merdivan";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create table statements
        String createBadgeTable = "CREATE TABLE IF NOT EXISTS badge (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , name VARCHAR NOT NULL UNIQUE );";
        String createObservationTable = "CREATE TABLE IF NOT EXISTS observation (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , topic_id INTEGER NOT NULL , status_id INTEGER NOT NULL , user_id INTEGER NOT NULL , date DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP, summary TEXT NOT NULL , address TEXT NOT NULL , lat FLOAT NOT NULL , lng FLOAT NOT NULL );";
        String createStatusTable = "CREATE TABLE IF NOT EXISTS status (id INTEGER PRIMARY KEY  NOT NULL , name VARCHAR NOT NULL UNIQUE );";
        String createUserTable = "CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , name VARCHAR NOT NULL , password VARCHAR NOT NULL , type_id INTEGER NOT NULL , badge_id INTEGER NOT NULL );";
        String createUserTypeTable = "CREATE TABLE IF NOT EXISTS user_type (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , name VARCHAR NOT NULL UNIQUE );";
        String createVoteTable = "CREATE TABLE IF NOT EXISTS vote (observation_id INTEGER NOT NULL , vote_count INTEGER NOT NULL );";
        String createTopicTable = "CREATE TABLE  IF NOT EXISTS topic(id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , name VARCHAR NOT NULL UNIQUE );";

        //Executing the SQL statements
        db.execSQL(createBadgeTable);
        db.execSQL(createObservationTable);
        db.execSQL(createStatusTable);
        db.execSQL(createUserTable);
        db.execSQL(createUserTypeTable);
        db.execSQL(createVoteTable);
        db.execSQL(createTopicTable);

        //Adding default values to the Database

        //1. Badges
        String addDummyBadge = "INSERT INTO badge VALUES(1, 'dummy');";

        //2. User Types
        String addDummyUserType = "INSERT INTO user_type VALUES(1, 'member');";

        //3. Topic Table
        String topic1 ="INSERT INTO topic VALUES(1, 'Agac/Park');";
        String topic2 ="INSERT INTO topic VALUES(2, 'Cop/Cevre Kirliligi');";
        String topic3 ="INSERT INTO topic VALUES(3, 'Cukur/Kaldirim/Tehlike');";
        String topic4 ="INSERT INTO topic VALUES(4, 'Diger Istek');";
        String topic5 ="INSERT INTO topic VALUES(5, 'Elektrik Kesintisi');";
        String topic6 ="INSERT INTO topic VALUES(6, 'Gurultu');";

        //4.Status Table
        String approved ="INSERT INTO status VALUES(1, 'Onaylandi');";
        String waiting ="INSERT INTO status VALUES(2, 'Bekliyor');";
        String deleted ="INSERT INTO status VALUES(3, 'Silindi');";

        //5. User Table
        String dummyUser ="INSERT INTO user VALUES(1, 'dummy', 'pass123', 1, 1);";

        //Executions of default values
        db.execSQL(addDummyBadge);
        db.execSQL(addDummyUserType);
        db.execSQL(topic1);
        db.execSQL(topic2);
        db.execSQL(topic3);
        db.execSQL(topic4);
        db.execSQL(topic5);
        db.execSQL(topic6);
        db.execSQL(approved);
        db.execSQL(waiting);
        db.execSQL(deleted);
        db.execSQL(dummyUser);

        Log.i("Database", "Tables added");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
