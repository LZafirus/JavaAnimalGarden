package com.company.database;

import com.company.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalDatabase {
    public List<Animal> animals;
    private HumanDatabase dBase;

    public AnimalDatabase(HumanDatabase hDatabase) {
        animals = new ArrayList<>();
        Turtle turtle = new Turtle(BasicModel.Gender.FEMALE, "Zolw", 100, 0, 0, null, Turtle.Feeding.ACTIVE, 101);
        Dog dog = new Dog(BasicModel.Gender.FEMALE, "Rex", 10, 0, 0, null, "szep", 102);
        Cat cat = new Cat(BasicModel.Gender.FEMALE, "Catt", 5, 0, 0, null, "russian", 103);

        animals.add(turtle);
        animals.add(dog);
        animals.add(cat);
        dBase = hDatabase;
    }

    public void addDog(Scanner scanner) throws IOException {
        int ignore, genderChoice;
        Dog dog = new Dog();

        scanner.nextLine();
        System.out.println("Dog's name: ");
        String name = scanner.nextLine();
        dog.setName(name);

        System.out.println("How old is it: ");
        int age = scanner.nextInt();
        dog.setAge(age);

        scanner.nextLine();
        System.out.println("What is dog's rase?: ");
        String dogRase = scanner.nextLine();
        dog.setRase(dogRase);

        System.out.println("Who is the owner? Select ID:");
        dBase.getAllSmall();
        int id = scanner.nextInt();
        Human owner = dBase.getHuman(id);
        dog.setOwner(owner);
        owner.addAnimal(dog);

        System.out.println("What is dog's gender ( m / f): ");
        genderChoice = (char) System.in.read();
        do {
            ignore = (char) System.in.read();
        } while (ignore != '\n');
        if (genderChoice == 'm' || genderChoice == 'M') {
            dog.setGender(BasicModel.Gender.MALE);
        }
        if (genderChoice == 'f' || genderChoice == 'F') {
            dog.setGender(BasicModel.Gender.FEMALE);
        }

        System.out.println("Default position [x][y] = [0][0].");
        dog.setX(0);
        dog.setY(0);

        System.out.println("Owner: " + dog.getOwner().getName());
        animals.add(dog);
    }

    public void addCat(Scanner scanner) throws IOException {
        int ignore, genderChoice;
        Cat cat = new Cat();

        scanner.nextLine();
        System.out.println("Cat's name: ");
        String name = scanner.nextLine();
        cat.setName(name);

        System.out.println("How old is it: ");
        int age = scanner.nextInt();
        cat.setAge(age);

        scanner.nextLine();
        System.out.println("What is cat's rase?: ");
        String catRase = scanner.nextLine();
        cat.setRase(catRase);

        System.out.println("Who is the owner? Select ID:");
        dBase.getAllSmall();
        int id = scanner.nextInt();
        Human owner = dBase.getHuman(id);
        cat.setOwner(owner);
        owner.addAnimal(cat);

        System.out.println("What is cat's gender ( m / f): ");
        genderChoice = (char) System.in.read();
        do {
            ignore = (char) System.in.read();
        } while (ignore != '\n');
        if (genderChoice == 'm' || genderChoice == 'M') {
            cat.setGender(BasicModel.Gender.MALE);
        }
        if (genderChoice == 'f' || genderChoice == 'F') {
            cat.setGender(BasicModel.Gender.FEMALE);
        }

        System.out.println("Default position [x][y] = [0][0].");
        cat.setX(0);
        cat.setY(0);

        System.out.println("Owner: " + cat.getOwner().getName());
        animals.add(cat);
    }

    public void addTurtle(Scanner scanner) throws IOException {
        int ignore, genderChoice;
        Turtle turtle = new Turtle();

        scanner.nextLine();
        System.out.println("Turtle's name: ");
        String name = scanner.nextLine();
        turtle.setName(name);

        System.out.println("How old is it: ");
        int age = scanner.nextInt();
        turtle.setAge(age);

        System.out.println("Who is the owner? Select ID:");
        dBase.getAllSmall();
        int id = scanner.nextInt();
        Human owner = dBase.getHuman(id);
        turtle.setOwner(owner);
        owner.addAnimal(turtle);

        System.out.println("What is turtle's gender ( m / f): ");
        genderChoice = (char) System.in.read();
        do {
            ignore = (char) System.in.read();
        } while (ignore != '\n');
        if (genderChoice == 'm' || genderChoice == 'M') {
            turtle.setGender(BasicModel.Gender.MALE);
        }
        if (genderChoice == 'f' || genderChoice == 'F') {
            turtle.setGender(BasicModel.Gender.FEMALE);
        }

        System.out.println("Default position [x][y] = [0][0].");
        turtle.setX(0);
        turtle.setY(0);

        System.out.println("Turtle is already fed.");
        turtle.setStatus(Turtle.Feeding.ACTIVE);

        System.out.println("Owner: " + turtle.getOwner().getName());
        animals.add(turtle);
    }

    public void turtleFeeding(Scanner scanner) {
        System.out.println("Choose which turtle (by ID) you want to feed?");
        showTurtles();
        int turtle = scanner.nextInt();
        for (Animal beast : animals) {
            if ((beast.getId() == turtle) && beast instanceof Turtle) {
                ((Turtle) beast).setStatus(Turtle.Feeding.ACTIVE);
                break;
            }
        }
    }

    public Animal getAnimal(int id) {
        for (Animal beast : animals) {
            if (beast.getId() == id) {
                return beast;
            }
        }
        return null;
    }

    public void removeAnimal(Scanner scanner) {
        System.out.println("Which dog would you like to remove (select ID):");
        showSmallAnimal();
        Animal temp = null;
        int id = scanner.nextInt();
        for (Animal beast : animals) {
            if (beast.getId() == id) {
                temp = beast;
                break;
            }
        }
        animals.remove(temp);
        System.out.println("Animal " + temp.getName() + " removed.");
    }

    public void showAllAnimals() {
        for (Animal beast : animals) {
            System.out.println("Name: " + beast.getName());
            System.out.println("Age: " + beast.getAge());
            System.out.println("Gender: " + beast.getGender());
            System.out.println("Position, X: " + beast.getX() + ", Y: " + beast.getY());
            System.out.println("Owner: " + beast.getOwner());
            System.out.println("");
        }
    }

    public void showSmallAnimal() {
        for (Animal beast : animals) {
            System.out.println("ID: " + beast.getId() + ". Name: " + beast.getName());
            System.out.println("");
        }
    }

    public void showTurtles() {
        for (Animal beast : animals) {
            if (beast instanceof Turtle) {
                System.out.println("ID: " + beast.getId() + " .Name: " + beast.getName());
            }
        }
    }
}
