import java.util.ArrayList;
import java.util.List;

public class DecryptionOfTheCaesar {

    private final char[] al = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    private String decryptionText = "";
    private List<String> listDecryptionText = new ArrayList<String>();

    public void decrypt(String text){

        for (int i = 1; i <= 33; i++) {
            for (char c: text.toCharArray()) {
                if (Character.isLetter(c)){
                    char lower = Character.toLowerCase(c);
                    for (int j = 0; j < al.length; j++) {
                        if (lower == al[j]){
                            int sum = j + i;
                            decryptionText += checkLetter(sum,c);
                            break;
                        }
                    }
                }else {
                    decryptionText += (char)(c);
                }
            }
            listDecryptionText.add(decryptionText);
            decryptionText = "";
        }
        for (String ss: listDecryptionText) {
            System.out.println(ss);
            System.out.println();
        }
    }

    private char checkLetter(int sum, char c){
        char letter;
        if (sum > 32){
            if (Character.isUpperCase(c)){
                letter = Character.toUpperCase(al[(sum) - 33]);
            }else {
                letter = al[(sum) - 33];
            }
        }else {
            if (Character.isUpperCase(c)){
                letter = Character.toUpperCase(al[sum]);
            }else {
                letter = al[sum];
            }
        }
        return letter;
    }
}
