package com.example.a15_squares;
import java.util.*;
public class TileModel {

    private int[] numTile = new int[16]; // this array will represent our grid

    private boolean order = false;

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    /*
     * TileModel
     * The constructor for our TileModel class
     */
    TileModel(){
        randomize();
    }

    // randomizes the tile array
    public void randomize(){
        // this creates an arraylist of integers to shuffle
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            al.add(i);
        }

        // this shuffles the array list of integers
        Collections.shuffle(al);

        // this puts the shuffled numbers into our array
        for(int i = 0; i<numTile.length; i++){
            numTile[i] = al.get(i);
        }
    }

    // this returns the array of ints representing our board
    public int[] getNumTile() {
        return numTile;
    }

    // this sets a specific value in the array to a number
    public void setTile(int index, int newNumTile){
        numTile[index] = newNumTile;
    }
}
