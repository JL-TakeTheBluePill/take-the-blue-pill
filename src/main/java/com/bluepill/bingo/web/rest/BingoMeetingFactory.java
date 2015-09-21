package com.bluepill.bingo.web.rest;

import com.bluepill.bingo.web.rest.dto.bingo.Game;
import com.bluepill.bingo.web.rest.dto.bingo.Product;
import com.bluepill.bingo.web.rest.dto.bingo.SearchApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.*;

@Component
public class BingoMeetingFactory {

    Game game;

    public Game getGame() {
        return game;
    }

    public Game newGame(String searchTerm) {
        List<Product> products = getProductsBySearch(searchTerm);
        game = new Game(products, 1);
        return game;
    }


    //Use this to stub out API call
    List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();

        for ( int i = 0; i< 12 ;i++ ) {
            Product product  = new Product( String.valueOf(i+1), "http://johnlewis.scene7.com/is/image/JohnLewis/23444402" + i);
            products.add(product);
        }
        return products;
    }

    List<Product> getProductsBySearch(String searchTerm) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
            .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        SearchApiResponse response = restTemplate.getForObject("https://api.johnlewis.com/v1/products/search?q="+searchTerm+"&key=7xgtieKjAlGeGVUef2KgD2yktbtuVqwx&pageSize=90", SearchApiResponse.class);

        int productNum = 1;
        List<Product> products = response.getProducts();
        for (Product product : products) {
            product.setId(String.valueOf(productNum++));

            String urlWithoutQueryParms = StringUtils.substringBefore(product.getImage(), "?");
            product.setImage(urlWithoutQueryParms);
        }

        return response.getProducts();
    }

}
