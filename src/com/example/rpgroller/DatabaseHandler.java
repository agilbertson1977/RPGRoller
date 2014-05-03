package com.example.rpgroller;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
	
	public void addWeapon(Weapon weapon) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_WEP_NAME, weapon.getWeaponName());
		values.put(KEY_ATK_BONUS, weapon.getAttackBonus());
		values.put(KEY_DIE_NUM, weapon.getDamageDieNumber());
		values.put(KEY_DIE_TYPE, weapon.getDamageDieType());
		values.put(KEY_DMG_BONUS, weapon.getDamageBonus());
		values.put(KEY_CRIT_LOW, weapon.getcritRangeLow());
		values.put(KEY_CRIT_HIGH, weapon.getcritRangeHigh());
		values.put(KEY_CRIT_MULTI, weapon.getcritMultiplier());
		values.put(KEY_NOTES, weapon.getSpecialNotes());
		db.insert(TABLE_WEAPONS, null, values);
		db.close();
	}
	
	public Weapon getWeapon(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(TABLE_WEAPONS, new String[] {
				KEY_WEP_NAME,
				KEY_ATK_BONUS,
				KEY_DIE_NUM,
				KEY_DIE_TYPE,
				KEY_DMG_BONUS,
				KEY_CRIT_LOW,
				KEY_CRIT_HIGH,
				KEY_CRIT_MULTI,
				KEY_NOTES
		}, KEY_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
		if(cursor != null) cursor.moveToFirst();
		Weapon weapon = new Weapon(Integer.parseInt(cursor.getString(0)),
				                                    cursor.getString(1),
				                   Integer.parseInt(cursor.getString(2)),
				                   Integer.parseInt(cursor.getString(3)),
				                   Integer.parseInt(cursor.getString(4)),
				                   Integer.parseInt(cursor.getString(5)),
				                   Integer.parseInt(cursor.getString(6)),
				                   Integer.parseInt(cursor.getString(7)),
				                   Integer.parseInt(cursor.getString(8)),
				                                    cursor.getString(9));
		return weapon;
				              
	}
	
	public List<Weapon> getAllWeapons() {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		String selectQuery = "SELECT * FROM " + TABLE_WEAPONS;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if(cursor.moveToFirst()) {
			do {
				Weapon weapon = new Weapon(Integer.parseInt(cursor.getString(0)),
						cursor.getString(1),
						Integer.parseInt(cursor.getString(2)),
						Integer.parseInt(cursor.getString(3)),
						Integer.parseInt(cursor.getString(4)),
						Integer.parseInt(cursor.getString(5)),
						Integer.parseInt(cursor.getString(6)),
						Integer.parseInt(cursor.getString(7)),
						Integer.parseInt(cursor.getString(8)),
						cursor.getString(9));
				weapons.add(weapon);
			} while (cursor.moveToNext());
		}
		return weapons;
	}
	
	public int getWeaponsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_WEAPONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();		
	}
	
	public int updateWeapon(Weapon weapon) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_WEP_NAME, weapon.getWeaponName());
		values.put(KEY_ATK_BONUS, weapon.getAttackBonus());
		values.put(KEY_DIE_NUM, weapon.getDamageDieNumber());
		values.put(KEY_DIE_TYPE, weapon.getDamageDieType());
		values.put(KEY_DMG_BONUS, weapon.getDamageBonus());
		values.put(KEY_CRIT_LOW, weapon.getcritRangeLow());
		values.put(KEY_CRIT_HIGH, weapon.getcritRangeHigh());
		values.put(KEY_CRIT_MULTI, weapon.getcritMultiplier());
		values.put(KEY_NOTES, weapon.getSpecialNotes());
		return db.update(TABLE_WEAPONS, values, KEY_ID + " = ?",
				new String[] {String.valueOf(weapon.getId())} );
	}
	
	public void deleteWeapon(Weapon weapon) {
	}
	
	

}