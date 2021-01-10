package com.kn.contactlist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface MainPageController {

    @GetMapping("index")
    String index();
}
