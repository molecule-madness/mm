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

public class NewGameActivity extends Activity {

	private RadioButton rbTimeAttack, rbEasy;
	private RadioGroup rgGameType, rgGameDiff;

	boolean typeSelected = false, diffSelected = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_game);

		//@formatter:off
		rbTimeAttack = (RadioButton)findViewById(R.id.rbTimeAttack);
		rbEasy       = (RadioButton)findViewById(R.id.rbEasy      );
		//@formatter:on

		rgGameType = (RadioGroup) findViewById(R.id.rgGameType);
		rgGameDiff = (RadioGroup) findViewById(R.id.rgGameDiff);

		rgGameType.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				typeSelected = true;

				miStart.setEnabled(typeSelected && diffSelected);
			}
		});

		rgGameDiff.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				diffSelected = true;

				miStart.setEnabled(typeSelected && diffSelected);
			}
		});

		// Show the Up button in the action bar.
		setupActionBar();
	}

	public void startGame() {
		boolean gameType = rbTimeAttack.isChecked();
		boolean gameDiff = rbEasy.isChecked();

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

		case R.id.startGame:
			startGame();
			break;
		}

		return super.onOptionsItemSelected(item);
	}

}
