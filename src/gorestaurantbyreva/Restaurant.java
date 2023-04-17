/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorestaurantbyreva;

/**
 *
 * @author Asus
 */
public class Restaurant {
    private int id;
    private String name;
    private String location;
    private RMenu menu;
    private int distance;

    public Restaurant(int id, String name, String location, int distance, MenuItem[] items) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.distance = distance;
        this.menu = new RMenu(items);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }
    public int getDistance() {
        return this.distance;
    }

    public RMenu getMenu() {
        return this.menu;
    }
    

}

class RMenu {
    private MenuItem[] items;

    public RMenu(MenuItem[] items) {
        this.items = items;
    }

    public MenuItem[] getItems() {
        return this.items;
    }

}

class MenuItem {
    private int id;
    private int restaurantId;
    private String type;
    private String name;
    private double price;

    public MenuItem(int id, int restaurantId, String type, String name, double price) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public int getRestaurantId() {
        return this.restaurantId;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

}
