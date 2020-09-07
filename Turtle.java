package com.company.model;

public class Turtle extends Animal {

    public enum Feeding {
        ACTIVE("Feeded"),
        HIDDEN("Hungry");

        private String status;

        Feeding(String feed) {
            this.status = feed;
        }
    }

    public Feeding status;

    public Turtle(Feeding status) {
        this.status = status;
    }

    public Turtle() {

    }

    @Override
    public String toString() {
        return "Turtle: " +
                "status=" + status +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", age=" + age;
    }

    public Turtle(Gender gender, String name, int age, int x, int y, Human owner, Feeding status, int id) {
        super(gender, name, age, x, y, owner, id);
        this.status = status;
    }

    public Feeding getStatus() {
        return status;
    }

    public void setStatus(Feeding status) {
        this.status = status;
    }
}
