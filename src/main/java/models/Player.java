package models;

/**
 * Created by georgechen on 3/9/16.
 */
public class Player {
    private int money;

    public void bet(int amount){
        money = money - amount;
    }
}
