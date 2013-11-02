package com.madness.mm.view;

import com.madness.mm.R;
import com.madness.mm.model.MolApp;
import com.madness.mm.model.Question;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BuilderActivity extends Activity {

	private MolApp app;

	private TextView tvInstruction;

	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_builder);

		app = (MolApp) getApplication();

		mTitle = mDrawerTitle = getTitle();

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, app.getQuiz().getQsByInstruction());

		mDrawerList.setAdapter(adapter);
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		tvInstruction = (TextView) findViewById(R.id.builder_instruction);

		fieldQuestion(app.getQuiz().getNextQuestion());
		setTitle(String.format("Question %d", app.getQuiz().getQuestionNum()));
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.builder, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...

		switch (item.getItemId()) {
		case R.id.builder_submit:
			submit();
			break;

		case R.id.builder_hint:
			getHint();
			break;

		}

		return super.onOptionsItemSelected(item);
	}

	private void submit() {
		// evaluate correctness
		boolean correct = true;
		if (correct) {
			Toast.makeText(this, R.string.builder_toast_correct,
					Toast.LENGTH_SHORT).show();

			app.getQuiz().answerQuestion(correct);
		} else {
			Toast.makeText(this, R.string.builder_toast_correct,
					Toast.LENGTH_SHORT).show();
		}

		if (app.getQuiz().anyLeft()) {
			fieldQuestion(app.getQuiz().getNextQuestion());
		} else {
			startActivity(new Intent(this, ResultsActivity.class));
		}
	}

	public static final int ANSWERED_HINT = 1;

	private void getHint() {
		startActivityForResult(new Intent(this, HintActivity.class),
				ANSWERED_HINT);
	}

	private void resetBuilder() {

	}

	private void fieldQuestion(Question q) {
		tvInstruction.setText(q.getInstruction());
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	/** Swaps fragments in the main content view */
	private void selectItem(int position) {
		// Highlight the selected item, update the title, and close the drawer
		mDrawerList.setItemChecked(position, true);
		setTitle(String.format("Question %d", position + 1));
		mDrawerLayout.closeDrawer(mDrawerList);

		resetBuilder();
		fieldQuestion(app.getQuiz().getCurQuestion(position));
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case (ANSWERED_HINT):
			if (resultCode == HintActivity.HINT_PASS) {
				// hint code
			} else {
				// hint failed code
			}
			break;
		}
	}
}
