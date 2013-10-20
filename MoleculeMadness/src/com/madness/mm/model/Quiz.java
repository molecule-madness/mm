package com.madness.mm.model;

import java.util.ArrayList;

import com.madness.mm.Memento;

/* @author Alex Kahn
 * @className Quiz.java
 * @date 10/18/2013
 * @classDescription- This class will serve as the orginator in the memento
 *  pattern and also as the primary driver of the the model
 */
public class Quiz {

	private Quiz state;
	private boolean gameType;
	private boolean gameDiff;
	private ArrayList<Question> questions;
	
	private Integer qPtr;

	/*
	 * if difficulty is true its easy else its hard if type is false its scoring
	 * else its time attack
	 */
	public Quiz(boolean gameType, boolean gameDiff) {
		this.gameType = gameType;
		this.gameDiff = gameDiff;

		questions = new ArrayList<Question>();
		qPtr = 0;
		
		Question q1 = new Question("Build Water");
		q1.addBond("O_0", "H_0");
		q1.addBond("O_0", "H_1");
		questions.add(q1);
		
		Question q2 = new Question("Build Gasseous Nitrogen");
		q2.addBond("N_0", "N_1");
		questions.add(q2);
	}
	
	public Question getQuestion() {
		return questions.get(0);
	}
	
	public Integer getQuestionNum() {
		return qPtr + 1;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public Memento create_Memento() {
		System.out.println("Creating the memento");
		return new Memento(state);
	}

	public void set_Memento(Quiz quiz) {
		System.out.println("Setting the memento");
		state = quiz;
	}

	public void restore_From_Memento(Memento m) {
		state = m.get_State();
		System.out.println("restoring the state");
	}
}
