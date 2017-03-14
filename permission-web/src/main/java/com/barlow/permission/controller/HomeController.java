package com.barlow.permission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dutc on 2017/3/13.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(value="/")
    public String index(){
        return "index";
    }
}
