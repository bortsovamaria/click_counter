package com.counter.controller;

import com.counter.model.CountEntity;
import com.counter.repository.CountRepository;
import com.counter.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class CounterController {

    @Autowired
    CountRepository countRepository;

    @Autowired
    ICountService countService;

    @GetMapping
    public String main() {
        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="somebody!") String name, HashMap<String, String> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/showClick")
    public String main(Model model) {

        long number = countRepository.count();
        model.addAttribute("number", number);
        return "showClick";
    }

    @PostMapping("/showClick")
    public String add(Model model) {

        CountEntity counter = new CountEntity();
        countRepository.save(counter);

        long number = countService.getCount();
        model.addAttribute("number", number);
        return "showClick";
    }
}
