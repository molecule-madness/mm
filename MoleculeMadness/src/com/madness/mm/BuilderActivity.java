package com.madness.mm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BuilderActivity extends Activity {

	//take in question
	//using question, dynamically change info
	//create atoms and put them into bottom screen, add one or two extra depending on how many elements are present in question
	//implement drag and drop
	//do solver??? i don't know probably not
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_builder);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.builder, menu);
		return true;
	}

}
