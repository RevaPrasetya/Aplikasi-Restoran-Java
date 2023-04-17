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
public class CustomerOrder {
    private int id;
    private int restaurantId;
    private int menuId;
    private int quantity;
    private double totalPrice;

    public CustomerOrder(int id, int restaurantId, int menuId, int quantity, double totalPrice) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getMenuId() {
        return menuId;
    }


    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}

