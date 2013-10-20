package com.madness.mm;

public class Atom {
	
	private int id;
	private String name;
	private String symbol;
	private Atom[] bonds;
	
	public Atom(int id, String name, String symbol){
		this.id = id;
		this.name = name;
		this.symbol = symbol;
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	//solver:
	//somehow connect two atoms via the UI
	//add those atoms to each other's bond arrays
	//have hardcoded solutions put in
	//maybe change this in the future

	public void delete(){
		//idk lol
	}
	
}
