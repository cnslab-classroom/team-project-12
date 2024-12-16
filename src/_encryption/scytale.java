package _encryption;
import java.util.Random;

public class scytale {

    public static char randomVal() {
        Random r = new Random();
        return (char) (r.nextInt(26) + 'a');
    }

    public static String encrypt(String key) {
    	int thickness=4;
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            encrypted.append(key.charAt(i));
            for (int j = 0; j < thickness; j++) {
                encrypted.append(randomVal());
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String pass) {
    	int thickness=4;
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < pass.length(); i += (thickness + 1)) {
            decrypted.append(pass.charAt(i));
        }
        return decrypted.toString();
    }
}