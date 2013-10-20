package com.madness.mm.view;

import com.madness.mm.R;
import com.madness.mm.model.Hint;
import com.madness.mm.model.HintFormattable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HintActivity extends Activity implements HintFormattable {

	public static final Integer HINT_PASS = 0;
	public static final Integer HINT_FAIL = 1;

	private LinearLayout ansLayout;
	private OrderedButton[] btns;

	private TextView hintQuestion;

	private Hint curHint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_hint);
		hintQuestion = (TextView) findViewById(R.id.hintQuestion);
		ansLayout = (LinearLayout) findViewById(R.id.ansLayout);

		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hint, menu);
		return true;
	}

	private void initView() {
		btns = new OrderedButton[Hint.Q_PER_HINT];

		for (int i = 0; i < btns.length; i++) {
			final OrderedButton b = new OrderedButton(this, i);
			b.setMinWidth(R.dimen.hint_btn_min_width);
			b.setText(R.string.hint_btn_def_txt);
			b.setHapticFeedbackEnabled(true);
			
			b.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Context context = getApplicationContext();
					int duration = Toast.LENGTH_SHORT;
					int resId;
					
					if(b.equals(curHint)) {
						setResult(HINT_PASS);
						resId = R.string.hint_pass_toast;
					}
					else {
						setResult(HINT_FAIL);
						resId = R.string.hint_fail_toast;
					}
					
					Toast.makeText(context, resId, duration).show();
					finish();
				}
			});
			
			btns[i] = b;
			ansLayout.addView(b);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();

		curHint = Hint.getRandHint();
		curHint.format(this);
	}

	@Override
	public void setAnswerText(int ansIndex, String answer) {
		btns[ansIndex].setText(answer);
	}

	@Override
	public void setQuestionText(String question) {
		hintQuestion.setText(question);
	}

	private class OrderedButton extends Button {
		private int index;

		public OrderedButton(Context context, int index) {
			super(context);
			this.index = index;
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean equals(Object other) {
			if (other instanceof Hint) {
				Hint that = (Hint) other;

				return that.getCorrect() == this.index;
			}
			return false;
		}
	}
}
