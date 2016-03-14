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
    public Dealer player1;
    public Customer player2;
    int winstate; //0 = in progress, 1 = win, 2 = loss, 3 = draw

    public Game(){
        player1 = new Dealer();
        player2 = new Customer();
        score_p1 = 0;
        score_p2 = 0;
        bet = 2;
        winstate = 0;
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

    public void checkWin() {
        if (winstate == 0) {
            if (score_p1 > score_p2) winstate = 2;
            if (score_p2 > score_p1) winstate = 1;
            if (score_p1 == score_p2) winstate = 3;
        }
    }

    public void playerHit(int handnum){
        if (winstate == 0) {
            player2.hit(deck, handnum);
            score_p2 = player2.hand_value(handnum);
            if (score_p2 > 21) winstate = 2; //check for bust
        }
    }

    public void dealerHit(){
        player1.hit(deck, 0);
        score_p1 = player1.hand_value(0);
        if (score_p1 > 21) winstate = 1; //check for bust
    }

    public void dealerTurn() { //activated when player stands
        while (score_p1 < 17) {
            dealerHit();
        }
        checkWin();
    }


}

