package com.example.rpgroller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_NAME = "weaponsDatabase";
	
	private static final String TABLE_WEAPONS = "weapons";
	
	private static final String KEY_ID = "id";
	private static final String KEY_WEP_NAME = "weaponName";
	private static final String KEY_ATK_BONUS = "attackBonus";
	private static final String KEY_DIE_NUM = "damageDieNum";
	private static final String KEY_DIE_TYPE = "damageDieType";
	private static final String KEY_DMG_BONUS = "damageBonus";
	private static final String KEY_CRIT_LOW = "critRangeLow";
	private static final String KEY_CRIT_HIGH = "critRangeHigh";
	private static final String KEY_CRIT_MULTI = "critMultiplier";
	private static final String KEY_NOTES = "specialNotes";
	
	public DatabaseHandler(Context context){
		super(context, DATABASE_NAME,null,DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		String CREATE_WEAPONS_TABLE = "CREATE TABLE" + TABLE_WEAPONS
				+ KEY_ID + "INTEGER PRIMARY KEY"
				+ KEY_WEP_NAME + "TEXT"
				+ KEY_ATK_BONUS +"INTEGER"
				+ KEY_DIE_NUM + "INTEGER"
				+ KEY_DIE_TYPE + "INTEGER"
				+ KEY_DMG_BONUS + "INTEGER"
				+ KEY_CRIT_LOW  + "INTEGER"
				+ KEY_CRIT_HIGH	+  "INTEGER"
				+ KEY_CRIT_MULTI + "INTEGER"
				+ KEY_NOTES + "TEXT";
		
		db.execSQL(CREATE_WEAPONS_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_WEAPONS);
		
		
		onCreate(db);
		
	}

}