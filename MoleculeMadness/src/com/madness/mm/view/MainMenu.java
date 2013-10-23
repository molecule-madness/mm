package com.madness.mm.view;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.madness.mm.R;

public class MainMenu extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		Button start_Button = (Button) findViewById(R.id.Start_button);

		// will make a quiz when its clicked
		start_Button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent newGame = new Intent(MainMenu.this,
						NewGameActivity.class);
				startActivity(newGame);
			}
		});

		Button stats_Button = (Button) findViewById(R.id.Stats_Button);
		// will go to the stats page when clicked
		stats_Button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Intent goto_Stats = new Intent(MainMenu.this, Stats.class);
				//startActivity(goto_Stats);
				// Perform action on click
			}
		});

		Button instructions = (Button) findViewById(R.id.Instruction_Button);
		// will go the com.madness.mm.instructions page when clicked
		instructions.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent goto_Instructions = new Intent(MainMenu.this,
						Instructions.class);
				startActivity(goto_Instructions);
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
}
