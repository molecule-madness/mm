package com.madness.mm.view;

import com.madness.mm.R;
import com.madness.mm.R.layout;
import com.madness.mm.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ResultsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		Button btnMain 	= (Button) findViewById(R.id.results_btn_main);
		
		// go back to the main menu
		btnMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ResultsActivity.this, 
						MainMenuActivity.class));
				
			}
		});
		
		Button btnReview 	= (Button) findViewById(R.id.results_btn_review);
		
		// go to the review screen
		btnReview.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ResultsActivity.this, 
						ReviewActivity.class));
				
			}
		});
				
		Button btnStats 	= (Button) findViewById(R.id.results_btn_stats);
/*		
		// go to the stats screen
		btnMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ResultsActivity.this, 
						StatsActivity.class));
				
			}
		});
*/		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

}
