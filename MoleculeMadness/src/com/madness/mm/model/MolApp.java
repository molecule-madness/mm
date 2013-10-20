package com.madness.mm.model;

import android.app.Application;

public class MolApp extends Application {
	private Quiz quiz;
	
	public void mkNewQuiz(boolean gameType, boolean gameDiff) {
		quiz = new Quiz(gameType, gameDiff);
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
}
