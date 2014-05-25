package com.example.rpgroller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AttackRollAction extends Activity {
	
	Button rollButton;
	DatabaseHandler db;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attackroll);
		rollButton = (Button) findViewById(R.id.attack_button);
		db = new DatabaseHandler(this.getApplicationContext());
		rollButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				rollAction();
			}
		});
	}
	
	protected void rollAction() {
		
	}
	

}
