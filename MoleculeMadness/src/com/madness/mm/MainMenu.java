package com.madness.mm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends Activity {

    private OrderedButton[] btns;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
<<<<<<< HEAD

        // register the start game button with a listener
        Button startButton = (Button)findViewById(R.id.Start_button);
=======
		
		Intent intent = new Intent(this, NewGameActivity.class);
		startActivity(intent);
>>>>>>> 0b6040b7807dba39826dd619860aed43f7ba0c98
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

        private class OrderedButton extends Button {
            private int index;

            public OrderedButton(Context context, int index) {
                super(context);
                this.index = index;
                // TODO Auto-generated constructor stub
            }
}