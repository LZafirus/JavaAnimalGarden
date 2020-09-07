package com.company.model;

import com.company.Writable;

import java.util.ArrayList;
import java.util.List;

public class Human extends BasicModel implements Writable {

    private static int personCount = 101;
    private String surname;
    private int id;
    private String secondName;

    private List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public Human() {
        this.id = personCount++;
    }

    public Human(Gender gender, String name, int age, String surname, int id, String secondName) {
        super(gender, name, age);
        this.surname = surname;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Human: " +
                "surname='" + surname + '\'' +
                ", id=" + id +
                ", secondName='" + secondName + '\'' +
                ", animalList=" + animalList +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", age=" + age;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    @Override
    public String getFileName() {
        return "humans.txt";
    }

    @Override
    public String getDataToSave() {
        String result = "";
        result += name + "\n";
        result += secondName + "\n";
        result += surname + "\n";
        result += gender + "\n";
        result += age + "\n";
        result += id + "\n";

        return result;
    }
}
