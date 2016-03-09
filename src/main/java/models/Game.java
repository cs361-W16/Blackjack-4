package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Chongxian Chen on 3/9/16.
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public int score_p1;
    public int score_p2;
    public int bet;


    public Game(){
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        score_p1 = 0;
        score_p2 = 0;
        bet = 2;
    }

    public void buildDeck() {
        String name;
        for(int i = 2; i < 15; i++){
            if (i == 14) name = "Ace ";
            else if (i == 13) name = "King ";
            else if (i == 12) name = "Queen ";
            else if (i == 11) name = "Jack ";
            else name = Integer.toString(i) + " ";
            deck.add(new Card(i,Suit.Clubs, name));
            deck.add(new Card(i,Suit.Hearts, name));
            deck.add(new Card(i,Suit.Diamonds, name));
            deck.add(new Card(i,Suit.Spades, name));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }


    //deal two cards for player and dealer initially
    public void dealTwo() {
        for(int i = 0; i < 2; i++){
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }

    }


}

