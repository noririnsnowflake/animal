package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.RegistForm;

@Controller
public class RegistController {

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String regist(Model model) {
        model.addAttribute("registForm", new RegistForm());
        return "regist";
    }
}
