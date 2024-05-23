package com.github.zohocrmkivio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Hey, this is Yash, who created this backend service and deployed it on the cloud! <br> Isn't it amazing!";
    }
}
