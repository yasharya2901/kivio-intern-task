package com.github.zohocrmkivio.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private String id;
    private double amount;
    private Entity entity;
}
