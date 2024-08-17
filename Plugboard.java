import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Plugboard {



    private Map<Character, Character> connections = new HashMap<>();

    public Plugboard(HashMap<Character, Character> connections){
        this.connections = connections;
    }


    public static HashMap<Character, Character> getAlphabet() {
        HashMap<Character, Character> alphabet = new HashMap<>();
        for(int i = 0; i < 26; i++){
            char c = (char) ('A' + i);
                alphabet.put(c,c);

        }return alphabet;
    }

    public void setConnections(char letter, char letter2){
        connections.put(letter, letter2);
    }

    private void swap(char letter){
        char letter2= connections.get(letter);
        connections.put(letter2, letter);
    }





    public Character getLetter(char KeyLetter){
        char valueLetter = connections.get(KeyLetter);
        return valueLetter;
    }



}
