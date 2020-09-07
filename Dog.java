package com.company.model;

public class Dog extends Animal {
    String rase;

    public Dog(Gender gender, String name, int age, int x, int y, Human owner, String rase, int id) {
        super(gender, name, age, x, y, owner, id);
        this.rase = rase;
    }

    public Dog() {

    }

    @Override
    public String toString() {
        return "Dog: " +
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
