package com.wy.SpikeShopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
    @Id
    long id;
    long itemId;

}
