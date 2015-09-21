package com.bluepill.bingo.web.rest.dto.bingo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by tddp on 9/21/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchApiResponse {

    List<Product> products;

    public SearchApiResponse() {

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



}
