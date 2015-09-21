package com.bluepill.bingo.web.rest.dto.bingo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Game {

    List<Product> products;
    List<Product> tumbowler;
    List<Product> drawn;
    List<Card> cards;

    private static final int CARD_SIZE = 12;

    public Game(List<Product> products, int numberOfCards) {
        this.products = products;
        this.tumbowler = new LinkedList(products);
        this.drawn = new LinkedList();

        cards = new LinkedList<>();
        for (int i = 0; i < numberOfCards; i++) {
            Collections.shuffle(products);
            cards.add(new Card(products.subList(0, CARD_SIZE)));
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public Product drawProduct() {
        Collections.shuffle(tumbowler);
        Product draw = tumbowler.remove(0);
        drawn.add(draw);
        return draw;
    }

    public boolean checkForFullHouse(List<String> ids) {
        if (ids.size() != CARD_SIZE || drawn.size() < CARD_SIZE) {
            return false;
        }

        for (Product product : drawn) {
            if (!ids.contains(product.getId())) {
                return false;
            }
        }

        return true;
    }
}
