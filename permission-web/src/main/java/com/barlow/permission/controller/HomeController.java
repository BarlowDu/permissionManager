package com.barlow.permission.controller;

import com.barlow.permission.ResourceService;
import com.barlow.permission.dao.ResourceDao;
import com.barlow.permission.dao.UserDao;
import com.barlow.permission.viewmodel.ResourceViewModel;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
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

    @Resource
    ResourceService resourceService;

    @RequestMapping(value = "/")
    @RequiresPermissions("user:index")
    public ModelAndView index() {
        ModelAndView result = new ModelAndView("index");
        List<com.barlow.permission.viewmodel.ResourceViewModel> resources=resourceService.getMenu();

        result.addObject("menu",resources);
        return result;
    }

    @RequestMapping(value = "/list")
    @RequiresPermissions("resource:list")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("index");
        List<com.barlow.permission.viewmodel.ResourceViewModel> resources=resourceService.getMenu();

        result.addObject("menu",resources);
        return result;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request,Model model) {
        ModelAndView result = new ModelAndView("login");
        Object users = userDao.selectAll();
        result.addObject("users", users);
        return result;
    }

}
