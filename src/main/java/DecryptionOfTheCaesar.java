import java.util.ArrayList;
import java.util.List;

public class DecryptionOfTheCaesar {

    private final char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    private String decryptionText = "";
    private final List<String> listDecryptionText = new ArrayList<String>();

    public void decrypt(String text) {

        for (int count = 1; count <= 33; count++) {
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    for (int i = 0; i < alphabet.length; i++) {
                        if (Character.toLowerCase(c) == alphabet[i]) {
                            int sum = i + count;
                            decryptionText += checkLetter(sum, c);
                            break;
                        }
                    }
                } else {
                    decryptionText += (char) (c);
                }
            }
            listDecryptionText.add(decryptionText);
            decryptionText = "";
        }
        for (String ss : listDecryptionText) {
            System.out.println(ss + "\n");
        }
    }

    private char checkLetter(int sum, char c) {
        char letter;
        if (sum > 32) {
            if (Character.isUpperCase(c)) {
                letter = Character.toUpperCase(alphabet[(sum) - 33]);
            } else {
                letter = alphabet[(sum) - 33];
            }
        } else {
            if (Character.isUpperCase(c)) {
                letter = Character.toUpperCase(alphabet[sum]);
            } else {
                letter = alphabet[sum];
            }
        }
        return letter;
    }
}
