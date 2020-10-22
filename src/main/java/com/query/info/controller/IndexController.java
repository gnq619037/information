package com.query.info.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/10/13 14:35
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(ModelAndView model){
        model.setViewName("login");
        return model;
    }
}
