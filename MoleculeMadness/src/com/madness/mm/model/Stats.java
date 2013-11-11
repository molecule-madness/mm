package com.madness.mm.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Alex Kahn
 * @className Stats.java
 * @date 10/18/2013
 * @classDescription- This class will graph the past scores of the user and
 *                    perform other analytic functions
 */
public class Stats {

	ArrayList<Integer> scores = new ArrayList<Integer>();

    private Stats(){

    }
    private static class StatsHolder{
        private static final Stats INSTANCE = new Stats();
    }
    public static Stats getInstance(){
        return StatsHolder.INSTANCE;
    }
	// will make a line graph for the just the scores
	public void make_Graph(int[] scores) {

	}

	// we need to start the timer and then end it and look at the milliseconds
	public void make_Graph_TimeAttack(Date[] times) {

	}
    public void addScore(int score){
        scores.add(score);
    }
	/*
	 * computes the average of an arraylist of ints
	 */
	public double computeAverage() {
		double average = 0;
		int sum = 0;
		for (Integer grade : scores) {
			sum += grade;
		}
		average = sum / scores.size();
		return average;
	}

	/*
	 * grabs the first element of the array if its not empty and then compares
	 * it to every element in the array if the compared to element is less than
	 * the first one grabbed it sets it equal
	 */
	public int findLowestScore() {
		if (!scores.isEmpty()) {
			int temp = scores.get(0);
			for (Integer grade : scores) {
				if (grade < temp) {
					temp = grade;
				}
			}
			return temp;
		}
		System.out.println("There are no scores");
		return 0;
	}

	/*
	 * grabs the first element of the array if its not empty and then compares
	 * it to every element in the array if the compared to element is greater than
	 * the first one grabbed it sets it equal
	 */
	public int findHighScore() {
		if (!scores.isEmpty()) {
			int temp = scores.get(0);
			for (Integer grade : scores) {
				if (grade > temp) {
					temp = grade;
				}
			}
			return temp;
		}
		System.out.println("There are no scores");
		return 0;
	}
}