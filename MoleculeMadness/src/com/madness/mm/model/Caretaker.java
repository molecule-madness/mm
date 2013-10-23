package com.madness.mm.model;

import java.util.ArrayList;

/**
 * @author Alex Kahn
 * @className Caretaker.java
 * @date 10/18/2013
 * @classDescription- this class will be the caretaker of the memento pattern
 */
public class Caretaker {
    private ArrayList<Memento> savedQuizes = new ArrayList<Memento>();
    public void add_Memento(Memento m){
        savedQuizes.add(m);
    }

   public Memento get_Memento(int index){
        return savedQuizes.get(index);
    }
}
