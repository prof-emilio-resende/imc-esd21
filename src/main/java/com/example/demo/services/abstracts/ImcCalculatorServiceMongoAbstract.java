package com.example.demo.services.abstracts;

import java.util.List;

import com.example.demo.views.PersonViewModel;

public interface ImcCalculatorServiceMongoAbstract {
    public List<PersonViewModel> getAll();
    public PersonViewModel calculate(PersonViewModel p);
}
