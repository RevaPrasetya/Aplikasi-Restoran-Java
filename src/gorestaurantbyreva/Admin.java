package gorestaurantbyreva;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
class Admin {
    //Data Mockup        
        static MenuItem[] menuKarismaBahari = {
            new MenuItem(1, 1, "Makanan", "Nasi Padang", 25000),
            new MenuItem(2, 1, "Minuman", "Coca Cola", 6000),
            new MenuItem(3, 1, "Makanan", "Nasi Babi Guling", 15000)
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
            new MenuItem(2, 3, "Minuman", "Aqua", 6000)
        };
        static Restaurant[] restaurants = {
            new Restaurant(1, "Karisma Bahari", "Pantai Muaya, Jimbaran", 3 , menuKarismaBahari),
            new Restaurant(2, "KFC Denpasari", "Sudirman, Denpasar", 30, menuKfc),
            new Restaurant(3, "Warung Robert Legend", "Kampus Unud, Jimbaran", 7 ,menuRobert)
        };
    static String admin_username = "admin";
    static String admin_password = "admin";
    static String admin_location = "Jimbaran, Kuta Selatan, Badung, Bali";
    
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n\n================================\n");
            System.out.print("Login sebagai Admin\n");
            System.out.print("================================\n");
            
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();

            System.out.print("\nMasukkan password: ");
            String password = scanner.nextLine();

            if (username.equals(admin_username) && password.equals(admin_password)) {
                menu();
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
            System.out.print("1. Daftar Restoran\n");
            System.out.print("2. Tambah Restoran\n");
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
                restaurant_list(restaurants);
                break;
            case 2:
                add_restaurant(restaurants);
            case 3:
                Menu.login();
            default:
                
                break;
        }
    }
    
  
    
    public static void restaurant_list(Restaurant[] restaurants){
            Scanner scanner = new Scanner(System.in);
            
            int i = 1;
            System.out.print("==================================\n");
            System.out.print("Daftar Restoran\n");
            for (Restaurant restaurant : restaurants) {
                System.out.println(i + ". " + restaurant.getName());
                i++;
            }
            
            System.out.print("Masukan nomor restoran untuk melihat detailnyat: \n");
            int restaurantIndex = scanner.nextInt() - 1;
            Restaurant restaurant = restaurants[restaurantIndex];
            System.out.println("Restaurant Name: " + restaurant.getName());
            System.out.println("Location: " + restaurant.getLocation());
            System.out.println("Menu Items:");
            MenuItem[] menuItems = restaurant.getMenu().getItems();
            for (MenuItem item : menuItems) {
                System.out.println(" - " + item.getName() + " (" + item.getType() + "): Rp" + item.getPrice());
            }
            
           /* for (Restaurant restaurant : restaurants) {
                System.out.println("Restaurant Name: " + restaurant.getName());
                System.out.println("Location: " + restaurant.getLocation());
                System.out.println("Menu Items:");
                MenuItem[] menuItems = restaurant.getMenu().getItems();
                for (MenuItem item : menuItems) {
                    System.out.println(" - " + item.getName() + " (" + item.getType() + "): Rp" + item.getPrice());
                }
                System.out.println(); // add a blank line between restaurants
            }*/
            
            Admin.menu();
    }
    
    public static void add_restaurant(Restaurant[] restaurants){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();   
        
       System.out.print("ID Restoran: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Lokasi: ");
        String location = scanner.nextLine();
        int distance = random.nextInt(50); 
        restaurants = addRestaurant(restaurants, new Restaurant(id, name, location, distance , new MenuItem[0]));

        System.out.println("\nDaftar Restoran Terbaru:");
        int i = 1;
        for (Restaurant restaurant : restaurants) {
            System.out.println(i + ". " + restaurant.getName() + " - " + restaurant.getLocation());
            i++;
        }
        
        Admin.menu();
    }

    public static Restaurant[] addRestaurant(Restaurant[] restaurants, Restaurant newRestaurant) {
        Restaurant[] newRestaurants = new Restaurant[restaurants.length + 1];
        System.arraycopy(restaurants, 0, newRestaurants, 0, restaurants.length);
        newRestaurants[restaurants.length] = newRestaurant;
        return newRestaurants;
    }
}
