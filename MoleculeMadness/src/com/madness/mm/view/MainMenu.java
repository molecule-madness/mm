package com.madness.mm.view;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.madness.mm.R;
import com.madness.mm.StatsActivity;

/**
 * This activity is the home screen for the Molecule Madness game. It has
 * options to launch a new game, view statistics, and view instructions.
 * 
 * @author Steve
 */
public class MainMenu extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		Button btnStart = (Button) findViewById(R.id.main_btn_start);

		// go to the new game activity
		btnStart.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainMenu.this, NewGameActivity.class));
			}
		});

		Button btnStats = (Button) findViewById(R.id.main_btn_stats);

		// go to the statistics activity
		btnStats.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainMenu.this, StatsActivity.class));
			}
		});

		Button instructions = (Button) findViewById(R.id.main_btn_instructions);

		// go to the instructions activity
		instructions.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainMenu.this, Instructions.class));
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
}
