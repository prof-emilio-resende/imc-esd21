package com.example.demo.services.concrete;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.demo.models.mongo.Person;
import com.example.demo.repositories.ImcPersonMongoRepository;
import com.example.demo.services.abstracts.ImcCalculatorServiceMongoAbstract;
import com.example.demo.views.PersonViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImcCalculatorServiceMongoImpl implements ImcCalculatorServiceMongoAbstract {
    @Autowired
    private ImcPersonMongoRepository repository;

    @Override
    public List<PersonViewModel> getAll() {
        return repository
            .findAll()
            .stream()
            .map(p -> {
                var person = new PersonViewModel();
                person.height = p.getHeight();
                person.weight = p.getWeight();
                person.imc = p.getImc();
                person.imcDescription = p.getImcDescription();
                
                return person;
            })
            .collect(Collectors.toList());
    }

    @Override
    public PersonViewModel calculate(PersonViewModel p) {
        var person = new Person();
        person.setId(UUID.randomUUID());
        person.setHeight(p.height);
        person.setWeight(p.weight);
        person.calculate();
        repository.save(person);

        p.imc = person.getImc();
        p.imcDescription = person.getImcDescription();
        
        return p;
    }
}
