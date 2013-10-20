package com.madness.mm;

import java.util.ArrayList;

public class Question {

	/**
	 * The message indicating to the user which molecule to build
	 */
	private String instruction;

	/**
	 * A list of bonds composing the molecule to be built
	 */
	private ArrayList<Bond> bonds;
	
	/**
	 * True if the question has been submitted
	 */
	private boolean finished;
	
	/**
	 * True if the question has been submitted correctly
	 */
	private boolean correct;

	/**
	 * Construct a new Question
	 * 
	 * @param instruction
	 *            the message indicating to the user which molecule to build
	 */
	public Question(String instruction) {
		this.instruction = instruction;
		bonds = new ArrayList<Bond>();
		
		finished = false;
		correct = false;
	}

	public String getQuestion() {
		return this.instruction;
	}

	/**
	 * Add a new bond to a question molecule
	 * @param bonder
	 * @param bondee
	 */
	public void addBond(String bonder, String bondee) {
		bonds.add(new Bond(bonder, bondee));
	}

	public class Bond {
		private String bonder;
		private String bondee;

		public Bond(String bonder, String bondee) {
			this.bonder = bonder;
			this.bondee = bondee;
		}

		public String getBonder() {
			return this.bonder;
		}

		public String getBondee() {
			return this.bondee;
		}
	}
}
