import java.util.*;


public class Rotor {

    private HashMap<Character,Character> scrambledAlphabet = new HashMap<>();
    private ArrayList<Character> alphabet = new ArrayList<>();
    private ArrayList<Character> alphab = new ArrayList<>();


    public Rotor(){
        this.alphabet = Rotor.getAlphabet(alphabet);
        //System.out.println("Alphabet: " + alphabet);
        for(int i = 0; i < 26; i++)  alphab.add(alphabet.get(i));
        Collections.shuffle(this.alphab);
        //System.out.println("Shuffled Alphabet (alphab): " + alphab);
        this.scrambledAlphabet = mappingAlphabet(this.alphab);
        //System.out.println("Scrambled Alphabet Map: " + scrambledAlphabet);

    }

    public HashMap<Character, Character> getScrambledAlphabet() {
        return this.scrambledAlphabet;
    }


    private HashMap mappingAlphabet(ArrayList<Character> alphabet){
        char x = 'A';
        for(int i = 0; i <alphab.size(); i++) this.scrambledAlphabet.put((Character) (x++), alphab.get(i));
        return this.scrambledAlphabet;
    }


    private static ArrayList<Character> getAlphabet( ArrayList<Character> alphabet) {
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet.add(c);
        }
        return alphabet;
    }


    //deep copy
    public HashMap<Character, Object> getMappedAlphabet(){
        HashMap<Character, Object> scrambledAlphabetCopy = new HashMap<>();
        for(int u = 0; u < 26; u++){
            Character x = (char) ('A' + u);
            scrambledAlphabetCopy.put(x, this.getScrambledAlphabet().get(x));
        }
        for(int i = 0; i < scrambledAlphabetCopy.size(); i++){
            Character x = (char) ('A' + i);
            scrambledAlphabetCopy.put(x, this.scrambledAlphabet.get(x));
        }return scrambledAlphabetCopy;
    }





}
