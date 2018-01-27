package com.jsohwiz.jsohwiz.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String enterIndex() {
        return "index";
    }

    @RequestMapping(path = "/", params = "zatwierdzanie", method = RequestMethod.POST)
    public String goToPelnomocnik() {
        return "redirect:/zatwierdzanie";
    }

    @RequestMapping(path = "/", params = "opracowywanie", method = RequestMethod.POST)
    public String goToDziekan() {
        return "redirect:/opracowywanie";
    }
}