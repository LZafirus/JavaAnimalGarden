package com.company.model;

public class Cat extends Animal {

    String rase;

    public Cat() {

    }

    public Cat(Gender gender, String name, int age, int x, int y, Human owner, String rase, int id) {
        super(gender, name, age, x, y, owner, id);
        this.rase = rase;
    }

    @Override
    public String toString() {
        return "Cat: " +
                "rase='" + rase + '\'' +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", age=" + age;
    }

    public String getRase() {
        return rase;
    }

    public void setRase(String rase) {
        this.rase = rase;
    }
}
