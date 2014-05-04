package com.example.rpgroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


// http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/


public class MainActivity extends Activity {
	
	Button attackButton;
	Button skillButton;
	Button spellButton;
	DatabaseHandler db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		attackButton = (Button) findViewById(R.id.attack_button);
		skillButton = (Button) findViewById(R.id.skill_button);
		spellButton = (Button) findViewById(R.id.spell_button);
		attackButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AttackRollAction.class);
				startActivity(intent);
			}
		});
		skillButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SkillRollAction.class);
				startActivity(intent);
			}
		});
		spellButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SpellRollAction.class);
				startActivity(intent);
			}
		});
		db = new DatabaseHandler(this.getApplicationContext());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
