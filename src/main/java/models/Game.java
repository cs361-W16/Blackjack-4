package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Chongxian Chen on 3/9/16.
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    //public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public int score_p1;
    public int score_p2;
    public int bet;
    public Player player1;
    public Customer player2;

    public Game(){
        player1 = new Player();
        player2 = new Customer();
        score_p1 = 0;
        score_p2 = 0;
        bet = 2;
    }

    public void buildDeck() {
        String name;
        for(int i = 1; i < 14; i++){
            if (i == 1) name = "Ace ";
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
            player1.hit(deck, 0);
            player2.hit(deck, 0);
        }
        score_p1 = player1.hand_value(0);
        score_p2 = player2.hand_value(0);
    }


}

