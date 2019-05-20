package com.example.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {
    private static EntryDatabase instance;

    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    public static EntryDatabase getInstance(Context c) {
        if(instance == null) {
            instance = new EntryDatabase(c, "EntryDatabase", null, 1);

        }
        return instance;

    }


    public void onCreate(SQLiteDatabase db) {
        String querie = "CREATE TABLE entries ( _id INTEGER PRIMARY KEY, title TEXT, content TEXT, mood INTEGER, timeStamp DATETIME DEFAULT CURRENT_TIMESTAMP)";

        db.execSQL(querie);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "entries");
        onCreate(db);

    }

    public Cursor selectAll(){
        Cursor cursor =  getWritableDatabase().rawQuery("SELECT * FROM entries", null);
        return cursor;
    }

    public void delete(long id ) {
        SQLiteDatabase db = getWritableDatabase();

        String tableDel = "DELETE FROM entries WHERE id = ?";
        db.delete("entries", "_id = ?", new String[]{ String.valueOf(id)});

    }

    public void insert(JournalEntry insert){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", insert.getTitle());
        contentValues.put("mood", insert.getMood());
        contentValues.put("content", insert.getContent());
        contentValues.put("timestamp", insert.getTimestamp());

       db.insert("entries", null, contentValues);

    }

}

