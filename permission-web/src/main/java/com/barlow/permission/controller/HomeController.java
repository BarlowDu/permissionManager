package com.barlow.permission.controller;

import com.barlow.permission.dao.ResourceDao;
import com.barlow.permission.dao.UserDao;
import com.barlow.permission.viewmodel.ResourceViewModel;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dutc on 2017/3/13.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Resource(name = "userDao")
    UserDao userDao;

    @Resource(name = "resourceDao")
    ResourceDao resourceDao;

    @RequestMapping(value = "/")
    @RequiresPermissions("user:index")
    public ModelAndView index() {
        ModelAndView result = new ModelAndView("index");
        List<com.barlow.permission.model.Resource> resources=resourceDao.selectAll();
        ResourceViewModel data=new ResourceViewModel(resources.get(0));
        for(int i=1;i<resources.size();i++){
                data.getChildren().add(new ResourceViewModel(resources.get(i)));


        }
        result.addObject("menu",data);
        return result;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView result = new ModelAndView("login");
        Object users = userDao.selectAll();
        result.addObject("users", users);
        return result;
    }

}
