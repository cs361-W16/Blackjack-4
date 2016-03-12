package models;

import java.util.ArrayList;

/**
 * Created by Chongxian Chen on 3/12/16.
 */
public class Customer extends Player {
    Customer(){
        hand.add(new ArrayList<Card>());
        //more hands for customer for potential split
        //hand.get(1)
        hand.add(new ArrayList<Card>());
        //hand.get(1)
        hand.add(new ArrayList<Card>());

    }
}
