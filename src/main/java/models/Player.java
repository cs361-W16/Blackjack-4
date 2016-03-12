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

    public int hand_value(int hand_num){
        int value = 0;
        int num_Ace = 0;
        int total_value = 0;
        for (int i = 0; i < hand.get(hand_num).size(); i++) {
            value = hand.get(hand_num).get(i).getValue();
            if (value >= 10){
                value = 10;
            }
            else if (value == 1) {
                num_Ace++;
            }
            total_value += value;
        }
        //regard Ace as 1 until here
        //If we do have Ace, then if our total_value+10 is no greater than 21
        //tatal_value += 10 because Ace is value 1 before.
        if (num_Ace >=1){
            if (total_value+10 <= 21){
                total_value+=10;
            }
        }
        return total_value;
    }
}
