package com.madness.mm.model;

import java.util.ArrayList;
import java.util.Random;

public class Hint {
	public static final int Q_PER_HINT = 3;

	private String question;
	private int correct;
	private String[] answers;

	public Hint(String question, int correct, String... answers) {
		this.question = question;
		this.correct = correct;
		this.answers = answers;

		//assert (answers.length == Q_PER_HINT);
	}

	public void format(HintFormattable hf) {
		hf.setQuestionText(question);

		for (int i = 0; i < answers.length; i++) {
			hf.setAnswerText(i, answers[i]);
		}
	}

	public int getCorrect() {
		return correct;
	}

	public static ArrayList<Hint> hints;

	private static Random r;
	
	private static void initHints() {
		hints = new ArrayList<Hint>();
		
		hints.add(new Hint("What Johhny thought was H20 was actually:", 2,
				"Water", "Nitrogen", "H2SO4"));
		
		hints.add(new Hint("What molecule sustains life?", 0,
				"Water", "Nitrogen", "H2SO4"));
		
		r = new Random();
	}
	
	public static Hint getRandHint() {
		if(hints == null) {
			initHints();
		}
		
		return hints.get(r.nextInt(hints.size()));
	}
}
