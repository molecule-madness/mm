package com.madness.mm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	}
        Button startButton = (Button)findViewById(R.id.Start_button);
        startButton.setOnClickListener(startListener); // Register the onClick listener with the implementation above

        Button buttonStop = (Button)findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(stopListener); // Register the onClick listener with the implementation above
    }

    //Create an anonymous implementation of OnClickListener
    private OnClickListener startListener = new OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(TwoButtonApp.this, "The Start button was clicked.", Toast.LENGTH_LONG).show();
        }
    };

    // Create an anonymous implementation of OnClickListener
    private OnClickListener stopListener = new OnClickListener() {
        public void onClick(View v) {
            Log.d(logtag,"onClick() called - stop button");
            Toast.makeText(TwoButtonApp.this, "The Stop button was clicked.", Toast.LENGTH_LONG).show();
            Log.d(logtag,"onClick() ended - stop button");
        }
    };

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}