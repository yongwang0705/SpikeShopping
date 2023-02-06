package com.wy.SpikeShopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Promo {
    @Id
    long id;
    String promoName;
    Date startDate;
    Date endDate;
    long itemId;
    double promoPrice;
}
