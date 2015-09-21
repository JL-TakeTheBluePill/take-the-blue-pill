package com.bluepill.bingo.web.rest;


import com.bluepill.bingo.web.rest.dto.bingo.Game;
import com.bluepill.bingo.web.rest.dto.bingo.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping(value = "api/bingo", produces = MediaType.APPLICATION_JSON_VALUE)
public class BingoResource {

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ResponseEntity<Game> game() {

        List<Product> products = new LinkedList<Product>();
        for (int i = 0; i < 90; i++) {
            products.add(new Product(String.valueOf(i), "img"+i));
        }

        Game game = new Game(products, 0);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
}
