package com.company;

import com.company.database.AnimalDatabase;
import com.company.database.Functions;
import com.company.database.HumanDatabase;
import com.company.model.Animal;
import com.company.model.Turtle;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static final int SIZE = 10;

    private HumanDatabase humanDatabase = new HumanDatabase();
    private AnimalDatabase animalDatabase = new AnimalDatabase(humanDatabase);
    Functions functions = new Functions();

    public Game() {
    }

    public void console() throws IOException, InterruptedException {
        int choice, ignore;

        for (; ; ) {
            do {
                functions.console();
                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (choice < '1' | choice > '2' & choice != 'q');
            if (choice == 'q' || choice == 'Q') {
                functions.saveAnimal(animalDatabase.animals);
                functions.saveHuman(humanDatabase.humans);
                break;
            }

            System.out.println("\n");
            Scanner scanner = new Scanner(System.in);

            switch (choice) {
                case '1': {
                    System.out.println("Choose which data base would you like to use: ");
                    System.out.println("1. Human data base.");
                    System.out.println("2. Animal data base.");
                    System.out.println("3. Exit.");
                    int choosen = scanner.nextInt();

                    if (choosen == 1) {
                        System.out.println("1. Add human.");
                        System.out.println("2. Remove human.");
                        System.out.println("3. Show all humans.");
                        System.out.println("4. Exit");
                        int choosen2 = scanner.nextInt();
                        if (choosen2 == 1) {
                            humanDatabase.addHuman(scanner);
                            System.out.println("Human added.");
                            functions.sleep(1500);
                        } else if (choosen2 == 2) {
                            humanDatabase.removeHuman(scanner);
                            functions.sleep(1500);
                        } else if (choosen2 == 3) {
                            humanDatabase.getAllBig();
                            functions.sleep(1500);
                        } else {
                            break;
                        }
                    } else if (choosen == 2) {
                        System.out.println("1. Add dog.");
                        System.out.println("2. Add cat.");
                        System.out.println("3. Add turtle.");
                        System.out.println("4. Remove an animal.");
                        System.out.println("5. Show all animals.");
                        System.out.println("6. Exit.");
                        int choosen2 = scanner.nextInt();
                        if (choosen2 == 1) {
                            animalDatabase.addDog(scanner);
                            System.out.println("Dog added.");
                            functions.sleep(1500);
                        } else if (choosen2 == 2) {
                            animalDatabase.addCat(scanner);
                            System.out.println("Cat added.");
                            functions.sleep(1500);
                        } else if (choosen2 == 3) {
                            animalDatabase.addTurtle(scanner);
                            System.out.println("Turtle added.");
                            functions.sleep(1500);
                        } else if (choosen2 == 4) {
                            animalDatabase.removeAnimal(scanner);
                            functions.sleep(1500);
                        } else if (choosen2 == 5) {
                            animalDatabase.showAllAnimals();
                            functions.sleep(1500);
                        }

                    } else {
                        break;
                    }
                }
                break;

                case '2':
                    System.out.println("1. Feed turtles");
                    System.out.println("2. Enter a game");
                    System.out.println("3. Exit");
                    int choose = scanner.nextInt();
                    if (choose == 1) {
                        animalDatabase.turtleFeeding(scanner);
                        System.out.println("Turtle is fed now!");
                    } else if (choose == 2) {
                        System.out.println("First, choose animal by ID: ");
                        animalDatabase.showSmallAnimal();
                        int id = scanner.nextInt();
                        Animal target = animalDatabase.getAnimal(id);

                        for (; ; ) {
                            int x = target.getX();
                            int y = target.getY();
                            System.err.println("Current position: X: " + x + ", Y: " + y);
                            System.out.println("Where do you go?");
                            System.out.println("1.Up,\n2.Down,\n3.Right,\n4.Left");
                            System.out.println("\n5. Exit.");
                            int way = scanner.nextInt();

                            if ((way == 1) && y > 0) {
                                if ((target instanceof Turtle) && (((Turtle) target).getStatus() == Turtle.Feeding.HIDDEN)) {
                                    System.err.println("Turtle needs to be fed.");
                                } else if (target instanceof Turtle) {
                                    ((Turtle) target).setStatus(Turtle.Feeding.HIDDEN);
                                    target.setY(y - 1);
                                    System.out.println("Feed a turtle!");
                                } else {
                                    target.setY(y - 1);
                                }
                            }

                            if ((way == 2) && y < SIZE) {
                                if ((target instanceof Turtle) && (((Turtle) target).getStatus() == Turtle.Feeding.HIDDEN)) {
                                    System.err.println("Turtle needs to be fed.");
                                } else if (target instanceof Turtle) {
                                    ((Turtle) target).setStatus(Turtle.Feeding.HIDDEN);
                                    target.setY(y + 1);
                                } else {
                                    target.setY(y + 1);
                                }
                            }
                            if ((way == 3) && x < SIZE) {
                                if ((target instanceof Turtle) && (((Turtle) target).getStatus() == Turtle.Feeding.HIDDEN)) {
                                    System.err.println("Turtle needs to be fed.");
                                } else if (target instanceof Turtle) {
                                    ((Turtle) target).setStatus(Turtle.Feeding.HIDDEN);
                                    target.setX(x + 1);
                                } else {
                                    target.setX(x + 1);
                                }

                            }
                            if ((way == 4) && x > 0) {
                                if ((target instanceof Turtle) && (((Turtle) target).getStatus() == Turtle.Feeding.HIDDEN)) {
                                    System.err.println("Turtle needs to be fed.");
                                } else if (target instanceof Turtle) {
                                    ((Turtle) target).setStatus(Turtle.Feeding.HIDDEN);
                                    target.setX(x - 1);
                                } else {
                                    target.setX(x - 1);
                                }

                            }

                            System.err.println("Position after: X: " + target.getX() + ", Y: " + target.getY());
                            if (way == 5) {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                    functions.sleep(1500);
                    break;
            }
        }
    }
}