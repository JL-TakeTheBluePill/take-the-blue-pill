package com.bluepill.bingo.web.rest;


import com.bluepill.bingo.web.rest.dto.bingo.Game;
import com.bluepill.bingo.web.rest.dto.bingo.Meeting;
import com.bluepill.bingo.web.rest.dto.bingo.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/bingo", produces = MediaType.APPLICATION_JSON_VALUE)
public class BingoResource {

    Meeting session = new Meeting();

    @RequestMapping(value = "/game}", method = RequestMethod.GET)
    public ResponseEntity<Game> game() {
        return new ResponseEntity<>(session.getGame(), HttpStatus.OK);
    }

    @RequestMapping(value = "/draw}", method = RequestMethod.GET)
    public ResponseEntity<Product> draw() {
        return new ResponseEntity<>(session.getGame().drawProduct(), HttpStatus.OK);
    }
}
