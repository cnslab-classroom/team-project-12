package _encryption;
import java.util.*;

public class monoalphabetic {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Map<Character, Character> cipherMap = new HashMap<>();
    private static Map<Character, Character> reverseCipherMap = new HashMap<>();

    private static void generateRandomCipher() {
        List<Character> originalAlphabet = new ArrayList<>();
        for (char c : ALPHABET.toCharArray()) {
            originalAlphabet.add(c);
        }

        List<Character> shuffledAlphabet = new ArrayList<>(originalAlphabet);
        Collections.shuffle(shuffledAlphabet);

        for (int i = 0; i < originalAlphabet.size(); i++) {
            char originalChar = originalAlphabet.get(i);
            char shuffledChar = shuffledAlphabet.get(i);
            cipherMap.put(originalChar, shuffledChar);
            reverseCipherMap.put(shuffledChar, originalChar);
        }
    }

    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                encrypted.append(cipherMap.get(c));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (reverseCipherMap.containsKey(c)) {
                decrypted.append(reverseCipherMap.get(c));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString().toLowerCase();
    }
}
