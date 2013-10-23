package com.madness.mm.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.madness.mm.R;
import com.madness.mm.model.MolApp;
import com.madness.mm.model.Question;
import com.madness.mm.model.Quiz;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.support.v4.app.NavUtils;

/**
 * The review activity allows the user to see a listing of questions marked as
 * either correct or incorrect. The user may select a question to review it
 * 
 * @author Steve
 * 
 */
public class ReviewActivity extends ListActivity {

	/**
	 * The master domain object, also known as global state
	 */
	private MolApp app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		app = (MolApp) getApplication();

		Quiz quiz = app.getQuiz();

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (Question q : quiz.getQuestions()) {
			HashMap<String, Object> row = new HashMap<String, Object>();
			row.put("row1", q.getInstruction());
			row.put("row2", q.getGrade() ? R.drawable.ic_correct_q
					: R.drawable.ic_incorrect_q);

			data.add(row);
		}

		String[] from = new String[] { "row1", "row2" };
		int[] to = new int[] { R.id.row1Tv, R.id.row2Tv };

		Context c = getApplicationContext();

		ListAdapter adapter = new SimpleAdapter(c, data,
				R.layout.custom_list_row, from, to);
		setListAdapter(adapter);

		this.getListView().setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> l, View v, int pos, long id) {
				// TODO Auto-generated method stub

			}
		});

		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.review, menu);
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

		case R.id.finish_review:
			startActivity(new Intent(this, MainMenuActivity.class));
		}
		return super.onOptionsItemSelected(item);
	}

}
