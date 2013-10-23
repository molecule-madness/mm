package com.madness.mm.view;

import com.madness.mm.R;
import com.madness.mm.model.MolApp;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.support.v4.app.NavUtils;

/**
 * The new game activity provides options for configuring and launching a new
 * Molecule Madness game instance
 * 
 * @author Steve
 */
public class NewGameActivity extends Activity {

	/**
	 * RadioButtons representing TRUE for their respective property
	 */
	private RadioButton rbTime, rbEasy;

	/**
	 * RadioGroups holding the boolean option for game type and difficulty
	 */
	private RadioGroup rgGame, rgDiff;

	/**
	 * These booleans are TRUE when any option in their respective RadioGroup
	 * has been chosen
	 */
	boolean typeSelected = false, diffSelected = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_game);

		rbTime = (RadioButton) findViewById(R.id.new_game_rb_time);
		rbEasy = (RadioButton) findViewById(R.id.new_game_rb_easy);

		rgGame = (RadioGroup) findViewById(R.id.new_game_rg_game_type);
		rgDiff = (RadioGroup) findViewById(R.id.new_game_rg_game_diff);

		// set a ChangeListener on the game type radio group; when any option in
		// that group is selected, update the enabled state of the start button
		rgGame.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// a game type has been selected
				typeSelected = true;
				miStart.setEnabled(typeSelected && diffSelected);
			}
		});

		rgDiff.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// a difficulty has been selected
				diffSelected = true;
				miStart.setEnabled(typeSelected && diffSelected);
			}
		});

		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Start a new game given the user's configuration
	 */
	public void startGame() {
		boolean gameType = rbTime.isChecked();
		boolean gameDiff = rbEasy.isChecked();

		// create a new quiz instance given the parameters
		MolApp app = (MolApp) getApplication();
		app.mkNewQuiz(gameType, gameDiff);

		startActivity(new Intent(this, BuilderActivity.class));
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	
	/**
	 * The start button in the ActionBar
	 */
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
			NavUtils.navigateUpFromSameTask(this);
			return true;

		case R.id.startGame:
			startGame();
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
