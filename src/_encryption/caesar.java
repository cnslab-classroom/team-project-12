package _encryption;

public class caesar{
    private static int shift;
    public caesar(int shift) {
        this.shift = shift % 95;
    }

    public static String encrypt(String plainText) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plainText.toCharArray()) {
            if (c >= 32 && c <= 126) {
                char encryptedChar = (char) ((c - 32 + shift) % 95 + 32);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder();

        for (char c : encryptedText.toCharArray()) {
            if (c >= 32 && c <= 126) {
                char decryptedChar = (char) ((c - 32 - shift + 95) % 95 + 32);
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }
}
