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
    public int id;
    public String nama;
    public String lokasi;
    public String [][] menu;
    
    //RestaurantMenu[] rmenu = new RestaurantMenu[3];
    
    //rmenu[0] = new RestaurantMenu(1, this.id, 1, "Burger", 12000);
    //rmenu[1] = new RestaurantMenu(1, this.id, 1, "Burger", 12000);
 
    Restaurant(int id, String nama, String lokasi, String[][] menu)
    {
        this.id = id;
        this.nama = nama;
        this.lokasi = lokasi;
        this.menu = menu;
        
    }
 
    public void detail()
    {
        System.out.println("Nama Restoran : " + nama);
        System.out.println("\nLokasi Restoran : " + lokasi);
        System.out.println("\nBerikut adalah menu di restoran ini :");
        for (int m = 1; m <= menu.length; m++)
        {
            System.out.println(m + ".");
            for (int i = 0; i < menu[m].length; i++)
            {
                if( i == 0){
                    System.out.println("Nama : " + nama);
                }
            }
        };
        System.out.println();
    }
}

class RestaurantMenu{
    public int id;
    public int restaurant_id;
    public int jenis;
    public String nama;
    public int harga;
 
    RestaurantMenu(int id,int restaurant_id, int jenis, String nama, int harga)
    {
        this.id = id;
        this.restaurant_id = restaurant_id;
        this.jenis = jenis;
        this.nama = nama;
        this.harga = harga;
        
    }   
}
