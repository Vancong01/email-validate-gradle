package com.codegym.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Calculator {
    @GetMapping("/form")
    public String  showForm(Model model){
        return "index";
    }
    @PostMapping("/calculate")
    public ModelAndView calculator(@RequestParam("operator")String operator, @RequestParam("firstOperand") float firstOperand, @RequestParam("secondOperand") float secondOperand){
        ModelAndView modelAndView = new ModelAndView("index");
        float result;
        if (operator.equals("+")){
            result = add(firstOperand, secondOperand);
            modelAndView.addObject("result", result);
        } else if (operator.equals("-")){
            result = sub(firstOperand, secondOperand);
            modelAndView.addObject("result", result);
        }else if (operator.equals("*")){
            result = mul(firstOperand, secondOperand);
            modelAndView.addObject("result", result);
        }else if (operator.equals("/") && secondOperand !=0){
            result = div(firstOperand, secondOperand);
            modelAndView.addObject("result", result);
        }else{
            modelAndView.addObject("result", "Mẫu số không được là 0.");
        }
        return modelAndView;
    }

    public float add(float a, float b){
        return a+b;
    }
    public float sub(float a, float b){
        return a -b;
    }
    public float div(float a,float b){
        return a/b;
    }
    public float mul(float a, float b){
        return a *b;
    }
}
