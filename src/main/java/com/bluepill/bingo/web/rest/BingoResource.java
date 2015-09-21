package com.bluepill.bingo.web.rest;


import com.bluepill.bingo.web.rest.dto.bingo.Game;
import com.bluepill.bingo.web.rest.dto.bingo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/bingo", produces = MediaType.APPLICATION_JSON_VALUE)
public class BingoResource {

    @Autowired
    BingoMeetingFactory bingoMeetingFactory;

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ResponseEntity<Game> game() {
        return new ResponseEntity<>(bingoMeetingFactory.getGame(), HttpStatus.OK);
    }

    @RequestMapping(value = "/draw", method = RequestMethod.GET)
    public ResponseEntity<Product> draw() {
        return new ResponseEntity<>(bingoMeetingFactory.getGame().drawProduct(), HttpStatus.OK);
    }
}
