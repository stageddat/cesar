import java.util.ArrayList;
import java.util.List;

public class CesarUtils {
    private static final ArrayList<Character> alphabet = new ArrayList<Character>(List.of(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    ));

    // encriptar el texto
    public static String encryptText(String text, int shift) {
        text = text.toLowerCase();
        StringBuilder decryptedText = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            // añadir espacio en blanco si fuera el caso
            if (text.charAt(i) == ' ') {
                decryptedText.append(" ");
            } else {
                // conseguir la letra encriptada
                Character encrytCharacter = encryptCharacter(text.charAt(i), shift);
                if (encrytCharacter == ' ') return "";
                decryptedText.append(encrytCharacter);
            }
        }
        return decryptedText.toString();
    }

    // calcular el caracter encriptado
    private static Character encryptCharacter(Character character, int shift) {
        // mirar su indice
        int characterIndex = alphabet.indexOf(character);

        // si no existe, devolver vacio
        if (characterIndex == -1) {
            return ' ';
        }

        // si la letra es mas grande q el abecedario
        int encryptedCharacterIndex = Math.floorMod(characterIndex + shift, alphabet.size());

        return alphabet.get(encryptedCharacterIndex);
    }

    // desencriptar el texto
    public static String decryptText(String text, int shift) {
        text = text.toLowerCase();
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            // añadir espacio en blanco si fuera el caso
            if (text.charAt(i) == ' ') {
                decryptedText.append(" ");
            } else {
                // conseguir la letra desencriptada
                Character decryptCharacter = decryptCharacter(text.charAt(i), shift);
                if (decryptCharacter == ' ') return "";
                decryptedText.append(decryptCharacter);
            }
        }
        return decryptedText.toString();
    }

    // calcular el caracter desencriptado
    private static Character decryptCharacter(Character character, int shift) {
        // mirar su indice
        int characterIndex = alphabet.indexOf(character);

        // si no existe, devolver vacio
        if (characterIndex == -1) {
            return ' ';
        }

        // calcular index char desencriptado, modulo de index - shift % alfabeto
        // usar floorMod pa evitar negativos
        int decryptedCharacterIndex = Math.floorMod(characterIndex - shift, alphabet.size());

        return alphabet.get(decryptedCharacterIndex);
    }

}
