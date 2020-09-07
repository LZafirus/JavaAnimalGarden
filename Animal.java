package com.company.model;

import com.company.Writable;

public class Animal extends BasicModel implements Writable {

    private static int animalCount = 201;
    private int x, y;
    private Human owner;
    private int id;

    public Animal(Gender gender, String name, int age, int x, int y, Human owner, int id) {
        super(gender, name, age);
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.id = id;
    }

    public Animal() {
        this.id = animalCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    @Override
    public String getFileName() {
        return "animal.txt";
    }

    @Override
    public String getDataToSave() {
        String result = "";
        result += name + "\n";
        result += owner + "\n";
        result += gender + "\n";
        result += age + "\n";
        result += id + "\n";
        result += x + " " + y;

        return result;
    }
}
