package com.bluepill.bingo.web.rest;

import com.bluepill.bingo.web.rest.dto.bingo.Game;
import com.bluepill.bingo.web.rest.dto.bingo.Product;
import com.bluepill.bingo.web.rest.dto.bingo.SearchApiResponse;
import groovyx.net.http.ContentType;
import groovyx.net.http.HttpResponseDecorator;
import groovyx.net.http.RESTClient;
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

    public BingoMeetingFactory() throws UnrecoverableKeyException, URISyntaxException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        List<Product> products = getProductsBySearch();

        game = new Game(products, 1);
    }

    public Game getGame() {
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

    List<Product> getProductsBySearch() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
            .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        SearchApiResponse response = restTemplate.getForObject("https://api.johnlewis.com/v1/products/search?q=blue&key=7xgtieKjAlGeGVUef2KgD2yktbtuVqwx&pageSize=90", SearchApiResponse.class);

  //     System.out.println(response);

        int productNum = 1;
        List<Product> products = response.getProducts();
        for (Product product : products) {
            product.setId(String.valueOf(productNum++));
        }

        return response.getProducts();
    }


    List<Product> getProductsBySearchHttpClient() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, URISyntaxException {

        RESTClient api = new RESTClient("https://api.johnlewis.com/v1/products/search?q=blue&key=7xgtieKjAlGeGVUef2KgD2yktbtuVqwx&pageSize=90");
        //Use JVM properties for this if set, as this won't work if we run this from FAT
        api.ignoreSSLIssues();
        //  api.setProxy("localhost", 3128, "http");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "Wget/1.12 (linux-gnu)");

        api.setHeaders(headers);

        HttpResponseDecorator response = null;
        Map<String, Object> getStuff = new HashMap<String, Object>();
        getStuff.put("path", "");
        getStuff.put("contentType", ContentType.ANY);

        try {
            response = (HttpResponseDecorator) api.get(getStuff);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("  ");
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("**------- RESPONSE STATUS -------**");

        if (response != null) {
            System.out.println(response.getStatus());
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println(" -------- DATA ------- ");
            System.out.println(response.getData());

        } else {
            System.out.println("RESPONSE STILL NULL");
        }
//
//        sysout '**------- RESPONSE STATUS -------**'
//        println response.status
//        println '**------- RESPONSE CONTENT TYPE -------**'
//        println response.contentType
//        println '**---------- DATA --------**'
//        println response.data
//        println '**---------- END --------**'

        return null;

    }

}
