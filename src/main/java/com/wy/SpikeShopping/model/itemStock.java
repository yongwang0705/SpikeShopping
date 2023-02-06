package com.wy.SpikeShopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class itemStock {
    @Id
    long id;
    int stock;
    long itemId;
    long userId;
    double itemPrice;
    int amout;
    long orderPrice;
    long promoId;
}
