package com.example.diary;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println("===================");
    }
}