package com.bookworm.bookwormv2.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class base_controller {


    @GetMapping("/")
    public String index(){
        return "base/index";
    }

    @GetMapping("/aboutBookworm")
    public String aboutPage(){
        return "base/about";
    }

}
