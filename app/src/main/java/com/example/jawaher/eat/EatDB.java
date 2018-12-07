package com.example.jawaher.eat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class EatDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Eeatinfo.db";
    public static final String TABLE_NAME = "user_details";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "PASS";
    public static final String COL_3= "PHON";
    public static final String COL_4= "CITY";

    public static final String TABLE_NAME2 = "user_request";
    public static final String COL_12 = "username";
    public static final String COL_22 = "type";
    public static final String COL_32= "number";


    SQLiteDatabase db = this.getWritableDatabase();


    public EatDB(Context context ) {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase db=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (NAME TEXT PRIMARY KEY,PASS TEXT,PHON TEXT,CITY TEXT)");
        db.execSQL("create table " + TABLE_NAME2 + " (username TEXT PRIMARY KEY,type TEXT,number TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);

    }
    public  boolean insertData(String n, String p, String ph, String c)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues xcv=new ContentValues();
        xcv.put(COL_1,n);
        xcv.put(COL_2,p);
        xcv.put(COL_3,ph);
        xcv.put(COL_4,c);

        long result = db.insert(TABLE_NAME,null,xcv);
        db.close();
        if(result == -1 )
            return  false;
        else
            return true;

    }

    public  boolean insertData2(String n, String tp, String no)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues xcv=new ContentValues();
        xcv.put(COL_12,n);
        xcv.put(COL_22,tp);
        xcv.put(COL_32,no);


        long result = db.insert(TABLE_NAME2,null,xcv);
        db.close();
        if(result == -1 )
            return  false;
        else
            return true;

    }

    public Cursor getsData(String x) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME + "where NAME="+x,null);
        return res;
    }

    public Cursor getsData2(String x) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2 + "where username="+x,null);
        return res;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public Cursor getAllData2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2,null);
        return res;
    }

    public boolean updateData(String na, String pass, String ph,String ccc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,na);
        contentValues.put(COL_2,pass);
        contentValues.put(COL_3,ph);
        contentValues.put(COL_4,ccc);

        db.update(TABLE_NAME, contentValues, "NAME = ?",new String[] { na });
        return true;
    }

    public boolean updateData2(String bbb, String n, String p, String no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_12,n);
        contentValues.put(COL_22,p);
        contentValues.put(COL_32,no);


        db.update(TABLE_NAME, contentValues, "username = ?",new String[] { bbb });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NAME = ?",new String[] {id});
    }

    public Integer deleteData2 (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME2, "username = ?",new String[] {id});
    }
}
