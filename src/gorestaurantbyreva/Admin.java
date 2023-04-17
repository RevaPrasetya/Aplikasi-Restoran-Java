package gorestaurantbyreva;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
class Admin {
    static String admin_username = "revaprasetya";
    static String admin_password = "reva1234";
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
                restaurants();
                break;
            case 2:
                add_restaurant();
            case 3:
                Menu.login();
            default:
                
                break;
        }
    }
    
    public static void restaurants(){
        
    }
    
    public static void add_restaurant(){
        
    }
}
