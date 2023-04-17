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
class Costumer {
    static String customer_username = "revaprasetya";
    static String customer_password = "reva1234";
    static String customer_location = "Jimbaran, Kuta Selatan, Badung, Bali";
    
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n\n================================\n");
            System.out.print("Login sebagai Costumer\n");
            System.out.print("================================\n");
            
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();

            System.out.print("\nEnter your password: ");
            String password = scanner.nextLine();

            if (username.equals(customer_username) && password.equals(customer_password)) {
                System.out.println("\nLogin berhasil sebagai Customer!");
                break;
            } else {
                System.out.println("\nUsername atau password salah, mohon untuk dicoba kembali");
            }
        }
    }
    
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int userType = 0;
        while (userType != 1 && userType != 2 && userType != 3 ) {
            System.out.print("==================================\n");
            System.out.print("1. Buat Pesanan\n");
            System.out.print("2. Lihat Pesanan\n");
            System.out.print("3. Kembali ke Login\n");
            System.out.print("Masukkan angka yang sesuai untuk memilih. ( 1 / 2 )\n");
            userType = scanner.nextInt();
            if(userType != 1 && userType != 2 && userType != 3 ){
                System.out.print("Anda memasukan input yang salah\n\n");
                System.out.print(userType);
            }
        }
        
        switch(userType){
            case 1:
                add_order();
                break;
            case 2:
                list_order();
                break;
            case 3:
                Menu.login();
            default:
                
                break;
        }
    }
    
    public static void add_order(){
        
    }
    public static void list_order(){
        
    }
}
