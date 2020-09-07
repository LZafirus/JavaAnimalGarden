package com.company.database;

import com.company.model.BasicModel;
import com.company.model.Human;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanDatabase {
    public List<Human> humans;

    public HumanDatabase() {
        humans = new ArrayList<>();
        Human human = new Human(BasicModel.Gender.FEMALE, "Klaudia", 30, "Kowalska", 301, "Anna");
        humans.add(human);
    }

    public void addHuman(Scanner scanner) throws IOException {
        int ignore, genderChoice;
        Human human = new Human();

        scanner.nextLine();
        System.out.println("What is your name, please:");
        String name = scanner.nextLine();
        human.setName(name);

        System.out.println("What is your second name: ");
        String secondname = scanner.nextLine();
        human.setSecondName(secondname);

        System.out.println("What is your surname, please:");
        String surname = scanner.nextLine();
        human.setSurname(surname);

        System.out.println("How old are you:");
        int age = scanner.nextInt();
        human.setAge(age);

        System.out.println("What is your gender (m / f) :");
        genderChoice = (char) System.in.read();
        do {
            ignore = (char) System.in.read();
        } while (ignore != '\n');
        if (genderChoice == 'm' || genderChoice == 'M') {
            human.setGender(BasicModel.Gender.MALE);
        }
        if (genderChoice == 'f' || genderChoice == 'F') {
            human.setGender(BasicModel.Gender.FEMALE);
        }

        humans.add(human);
    }

    public void removeHuman(Scanner scanner) {
        System.out.println("Which owner would you like to remove (select ID):");
        getAllSmall();
        Human temp = null;
        int id = scanner.nextInt();
        for (Human human : humans) {
            if (human.getId() == id) {
                temp = human;
                break;
            }
        }
        humans.remove(temp);
        System.out.println("Owner " + temp.getName() + " removed.");
    }

    public Human getHuman(int id) {
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void getAllBig() {
        for (Human person : humans) {
            System.out.println("Name: " + person.getName());
            System.out.println("Second name: " + person.getSecondName());
            System.out.println("Surname: " + person.getSurname());
            System.out.println("Age: " + person.getAge());
            System.out.println("Gender: " + person.getGender());
            System.out.println("ID: " + person.getId());
            System.out.println("List of animals: " + person.getAnimalList());
            System.out.println("");
        }
    }

    public void getAllSmall() {
        for (Human person : humans) {
            System.out.println("ID: " + person.getId() + ". Name: " + person.getName());
            System.out.println("");
        }
    }
}
