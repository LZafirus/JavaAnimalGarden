package com.company.model;

import com.company.Writable;

public abstract class BasicModel implements Writable {

    public enum Gender {
        FEMALE("Female"),
        MALE("Male");

        private String gender;

        Gender(String statusGender) {
            this.gender = statusGender;
        }
    }

    public Gender gender;
    protected String name;
    protected int age;

    public BasicModel() {
    }

    public BasicModel(Gender gender, String name, int age) {
        this.gender = gender;
        this.name = name;
        this.age = age;
    }

    // ---------------------------------------------------------

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
