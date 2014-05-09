package com.example.rpgroller;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BasicInfoAction extends Activity{

	DatabaseHandler db;
	Spinner classSpinner;
	Spinner weaponSpinner;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basicinfo);
		
		db = new DatabaseHandler(this.getApplicationContext());
		
		
		//Give the dropdown/spinner the string values from the player_classes array
		classSpinner  = (Spinner) findViewById(R.id.pcClassSpinner);		
		ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(this,
		        R.array.player_classes, android.R.layout.simple_spinner_item);		
		classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		classSpinner.setAdapter(classAdapter);
		
		//DONT THINK I LIKE HAVING TO HAVE THE SEPARATE DB FUNCTION FOR NAMES
		//But I'm tired and whatever, it works.
		weaponSpinner = (Spinner)findViewById(R.id.pcWeaponSpinner);
		List<String> weaponList = db.getAllWeaponNames();
        ArrayAdapter<String> weaponAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, weaponList);
        weaponAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weaponSpinner.setAdapter(weaponAdapter);
	}
		
}
