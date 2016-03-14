/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import com.google.inject.Singleton;
import models.Game;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {

        return Results.html();

    }

    public Result helloWorldJson() {

        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Hello World! Hello Json!";

        return Results.json().render(simplePojo);

    }

    public static class SimplePojo {

        public String content;

    }

    public Result blackJack() {
        return Results.html().template("views/BlackJack/BlackJack.flt.html");
    }

    public Result gameGet() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();

        return Results.json().render(g);
    }

    public Result newGame(Context context, Game g) {
        g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();

        return Results.json().render(g);
    }

    public Result hit(Context context, @PathParam("hand") int handNumber, Game g) {
        //to avoid hit for empty hand
        if (g.player2.hand.get(handNumber).size() > 1) {
            g.playerHit(handNumber);
            //score only display the first hand's value, may want to fix this later?
            g.score_p2 = g.player2.hand_value(0);
        }
        return Results.json().render(g);
    }

    public Result split(Context context, Game g) {
            if (g.player2.hand_has_two_same_value()) {
                g.player2.split();
            } else {
                System.out.println("You don't have two cards of same value");
            }

        return Results.json().render(g);
    }

    public Result stay(Context context, Game g) {
        if (g.score_p2 <= 21) {
            while (g.score_p1 < 17) {
                g.dealerHit();
            }
            g.checkWin();
        }
        return Results.json().render(g);
    }
}
