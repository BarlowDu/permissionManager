package com.barlow.permission.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dutc on 2017/3/13.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(value="/")
    @RequiresPermissions("user:index")
    public ModelAndView index(){

        ModelAndView result=new ModelAndView("index");
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);
        map.put("f",6);
        StringBuilder s=new StringBuilder();
        for(Map.Entry<String,Integer> item:map.entrySet()){
            s.append(item.getKey()).append(':').append(item.getValue()).append(',');
        }
        result.addObject("map",s);
        return result;
    }
}
