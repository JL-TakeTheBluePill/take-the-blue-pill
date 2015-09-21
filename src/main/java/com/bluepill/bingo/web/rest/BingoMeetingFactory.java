package com.bluepill.bingo.web.rest;

import com.bluepill.bingo.web.rest.dto.bingo.Game;
import com.bluepill.bingo.web.rest.dto.bingo.Product;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class BingoMeetingFactory {

    Game game;

    public BingoMeetingFactory() {
        List<Product> products = new LinkedList<>();
        for (int i = 0; i < 90; i++) {
            products.add(new Product(String.valueOf(i), "img"+i));
        }

        game = new Game(products, 1);
    }

    public Game getGame() {
        return game;
    }
}
