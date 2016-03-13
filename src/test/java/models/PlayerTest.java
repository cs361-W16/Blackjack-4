package models;

import org.junit.Test;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static com.thoughtworks.selenium.SeleneseTestBase.assertNotEquals;

/**
 * Created by Chongxian Chen on 3/12/16.
 */
public class PlayerTest {

    @Test
    public void testHit(){

        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.player1.hit(g.deck, 0);
        assertEquals(1, g.player1.hand.get(0).size());
    }
    @Test
    public void testHandValue(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.player1.hit(g.deck, 0);
        assertNotEquals(0, g.player1.hand_value(0));
    }
}
