package com.example.demo.controllers;

import java.util.List;

import com.example.demo.services.abstracts.ImcCalculatorServiceAbstract;
import com.example.demo.views.PersonViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa/imc")
public class ImcJpaController {
    @Autowired
    ImcCalculatorServiceAbstract service;

    @GetMapping("/")
    public List<PersonViewModel> getAll() {
        return service.getAll();
    }

    @PostMapping("/")
    public PersonViewModel calculate(@RequestBody PersonViewModel vm) {
        return service.calculate(vm);
    }
}
