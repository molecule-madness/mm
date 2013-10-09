package com.madness.mm;

import android.graphics.Color;

public class Atom {
	
	private int id;
	private String name;
	private String symbol;
	private Color color;
	
	public Atom(int id, String name, String symbol, Color color){
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.color = color;
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



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}



	public void delete(){
		//idk lol
	}
	
}
