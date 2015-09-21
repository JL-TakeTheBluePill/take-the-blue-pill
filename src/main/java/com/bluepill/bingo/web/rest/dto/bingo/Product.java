package com.bluepill.bingo.web.rest.dto.bingo;

/**
 * Created by tddp on 9/21/15.
 */
public class Product {

    String id;
    String imgURL;

    public Product(String id, String imgURL) {
        this.id = id;
        this.imgURL = imgURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
