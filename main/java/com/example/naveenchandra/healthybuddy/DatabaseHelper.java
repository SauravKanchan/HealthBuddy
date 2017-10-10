package com.example.naveenchandra.healthybuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NAVEENCHANDRA on 26-03-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="profile.db";
    public static final String TABLE_NAME="history";
    public static final String COL_1="ID";
    public static final String COL_2="DISEASE";
    public static final String COL_3="DESCRIPTION";
    public static final String COL_4="MEDICENES";


    private static DatabaseHelper instance = null;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, DISEASE TEXT, DESCRIPTION TEXT,MEDICENES TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void refresh(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String disease,String description,String medicenes){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,disease);
        values.put(COL_3,description);
        values.put(COL_4,medicenes);
        long resutl=db.insert(TABLE_NAME,null,values);
        if(resutl==-1){return false;}
        else{return true;}
    }

    public Cursor getAllData(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res= db.rawQuery("SELECT *FROM "+TABLE_NAME,null);
        return res;
    }

    public void removeById(long id){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("delete from "+TABLE_NAME+" where ID='"+id+"'");;
    }
}
