/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorestaurantbyreva;
import static java.lang.Math.random;
import java.util.Scanner;
import java.util.Random;   

/**
 *
 * @author Asus
 */
class Customer {
     //Data Mockup        
    static MenuItem[] menuKarismaBahari = {
        new MenuItem(1, 1, "Makanan", "Nasi Padang", 25000),
        new MenuItem(2, 1, "Minuman", "Coca Cola", 6000),
        new MenuItem(3, 1, "Makanan", "Nasi Babi Guling", 15000),
        new MenuItem(4, 1, "Minuman", "Es Gula", 5000)
    };
    static MenuItem[] menuKfc = {
        new MenuItem(1, 2, "Makanan", "Happy Meal", 32000),
        new MenuItem(2, 2, "Minuman", "Chaki Drink", 12000),
        new MenuItem(3, 2, "Makanan", "Chicken Bucket", 90000),
        new MenuItem(4, 2, "Makanan", "Chicken Soup", 6000)
    };
    static MenuItem[] menuRobert = {
        new MenuItem(1, 3, "Makanan", "Ayam Geprek Promo", 10000),
        new MenuItem(2, 3, "Minuman", "Es Milo Anget", 6000),
        new MenuItem(3, 3, "Makanan", "Ayam Geprek Fullsize", 17000),
        new MenuItem(4, 3, "Minuman", "Aqua", 6000)
    };
    static Restaurant[] restaurants = {
        new Restaurant(1, "Karisma Bahari", "Pantai Muaya, Jimbaran", 3 , menuKarismaBahari),
        new Restaurant(2, "KFC Denpasari", "Sudirman, Denpasar", 30, menuKfc),
        new Restaurant(3, "Warung Robert Legend", "Kampus Unud, Jimbaran", 7 ,menuRobert)
    };
    static CustomerOrder[] orders = {
        new CustomerOrder(1, 1, 1,  5, 55000),
        new CustomerOrder(2, 2, 4,  12, 12000),
        new CustomerOrder(3, 3, 3,  3, 51000),
        new CustomerOrder(4, 1, 3,  7, 105000),
        new CustomerOrder(5, 2, 2,  10, 90000),
        new CustomerOrder(6, 3, 1,  2, 30000)
    };
    static String admin_username = "admin";
    static String admin_password = "admin";
    static String admin_location = "Jimbaran, Kuta Selatan, Badung, Bali";
    static String customer_username = "custo";
    static String customer_password = "custo";
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
                Customer.menu();
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
                add_order(restaurants);
                break;
            case 2:
                list_order(orders, restaurants);
                break;
            case 3:
                Menu.login();
            default:
                
                break;
        }
    }
    
    public static void add_order(Restaurant[] restaurants){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih restoran pada daftar dibawah ini:");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getId() + ". " + restaurant.getName() + " ("+  restaurant.getDistance() + "km)");
        }
        int restaurantId = scanner.nextInt();
        scanner.nextLine();

        // Find the chosen restaurant
        Restaurant chosenRestaurant = null;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                chosenRestaurant = restaurant;
                break;
            }
        }

        if (chosenRestaurant == null) {
            System.out.println("Restoran yang dipilih tidak ada, silahkan coba kembali.");
            Customer.menu();
        }

       
        System.out.println("Anda telah memilih " + chosenRestaurant.getName() + " ("+  chosenRestaurant.getDistance() + "km).");
        System.out.println("berikut adalah daftar menunya:");
        for (MenuItem item : chosenRestaurant.getMenu().getItems()) {
            System.out.println(" - " + item.getName() + " (" + item.getType() + "): Rp" + item.getPrice());
        }

        // Ask user to order a menu
        System.out.println("Pilih menu dari daftar di atas:");
        int menuItemId = scanner.nextInt();
        scanner.nextLine();

        // Find the chosen menu item
        MenuItem chosenMenuItem = null;
        for (MenuItem menuItem : chosenRestaurant.getMenu().getItems()) {
            if (menuItem.getId() == menuItemId) {
                chosenMenuItem = menuItem;
                break;
            }
        }
        if (chosenMenuItem == null) {
            System.out.println("Menu yang anda pilih tidak ada, silahkan coba kembali");
            Customer.menu();
        }

        // Ask user to specify the quantity
        System.out.println("Berapa banyak " + chosenMenuItem.getName() + " yang ingin anda pesan?");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        double totalPrice = chosenMenuItem.getPrice() * quantity;
        
        System.out.println("Pesanan anda telah ditambahkan ke dalam daftar pesanan!");
        System.out.println("Anda telah memesan " + quantity + " " + chosenMenuItem.getName() + ".");
        System.out.println("Total harga dari pesanan anda yaitu: Rp" + totalPrice);
        
         Customer.menu();
    }
    public static void list_order(CustomerOrder[] orders, Restaurant[] restaurants){
        System.out.print("==================================\n");
        System.out.print("Daftar Pesanan\n");
        int i = 1;
        for (CustomerOrder o : orders) {
            Restaurant chosenRestaurant = null;
            for (Restaurant restaurant : restaurants) {
                if (restaurant.getId() == o.getId()) {
                    chosenRestaurant = restaurant;
                    break;
                }
            }
            MenuItem chosenMenuItem = null;
            for (MenuItem menuItem : chosenRestaurant.getMenu().getItems()) {
                if (menuItem.getId() == o.getMenuId()) {
                    chosenMenuItem = menuItem;
                    break;
                }
            }
            System.out.println(i + ". "   + chosenRestaurant.getName() + " ("  +  chosenRestaurant.getDistance() +" km)" + "\nMenu : " +  chosenMenuItem.getName() + ", Jumlah : " +  o.getQuantity() + ", Total harga : Rp " +  o.getTotalPrice() +"\n");
            i++;
        }
        
        Customer.menu();
        
    }
}
