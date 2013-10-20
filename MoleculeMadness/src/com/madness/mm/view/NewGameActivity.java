package com.madness.mm.view;

import com.madness.mm.R;
import com.madness.mm.model.Quiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.support.v4.app.NavUtils;

public class NewGameActivity extends Activity {

	private RadioButton rbTimeAttack, rbScoring, rbEasy, rbDifficult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_game);
		
		//@formatter:off
		rbTimeAttack = (RadioButton)findViewById(R.id.rbTimeAttack);
		rbScoring    = (RadioButton)findViewById(R.id.rbScoring   );
		
		rbEasy       = (RadioButton)findViewById(R.id.rbEasy      );
		rbDifficult  = (RadioButton)findViewById(R.id.rbDifficult );
		//@formatter:on
		
		// Show the Up button in the action bar.
		setupActionBar();
	}

	public void startGame(View view) {
		boolean gameType = rbTimeAttack.isChecked();
		boolean gameDiff = rbEasy.isChecked();
		
		Quiz quiz = new Quiz(gameType, gameDiff);
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}
	
	private MenuItem miStart;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.new_game_menu, menu);

		miStart = menu.findItem(R.id.startGame);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}