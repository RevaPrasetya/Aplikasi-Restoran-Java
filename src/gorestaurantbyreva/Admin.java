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
                System.out.println("\nLogin berhasil sebagai Admin!");
                break;
            } else {
                System.out.println("\nUsername atau password salah, mohon untuk dicoba kembali");
            }
        }
    }
}
