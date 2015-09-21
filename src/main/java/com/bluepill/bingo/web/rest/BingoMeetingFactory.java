package com.bluepill.bingo.web.rest;

import com.bluepill.bingo.web.rest.dto.bingo.Game;
import com.bluepill.bingo.web.rest.dto.bingo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class BingoMeetingFactory {

    Game game;

    public BingoMeetingFactory() {

        List<Product> products = new ArrayList<Product>();

        for ( int i = 0; i< 12 ;i++ ) {
            Product product  = new Product( String.valueOf(i+1), "http://johnlewis.scene7.com/is/image/JohnLewis/23444402" + i);
            products.add(product);
        }

        game = new Game(products, 1);
    }

    public Game getGame() {
        return game;
    }
}
