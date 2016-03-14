package models;

import org.junit.Test;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Chongxian Chen on 3/13/16.
 */
public class CustomerTest {

    @Test
    public void testCustomerCreation(){
        Customer c = new Customer();
        assertNotNull(c);
    }
    @Test
    public void testHandHasTwoSameValue() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        //there is no card dealt so there should be no two same value
        assertEquals(g.player2.hand_has_two_same_value(), false);
    }

    @Test
    public void testSplit(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();
        g.player2.split();
        assertEquals(g.player2.hand.get(1).size(), 2);
    }
}
