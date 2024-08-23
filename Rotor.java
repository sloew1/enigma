import java.util.*;

// Rotoren und Reflektor der Enigma (historisch gab es 3-5 Rotoren und 1 Reflektor)
public class Rotor {
    
    public HashMap<Character,Character> scrambledAlphabet = new HashMap<>();
    private ArrayList<Character> alphabet = new ArrayList<>();
    private ArrayList<Character> alphab = new ArrayList<>();

    // Mapping, das am Anfang festgelegt wurde, bevor es durch Drehungen geändert wurde. Muss zur Entschlüsselung ausgetauscht werden:
    public HashMap<Character, Character> startMapping = new HashMap<>();     

    public boolean isReflektor;
    public boolean turnRotor;
   

    public Rotor(boolean turnRotor, boolean isReflektor){
        this.alphabet = Rotor.getAlphabet(alphabet);
        //System.out.println("Alphabet: " + alphabet);
        for(int i = 0; i < 26; i++)  alphab.add(alphabet.get(i));
        Collections.shuffle(this.alphab);
        //System.out.println("Shuffled Alphabet (alphab): " + alphab);
        this.scrambledAlphabet = mappingAlphabet(this.alphab);
        //System.out.println("Scrambled Alphabet Map: " + scrambledAlphabet);
        this.startMapping = this.scrambledAlphabet;
        this.turnRotor = turnRotor;
        this.isReflektor = isReflektor;
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

    public Character encryptCharacter(Character letter){
        if(!this.isReflektor) turnRotor();
        
        Character mappedLetter = this.scrambledAlphabet.get(letter);
        return mappedLetter;
    }

    public Character decryptCharacter(Character letter){
        if(!this.isReflektor) turnRotor();

        Character mappedLetter = ' ';
        for (Map.Entry<Character, Character> entry : this.scrambledAlphabet.entrySet()) {
            // If the value matches, return the corresponding key
            if (entry.getValue().equals(letter)) {
                mappedLetter = entry.getKey();
            }
        }

        return mappedLetter;
    }



/*
    public void turnRotor() {        
        // Speichere den Wert des ersten Keys
        Character firstKey = scrambledAlphabet.keySet().iterator().next();
        Character firstValue = scrambledAlphabet.get(firstKey);

        Character previousValue = firstValue;

        // Iteriere durch die Map und verschiebe die Werte
        Character currentKey = null;
        for (Map.Entry<Character, Character> entry : scrambledAlphabet.entrySet()) {
            if (currentKey != null) {
                Character currentValue = entry.getValue();
                scrambledAlphabet.put(currentKey, currentValue);
                previousValue = currentValue;
            }
            currentKey = entry.getKey();
        }

        // Setze den Wert des letzten Keys auf den ursprünglichen ersten Wert
        scrambledAlphabet.put(currentKey, firstValue);
    }


    //chatgptvol1
    public void turnRotor() {
        // Speichere den Wert des ersten Keys
        Character firstKey = scrambledAlphabet.keySet().iterator().next();
        Character firstValue = scrambledAlphabet.get(firstKey);

        Character previousValue = firstValue;

        // Iteriere durch die Map und verschiebe die Werte
        Character currentKey = null;
        for (Map.Entry<Character, Character> entry : scrambledAlphabet.entrySet()) {
            if (currentKey != null) {
                Character currentValue = entry.getValue();
                scrambledAlphabet.put(currentKey, currentValue);
                previousValue = currentValue;
            }
            currentKey = entry.getKey();
        }

        // Setze den Wert des letzten Keys auf den ursprünglichen ersten Wert
        scrambledAlphabet.put(currentKey, firstValue);
    }*/


    public void turnRotor() {
        // Speichere die Schlüssel in einer Liste, um die Reihenfolge beizubehalten
        List<Character> keys = new ArrayList<>(scrambledAlphabet.keySet());
        // Speichere die Werte in einer Liste in der gleichen Reihenfolge wie die Schlüssel
        List<Character> values = new ArrayList<>(scrambledAlphabet.values());

        // Verschiebe die Werte eine Position nach vorne
        Character lastValue = values.remove(values.size() - 1); // Entferne den letzten Wert
        values.add(0, lastValue); // Füge ihn an den Anfang der Liste

        // Aktualisiere die Map mit den neuen Werten
        for (int i = 0; i < keys.size(); i++) {
            scrambledAlphabet.put(keys.get(i), values.get(i));
        }
    }


    public void printMap() {
        for (Map.Entry<Character, Character> entry : scrambledAlphabet.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }  

    // Mapping manuell einstellen, z.B. beim Entschlüsseln die Drehungen wieder rückgängig machen
    public void setMapping(HashMap<Character, Character> mapping){
        this.scrambledAlphabet = mapping;
    }

    // Anfangszustand der Rotoren. Wird beim Entschlüsseln so eingestellt
    public HashMap<Character, Character> getStartMapping(){
        return this.startMapping;
    } 

    //deep copy
    public HashMap<Character, Object> getMappedAlphabet(){
        HashMap<Character, Object> scrambledAlphabetCopy = new HashMap<>();
       
        for(int i = 0; i < scrambledAlphabetCopy.size(); i++){
            Character x = (char) ('A' + i);
            scrambledAlphabetCopy.put(x, this.scrambledAlphabet.get(x));
        }
        return scrambledAlphabetCopy;
    }





}
