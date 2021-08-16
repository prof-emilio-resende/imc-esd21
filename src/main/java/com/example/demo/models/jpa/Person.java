package com.example.demo.models.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double weight;
    private double height;
    private String imcDescription;
    private double imc;

    public void calculate() {
        this.imc = this.weight / Math.pow(this.height, 2);

        System.out.println(this.imc);
        if (this.imc < 18.5)
            this.imcDescription = "Magreza";
        else if (this.imc < 24.9)
            this.imcDescription = "Normal";
        else if (this.imc <= 30.0)
            this.imcDescription = "Sobrepeso";    
        else if (this.imc > 30.0)
            this.imcDescription = "Obesidade";
    }

    @Override
    public String toString() {
        System.out.println("to string ...");
        System.out.println(this.getImc());
        System.out.println(this.getImcDescription());
        return String.format("%.2f : %s", this.getImc(), this.getImcDescription());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getImcDescription() {
        return imcDescription;
    }
    public void setImcDescription(String imcDescription) {
        this.imcDescription = imcDescription;
    }
    public double getImc() {
        return imc;
    }
    public void setImc(double imc) {
        this.imc = imc;
    }
}
