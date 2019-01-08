package com.fmz.learn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationController {

    @RequestMapping("/welcomePage4")
    public ModelAndView getEmployeeName() {
        ModelAndView model = new ModelAndView("welcomePage4");
        model.addObject("user", "AnnotationController");
        return model;
    }

    @RequestMapping("/welcomePage5")
    public ModelAndView getEmployeeNam() {
        ModelAndView model = new ModelAndView("welcomePage5");
        model.addObject("user", "AnnotationController2");
        return model;
    }
}
