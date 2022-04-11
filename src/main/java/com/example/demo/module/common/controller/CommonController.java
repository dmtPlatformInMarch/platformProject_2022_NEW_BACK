package com.example.demo.module.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequiredArgsConstructor
public class CommonController {

    @RequestMapping("/")
    public String main(HttpServletRequest request, Model model) {
        return "/home";
    }

}
