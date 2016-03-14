package models;

import java.util.ArrayList;

/**
 * Created by Chongxian Chen on 3/12/16.
 */
public class Customer extends Player {

    private int hand_num;

    Customer(){
        hand.add(new ArrayList<Card>());
        //more hands for customer for potential split
        //hand.get(1)
        hand.add(new ArrayList<Card>());
        //hand.get(1)
        hand.add(new ArrayList<Card>());

        hand_num = 3;
    }

    //function in preparation for split
    //only allow the first hand to split
    public boolean hand_has_two_same_value() {
        //store value into array
        //compare new value with previous value
        int[] value_array = new int [hand.get(0).size()];
        int value;
        for (int i = 0; i < hand.get(0).size(); i++) {
            value = hand.get(0).get(i).getValue();
            value_array[i] = value;
            for (int j = 0; j < i; j++) {
                if (value == value_array[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //allow 3 hand most
    public void split(){
        //copy to the 2nd hand
            if (hand.get(1).size() == 0) {
                for (int i = 0; i < hand.get(0).size(); i++) {
                    hand.get(1).add(hand.get(0).get(i));
                }
            }
            //copy to the 3rd hand
            else if (hand.get(2).size() == 0) {
                for (int i = 0; i < hand.get(0).size(); i++) {
                    hand.get(2).add(hand.get(0).get(i));
                }
            }
    }
}
