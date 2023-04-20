/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorestaurantbyreva;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Menu {
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        int userType = 0;
        String username = "";
        String password = "";
        
        while (userType != 1 && userType != 2 ) {
            System.out.print("==================================\n");
            System.out.print("Anda ingin masuk sebagai?\n");
            System.out.print("1. Admin\n");
            System.out.print("2. Customer\n");
            System.out.print("Masukkan angka yang sesuai untuk memilih. ( 1 / 2 )\n");
            userType = scanner.nextInt();
            if(userType != 1 && userType != 2 ){
                System.out.print("Anda memasukan input yang salah\n");
                System.out.print(userType);
            }
        }
        
        switch(userType){
            case 1:
                Admin.login();
                break;
            case 2:
                Customer.login();
            default:
                
                break;
        }
    }
}
