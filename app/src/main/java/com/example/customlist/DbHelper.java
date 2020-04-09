package com.example.customlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String Database_name = "mylist.db";
    public static final String Table = "tasks";
    public static final String COL0 = "id";
    public static final String COL1 = "item";
    public static final String COL2 = "description";

   public DbHelper(Context context){
       super(context,Database_name,null,1);
   }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create table "+ Table + "(id integer primary key autoincrement, " +
                "item text," +
                "description text)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       String query = "Drop table if exists " + Table;

       sqLiteDatabase.execSQL(query);
    }


    public boolean add(String item, String description){

       SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COL1,item);
        cv.put(COL2,description);

        long result = db.insert(Table,null,cv);

        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

    public Cursor getData(){

       SQLiteDatabase db = this.getWritableDatabase();

       Cursor data = db.rawQuery("select * from "+Table,null);

       return data;

    }
}
