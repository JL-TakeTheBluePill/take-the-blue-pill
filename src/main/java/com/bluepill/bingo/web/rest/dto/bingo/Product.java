package com.bluepill.bingo.web.rest.dto.bingo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tddp on 9/21/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    String id;
    String image;

    public Product() {

    }

    public Product(String id, String imgURL) {
        this.id = id;
        this.image = imgURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
