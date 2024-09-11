package com.kr.kimchi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/include/map")
public class MapController {

    @GetMapping
    public String Map() {
    	
        return "include/map";
    }
}