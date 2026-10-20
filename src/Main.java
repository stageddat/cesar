import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Profesional Sigma Pro Plus Ultra Cesar Encryptor/Decryptor".toUpperCase());
        System.out.println("Choose an option: ");
        System.out.println("    (1) Encrypt");
        System.out.println("    (2) Decrypt");
        System.out.println("    (3) Brute Force Attack");

        int option;
        try {
            option = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("boom boom :(");
            return;
        }

        switch (option) {
            case 1: {
                System.out.println("Text to encrypt: ");
                String text = sc.nextLine();
                System.out.println("Shift: ");
                int shift = sc.nextInt();
                System.out.println("Encrypted text: " + CesarUtils.encryptText(text, shift));
                break;
            }
            case 2: {
                System.out.println("Text to decrypt: ");
                String text = sc.nextLine();
                System.out.println("Shift: ");
                int shift = sc.nextInt();
                System.out.println("Decrypted text: " + CesarUtils.decryptText(text, shift));
                break;
            }
            case 3: {
                System.out.println("Text: ");
                String text = sc.nextLine();
                // probar todos los shifts posibles
                for (int shift = 1; shift < 26; shift++) {
                    System.out.println("(" + shift + ") " + CesarUtils.decryptText(text, shift));
                }
                break;
            }
            default:
                System.out.println("no valid >:c");
        }
    }
}