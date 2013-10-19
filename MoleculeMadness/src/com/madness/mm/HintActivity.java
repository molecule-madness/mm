package com.madness.mm;

import com.madness.mm.model.Hint;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;

public class HintActivity extends Activity {

	private LinearLayout ansLayout;
	private Button[] btns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hint, menu);
		return true;
	}

	private void initView() {
		setContentView(R.layout.activity_hint);

		btns = new Button[Hint.Q_PER_HINT];
		
		ansLayout = (LinearLayout) findViewById(R.id.ansLayout);
		
		for (int i = 0; i < btns.length; i++) {
			Button b = new Button(this);
			b.setMinWidth(R.dimen.hint_btn_min_width);
			b.setText(R.string.hint_btn_def_txt);
			
			btns[i] = b;
			ansLayout.addView(b);
		}
	}

}
