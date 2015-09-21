package com.bluepill.bingo.web.rest.dto.bingo;

import java.util.Collections;
import java.util.List;

public class Card {

    List<Product> products;

    public Card(List<Product> products) {
        this.products = products;
        Collections.shuffle(this.products);
    }

    public List<Product> getProducts() {
        return products;
    }
}
