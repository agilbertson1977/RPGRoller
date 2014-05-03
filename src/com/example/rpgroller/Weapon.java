package com.example.rpgroller;

public class Weapon {
	int id;
	String weaponName;
	int attackBonus;
	int damageDieNum;
	int damageDieType;
	int damageBonus;
	int critRangeLow;
	int critRangeHigh;
	int critMultiplier;
	String specialNotes;
	
	//empty basic constructor
	public Weapon() {
		
	}
	
	//full constructor
	public Weapon(int id, String name, int a, int ddn, int ddt, int db, int crl, int crh, int cm, String sn) {
		this.id = id;
		weaponName = name;
		attackBonus = a;
		damageDieNum = ddn;
		damageDieType = ddt;
		damageBonus = db;
		critRangeLow = crl;
		critRangeHigh = crh;
		critMultiplier = cm;
		specialNotes = sn;
	}

	//almost-full constructor
	public Weapon(String name, int a, int ddn, int ddt, int db, int crl, int crh, int cm, String sn) {
		weaponName = name;
		attackBonus = a;
		damageDieNum = ddn;
		damageDieType = ddt;
		damageBonus = db;
		critRangeLow = crl;
		critRangeHigh = crh;
		critMultiplier = cm;
		specialNotes = sn;
	}
	
	public int getId() {   return id;	}
	public String getWeaponName() {	return weaponName;	}
	public int getAttackBonus() {	return attackBonus; }
	public int getDamageDieNumber() {	return damageDieNum;	}
	public int getDamageDieType() {	return damageDieType;	}
	public int getDamageBonus() {	return damageBonus; }
	public int getcritRangeLow() { return critRangeLow;	}
	public int getcritRangeHigh() {	return critRangeHigh;	}
	public int getcritMultiplier() { return critMultiplier; }
	public String getSpecialNotes() {	return specialNotes; }
	public void setId(int newid) {	id = newid; }
	public void setWeaponName(String wn) { weaponName = wn;	}
	public void setAttackBonus(int ab) {	attackBonus = ab;	}
	public void setDamageDieNum(int dn) { damageDieNum = dn; }
	public void setDamageDieType(int dt) { damageDieType = dt;	}
	public void setDamageBonus(int db) { damageBonus = db;	}
	public void setCritRangeLow(int crl) { critRangeLow = crl;	}
	public void setCritRangeHigh(int crh) { critRangeHigh = crh;	}
	public void setCritMultiplier(int cm) { critMultiplier = cm;	}
	public void setSpecialNotes(String sn) { specialNotes = sn;	}
	
	
}
