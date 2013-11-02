package com.madness.mm.view;

import java.util.List;

import com.madness.mm.R;
import com.madness.mm.R.layout;
import com.madness.mm.R.menu;
import com.madness.mm.model.MolApp;
import com.madness.mm.model.Question;
import com.madness.mm.model.Quiz;
import com.madness.mm.StatsActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends Activity {
	
	/**
	 * The master domain object, also known as global state
	 */
	private MolApp app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int correct=0;
		int total=0;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		// retrieve the domain object
		app = (MolApp) getApplication();
		
		// grab the current quiz
		Quiz quiz = app.getQuiz();
		
		correct = getCorrectQuestions(quiz);
		total = quiz.getQuestions().size();
		
		TextView score = (TextView) findViewById(R.id.score);
		score.setText(correct + " / " + total);
		
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
		
		// go to the stats screen
		btnStats.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ResultsActivity.this, 
						StatsActivity.class));
				
			}
		});
		
	}

	/**
	 * Runs through the list of questions 
	 * 
	 * @return
	 */
	private int getCorrectQuestions(Quiz quiz){
		List<Question> questions;
		int correct=0;
		
		questions = quiz.getQuestions();
		
		for (Question q: questions){
			if(q.getGrade()) correct++;
		}
		
		return correct;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

}
