package sg.edu.rp.c346.id21010860.p05_ndpsongs;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static java.text.NumberFormat.Field.INTEGER;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ndp.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_SONG = "song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SINGER = "singer";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_STAR = "star";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT," +
                COLUMN_SINGER + "TEXT, " +
                COLUMN_YEAR + "INTEGER," +
                 COLUMN_STAR + "INTEGER)";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");

        //Dummy records, to be inserted when the database is created
        for (int i = 0; i < 4; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_TITLE, "Data number" + i);
            db.insert(TABLE_SONG, null, values);
        }
        Log.i("info", "dummy records inserted");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE " + TABLE_SONG + " ADD COLUMN module_name TEXT ");
    }

    public long insertSong(String data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE,data);
        long result = db.insert(TABLE_SONG, null, values);
        db.close();
        Log.d("SQL Insert", "ID:" + result); //id returned, shouldn’t be -1
        return result;

    }

    public ArrayList<Song> getAllSong() {
        ArrayList<Song> songs = new ArrayList<Song>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_SINGER, COLUMN_YEAR,COLUMN_STAR};
        Cursor cursor = db.query(TABLE_SONG, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String singer = cursor.getString(2);
                int year = cursor.getInt(3);
                int star = cursor.getInt(4);
                Song song = new Song( title, singer, year,star);
                songs.add(song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }

    public ArrayList<Song> getAllSongs(String keyword) {
        ArrayList<Song> songs = new ArrayList<Song>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_ID,COLUMN_STAR};
        String condition = COLUMN_STAR +  " Like ?";    //? represents the argument below
        String[] args = {"%" + keyword + "%"};
        Cursor cursor = db.query(TABLE_SONG, columns, condition, args,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String singer = cursor.getString(2);
                int year = cursor.getInt(3);
                int star = cursor.getInt(4);
                Song song = new Song( title, singer, year,star);
                songs.add(song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;

    }

    public int updateSong(Song data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, data.getTitle());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        int result = db.update(TABLE_SONG, values, condition, args);
        db.close();
        return result;
    }

    public int deleteSong(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_SONG, condition, args);
        db.close();
        return result;
    }

}