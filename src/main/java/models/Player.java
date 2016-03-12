package models;

import java.util.ArrayList;

/**
 * Created by Chongxian Chen on 3/9/16.
 */
public class Player {
    private int money;

    public void bet(int amount){
        money = money - amount;
    }

    public java.util.List<java.util.List<Card>> hand = new ArrayList<>();

    public Player() {
        //hand
        hand.add(new ArrayList<Card>());
    }

    public void hit(java.util.List<Card> deck, int hand_num){
        //hand_num is 0 if there is no split
        hand.get(hand_num).add(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
    }
}
