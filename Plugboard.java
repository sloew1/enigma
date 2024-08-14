import java.util.HashMap;

public class Plugboard {

    public HashMap<Character, Character> connections = new HashMap<>();

    public Plugboard(HashMap<Character, Character> chars){
        this.connections = chars;
    }

    public char[] getAlphabet() {
        char[] alphabet = new char[26];
        for(int i = 0; i < 26; i++){
            for(char e : alphabet) alphabet[i] = (char) ('A' + i);
        }return alphabet;
    }

    private void setConnections(char letter, char letter2){
        connections.put(letter, letter2);
    }

    public Character getLetter(Character keyLetter){
        Character returnLetter = connections.get(keyLetter);
        return returnLetter;
    }

    private void swap(Character letter){
        char subst = connections.get(letter);
        connections.put(subst, letter);
    }




}