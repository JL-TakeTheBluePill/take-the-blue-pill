package com.bluepill.bingo.web.rest.dto.bingo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Game {

    List<Product> products;
    List<Product> tumbowler;
    List<Card> cards;

    public Game(List<Product> products, int cards) {
        this.products = products;
        this.tumbowler = new LinkedList(products);

        for (int i = 0; i < cards; i++) {
            addCard();
        }
    }

    public void addCard() {
        Collections.shuffle(products);
        Card card = new Card(products.subList(0, 15));
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public Product getProduct() {
        Collections.shuffle(tumbowler);
        return tumbowler.remove(0);

    }
}
