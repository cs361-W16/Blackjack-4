package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Chongxian Chen on 3/12/16.
 */
public class CardTest {
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.Clubs, " ");
        assertEquals(Suit.Clubs,c.getSuit());
    }

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.Clubs, " ");
        assertEquals("5Clubs",c.toString());
    }



}
