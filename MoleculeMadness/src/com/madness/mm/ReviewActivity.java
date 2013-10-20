package com.madness.mm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.support.v4.app.NavUtils;

public class ReviewActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_review);

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 12; i++) {
			HashMap<String, Object> row = new HashMap<String, Object>();
			row.put("row1", String.format("Question %d", i + 1));
			row.put("row2", R.drawable.ic_correct_q);

			data.add(row);
		}

		String[] from = new String[] { "row1", "row2" };
		int[] to = new int[] { R.id.row1Tv, R.id.row2Tv };

		Context c = getApplicationContext();

		ListAdapter adapter = new SimpleAdapter(c, data,
				R.layout.custom_list_row, from, to);
		setListAdapter(adapter);

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
		}
		return super.onOptionsItemSelected(item);
	}

}
