package com.github.zohocrmkivio.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebhookPayload {
    private String event;
    private Payload payload;
}

