import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Enigma startet...");
        System.out.println("Modus: ENCRYPTION");

        enum Mode {
            ENCRYPT,
            DECRYPT
        }
        Mode currentMode = Mode.ENCRYPT; // Initial mode is ENCRYPT

        Scanner scanner = new Scanner(System.in);
        String consoleOutput = ""; // Das komplette Wort, das in der Konsole angezeigt wird. Erweitert sich immer um einen Buchstaben bei EIngabe
        
        // Enigma erzeugen und startMappings der Rotoren speichern
        Enigma eni = Enigma.createEnigma(2);
        ArrayList<HashMap<Character, Character>> startMappings = new ArrayList<>();
        startMappings = eni.getStartMappings();              
       
        // Eingaben über die Konsole auswerten:
        while (true) {            
            String input = scanner.nextLine();

            // Umschalten zwischen Ver- und Entschlüsselung:
            if (input.equals(":d")) {
                currentMode = Mode.DECRYPT;
                consoleOutput = "";
                
                eni.setStartMappings(startMappings); // Rotoren auf Start-Einstellung zurücksetzen

                System.out.println("Wechsel zum DECRYPTION-Modus.");
                continue;
            } else if (input.equals(":e")) {
                currentMode = Mode.ENCRYPT;
                consoleOutput = "";
                System.out.println("Wechsel zum ENCRYPTION-Modus.");
                continue;
            }

            // Konsoleneingabe (String) in Character umwandeln:
            char character;
            if (input.length() == 1) {
                // Extrahiere das erste (und einzige) Zeichen als char
                character = input.charAt(0);    
                character = Character.toUpperCase(character);            
            } else {
                System.out.println("Eingabe darf nicht länger, als ein Zeichen sein");
                continue;
            }

            // Je nach Modus den Character ver- oder entschlüsseln:
            Character c = ' ';
            switch (currentMode) {
                case ENCRYPT -> {
                    c = encrypt(character, eni);                    
                    consoleOutput += c;
                    System.out.println("Ausgabe (verschlüsselt): "+consoleOutput);
                }
                case DECRYPT -> {
                    c = decrypt(character, eni);                    
                    consoleOutput += c;
                    System.out.println("Ausgabe (entschlüsselt): "+consoleOutput);
                }
            }

            
        }        
    }

    public static Character encrypt(char character, Enigma eni) {                
        Character c = eni.encryptCharacter(character);            
        return c;
    } 
    
    public static Character decrypt(char character, Enigma eni) {
        Character c = eni.decryptCharacter(character);
        return c;
    }
}