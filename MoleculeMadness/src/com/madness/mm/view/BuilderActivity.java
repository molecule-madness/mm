package com.madness.mm.view;

import com.madness.mm.R;
import com.madness.mm.model.MolApp;
import com.madness.mm.model.Question;
import com.madness.mm.model.Quiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class BuilderActivity extends Activity {

	private MolApp app;

	private TextView tvInstruction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_builder);

		app = (MolApp) getApplication();

		tvInstruction = (TextView) findViewById(R.id.builder_instruction);
	}

	@Override
	protected void onStart() {
		super.onStart();

		Quiz quiz = app.getQuiz();
		setTitle(String.format("Question %d", quiz.getQuestionNum()));

		Question q = quiz.getQuestion();

		tvInstruction.setText(q.getInstruction());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.builder, menu);
		return true;
	}

}
