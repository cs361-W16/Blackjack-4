package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Chongxian Chen on 3/12/16.
 */
public class GameTest {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }

    @Test
    public void testGameInit(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        assertNotEquals(0,g.deck.get(0).getValue());
    }

    @Test
    public void testGameStart() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();
        assertEquals(2, g.player2.hand.get(0).size());
        assertEquals(2, g.player1.hand.get(0).size());

    }
}
