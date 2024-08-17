

import java.util.HashMap;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HashMap<Character, Character> exampleHashmap = new HashMap<>();

        Plugboard p = new Plugboard(exampleHashmap);
        p.setConnections('A', 'Z');

        Rotor r = new Rotor(true);

        //exampleHashmap = r.getScrambledAlphabet();

        System.out.println(r.getScrambledAlphabet());

        Enigma eni = Enigma.createEnigma(2,'A','B');
        HashMap<Character, Character> startMapping = eni.getStartMappings();

<<<<<<< Updated upstream
       Enigma.e.connections;



=======
        HashMap<Character,Character> example = Enigma.e.connections;
        System.out.println(example);

        String input = "HELLOWORLD";
        String output = "";
        
        // Jedes Zeichen durchlaufen und an die encrypt-Methode übergeben
        for (char character : input.toCharArray()) {
            Character c = eni.encryptCharacter(character);
            output += c;
        }

        System.out.println(output);

        // Entschlüsseln:
        input = output;
        output = "";

        for (char character : input.toCharArray()) {
            Character c = eni.decryptCharacter(character);
            output += c;
        }

        System.out.println(output);
>>>>>>> Stashed changes
    }
}