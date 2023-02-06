package com.wy.SpikeShopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {
    @Id
    long id;
    String title;
    double price;
    String description;
    String imgUrl;
    int sales;
}
