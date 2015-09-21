package com.bluepill.bingo.web.rest.dto.bingo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Game {

    List<Product> products;
    List<Product> tumbowler;
    List<Card> cards;

    public Game(List<Product> products, int numberOfCards) {
        this.products = products;
        this.tumbowler = new LinkedList(products);

        cards = new LinkedList<>();
        for (int i = 0; i < numberOfCards; i++) {
            Collections.shuffle(products);
            cards.add(new Card(products.subList(0, 15)));
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public Product drawProduct() {
        Collections.shuffle(tumbowler);
        return tumbowler.remove(0);

    }
}
