package com.example.diary;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private String text;

    public MenuItem(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

public class Menu {
    private String title;
    private List<MenuItem> items;

    public Menu(String title) {
        this.title = title;
        this.items = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public void display() {
        System.out.println("=== " + title + " ===");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getText());
        }
        System.out.println("===================");
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Выберите пункт меню: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Неверный ввод. Пожалуйста, введите номер пункта меню: ");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > items.size());
        return choice;
    }

    public static void main(String[] args) {
        Menu mainMenu = new Menu("Главное меню");
        mainMenu.addItem(new MenuItem("Выход"));
        mainMenu.addItem(new MenuItem("New Note"));
        mainMenu.addItem(new MenuItem("Edit Note"));
        mainMenu.addItem(new MenuItem("Delete Note"));

        mainMenu.display();
        int userChoice = mainMenu.getUserChoice();

        if (userChoice >= 1 && userChoice <= mainMenu.getItems().size()) {
            System.out.println("Вы выбрали: " + mainMenu.getItems().get(userChoice - 1).getText());
        }
        if (userChoice == 1) {
            System.out.println("Выход из приложения");
        } else if (userChoice == 2) {

        } else if (userChoice == 3) {

        } else if (userChoice == 4) {

        }
        //сделать логику для каждого if
    }
}