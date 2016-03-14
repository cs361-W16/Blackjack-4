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

    @Test
    public void testPlayerHit(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();
        g.playerHit(0);
        assertEquals(3, g.player2.hand.get(0).size());
    }

    @Test
    public void testDealerTurn() {
        Game g = new Game();
        g.deck.add(new Card(10, Suit.Clubs, " "));
        g.deck.add(new Card(10, Suit.Hearts, " "));
        g.deck.add(new Card(6, Suit.Diamonds, " "));
        g.deck.add(new Card(10, Suit.Diamonds, " "));
        g.deck.add(new Card(6, Suit.Clubs, " "));
        g.dealerHit();
        assertEquals("In progress", g.winstate);
    }

    @Test
    public void testCheckWin(){
        Game g = new Game();
        g.buildDeck();
        g.dealTwo();
        assertEquals("In progress", g.winstate);
    }
}
