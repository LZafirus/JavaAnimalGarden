package com.company.database;

import com.company.Writable;
import com.company.model.Turtle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Functions {

    public void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void console() {
        System.out.println("<--------------------------------->");
        System.out.println("Welcome into Garden Console!");
        System.out.println("<--------------------------------->");
        System.out.println("Choose your option:");
        System.out.println("1. Enter database.");
        System.out.println("2. Enter a console. ");
        System.out.println("<--------------------------------->");
        System.out.println("If you would like to end, press q.");
        System.out.println("<--------------------------------->");
    }

    public void saveAnimal(List list) {
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter("Animal.txt");
            bw = new BufferedWriter(fw);

            bw.write(list.toString());

        } catch (IOException e) {
            System.out.println("Nastąpił błąd podczas otwierania pliku text.txt");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Inny nie znany błąd");
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Wystapil blad przy zamykaniu.");
                    e.printStackTrace();
                }
            }
        }

    }

    public void saveHuman(List list) {
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter("Users.txt");
            bw = new BufferedWriter(fw);

            bw.write(list.toString());

        } catch (IOException e) {
            System.out.println("Nastąpił błąd podczas otwierania pliku text.txt");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Inny nie znany błąd");
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Wystapil blad przy zamykaniu.");
                    e.printStackTrace();
                }
            }
        }
    }
}




