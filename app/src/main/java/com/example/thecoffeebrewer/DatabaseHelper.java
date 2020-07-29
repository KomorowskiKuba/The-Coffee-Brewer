package com.example.thecoffeebrewer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "Recipes.db";
    private final static String TABLE_NAME = "Recipes_table";

    private final static String ID = "ID";
    private final static String METHOD = "METHOD";
    private final static String NAME = "NAME";
    private final static String AMOUNT_OF_WATER = "AMOUNT_OF_WATER";
    private final static String AMOUNT_OF_TIME = "AMOUNT_OF_TIME";
    private final static String AMOUNT_OF_COFFEE = "AMOUNT_OF_COFFEE";
    private final static String TEMPERATURE = "TEMPERATURE";
    private final static String GRIND_SIZE = "GRIND_SIZE";
    private final static String TABLE_OF_GRAPHICS = "TABLE_OF_GRAPHICS";
    private final static String TABLE_OF_INSTRUCTIONS = "TABLE_OF_INSTRUCTIONS";
    private final static String TABLE_OF_TIME = "TABLE_OF_TIME";
    private final static String ISFAVOURITE = "ISFAVOURITE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + METHOD + " TEXT, " + NAME + " TEXT, " + AMOUNT_OF_WATER + " TEXT, " + AMOUNT_OF_TIME + " TEXT, " + AMOUNT_OF_COFFEE + " TEXT, " +
                TEMPERATURE + " TEXT, " + GRIND_SIZE + " TEXT, " + TABLE_OF_GRAPHICS + " TEXT, " + TABLE_OF_INSTRUCTIONS + " TEXT, " + TABLE_OF_TIME + " TEXT, " + ISFAVOURITE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id, String method, String name, String amountofwater, String amountoftime, String amountofcoffee, String temperature, String grindsize, String tableofgraphics, String tableofinstructions, String tableoftime, String isfavourite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID, id);
        contentValues.put(METHOD, method);
        contentValues.put(NAME, name);
        contentValues.put(AMOUNT_OF_WATER, amountofwater);
        contentValues.put(AMOUNT_OF_TIME, amountoftime);
        contentValues.put(AMOUNT_OF_COFFEE, amountofcoffee);
        contentValues.put(TEMPERATURE, temperature);
        contentValues.put(GRIND_SIZE, grindsize);
        contentValues.put(TABLE_OF_GRAPHICS, tableofgraphics);
        contentValues.put(TABLE_OF_INSTRUCTIONS, tableofinstructions);
        contentValues.put(TABLE_OF_TIME, tableoftime);
        contentValues.put(ISFAVOURITE, isfavourite);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result >= 0;
    }
}
