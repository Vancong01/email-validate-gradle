package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static Pattern pattern;
    private Matcher matcher;

    /* Khai báo Regex */
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }


    @GetMapping(value = "/home")
    public String getIndex() {
        return "email";
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isvalid = this.validate(email);
        if (!isvalid) {
            model.addAttribute("message", "Email is invalid");
            return "email";
        }
        model.addAttribute("email", email);
        return "success";
    }

    public
    boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
