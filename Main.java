
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Enigma eni = Enigma.createEnigma(2);
        
        ArrayList<HashMap<Character, Character>> startMappings = new ArrayList<>();
        startMappings = eni.getStartMappings();              

        try {
            int ch;
            
            while ((ch = System.in.read()) != -1) {
                char character = (char) ch;
                if (character != '\n' && character != '\r') {                    
                    processCharacter(Character.toUpperCase(character), eni);
                }

                // Beenden, wenn der Benutzer 'q' eingibt
                if (character == 'q') {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }

    public static void processCharacter(char character, Enigma eni) {
        // Hier die gewünschte Verarbeitung des Zeichens
        System.out.println("Verarbeitetes Zeichen: " + character);

        // String input = "HELLOWORLDS";
        String output = "";
                
        Character c = eni.encryptCharacter(character);
        output += c;
        
        System.out.println("Encrypted: " + output);

        /*
        // Rotoren auf Anfang zurückstellen:
        eni.setStartMappings(startMappings);

        // Entschlüsseln:
        System.out.println("");
        System.out.println("Entschlüsseln:");

        String input2 = output;
        String output2 = "";
        

        for (char character : input2.toCharArray()) {
            System.out.println("");
            Character c = eni.decryptCharacter(character);
            output2 += c;
        }

        System.out.println("Decrypted: " + output2);
        */
    }            
}