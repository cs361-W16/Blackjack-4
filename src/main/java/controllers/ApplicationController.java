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

import models.Game;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
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
        g.player2.hit(g.deck, handNumber);
        g.score_p2 = g.player2.hand_value(handNumber);
        return Results.json().render(g);
    }
}
