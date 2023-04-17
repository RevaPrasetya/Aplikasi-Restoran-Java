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
    public int id;
    public int restaurant_id;
    public int menu_id;
    public int kuantitas;
    public int jarak;
    public int total_harga;
 
    CustomerOrder(int id,int restaurant_id, int menu_id,int kuantitas,  int jarak, int total_harga)
    {
        this.id = id;
        this.restaurant_id = restaurant_id;
        this.menu_id = menu_id;
        this.kuantitas = kuantitas;
        this.jarak = jarak;
        this.total_harga = total_harga;
        
    }   
    
    public void detail()
    {
        System.out.println("Id Restoran : " + restaurant_id);
        System.out.println("\nId Menu : " + menu_id);
        System.out.println("\nKuantitas : " + kuantitas);
        System.out.println("\nJarak : " + jarak);
        System.out.println("\nTotal Harga : " + total_harga);
        System.out.println();
    }
}
