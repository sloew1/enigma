
import java.util.ArrayList;
import java.util.HashMap;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Enigma eni = Enigma.createEnigma(2);
        
        ArrayList<HashMap<Character, Character>> startMappings = new ArrayList<>();
        startMappings = eni.getStartMappings();      
        // System.out.println("startMapping: ");
        /*
        int i = 0;
        for (HashMap<Character, Character> startMapping : startMappings) {
            i++;
            System.out.println("Rotor "+i+": ");
            for (Map.Entry<Character, Character> entry : startMapping.entrySet()) {
                System.out.println(entry.getKey()+" -> "+entry.getValue());
            }
        }
        */

        String input = "HELLOWORLD";
        String output = "";
        
        // Jedes Zeichen durchlaufen und an die encrypt-Methode übergeben
        for (char character : input.toCharArray()) {
            System.out.println("");
            Character c = eni.encryptCharacter(character);
            output += c;
        }
        System.out.println("Encrypted: " + output);

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
            output2 += c;
        }

        System.out.println("Decrypted: " + output2);

    }
}