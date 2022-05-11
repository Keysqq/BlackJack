package com.example.blackjack;

public class Card {

    private String suit;
    private  int number;
    private String pip;


    public Card(String pip,String suit, int number) {
        this.suit = suit;
        this.number = number;
        this.pip = pip;
    }

    public String getSuit(){
        return suit;
    }
    public String getPip(){
        return pip;
    }
    public  int getNumber(){
        return number;
    }


}//
