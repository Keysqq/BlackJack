package com.example.blackjack;

public class Card {

    //private String suit;
    private int suit;
    private  int number;
    private String pip;


    public Card(String pip,int suit, int number) {
        this.suit = suit;
        this.number = number;
        this.pip = pip;
    }

    public int getSuit(){
        return suit;
    }
    public String getPip(){
        return pip;
    }
    public  int getNumber(){
        return number;
    }


}//
