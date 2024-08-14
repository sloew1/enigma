import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Rotor {
    private ArrayList<Character> alphabet;
    private ArrayList<Character> alphabetRandom;
    public HashMap<Character, Character> mapping;

    public Rotor(){
        this.alphabet = getAlphabet();
        this.alphabetRandom = getAlphabet();
        Collections.shuffle(this.alphabetRandom);
        this.mapping = new HashMap<>();

        for(int i = 0; i<26; i++){
            this.mapping.put(this.alphabet.get(i), this.alphabetRandom.get(i));
        }
    }

    public Character getCharacter(Character keyLetter){
        return this.mapping.get(keyLetter);
    }

    public ArrayList<Character> getAlphabet() {
        ArrayList<Character> alphabet2 = new ArrayList<Character>();
        for(int i = 0; i < 26; i++){
            alphabet2.add((char) ('A' + i));
        }
        return alphabet2;
    }
}
