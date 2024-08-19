import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class Plugboard {



    private Map<Character, Character> connections = new HashMap<>();

    public Plugboard(HashMap<Character, Character> connections){
        this.connections = connections;
    }


    public static char[] getAlphabet() {
        char[] alphabet = new char[26];
        for(int i = 0; i < 26; i++){
            for(char e : alphabet) alphabet[i] = (char) ('A' + i);
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
