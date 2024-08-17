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

    public void setConnections(){
        Scanner eingabe = new Scanner(System.in);
        connections.putAll(getAlphabet()); //in der folgenden Zeile evtl mit while schleife arbeiten
        System.out.println("Geben Sie bitte hier die Buchstaben ein (10 Paare), die ersetzt werden sollen:\n Muster --> A-ersetzeDurchBuchtsabeX\nB(oder anderer Buchstabe)-ersetzeDurchBuchtsabeY usw.");
        String[] buchstaben = new String[]{eingabe.next()}; //ArrayList statt Array, in diser form: arraylänge = 1
        char[] buchstabenListe = String.join("", buchstaben).toCharArray();
        for(int i = 1; i < buchstabenListe.length; i++){
        connections.replace(buchstabenListe[i-1], buchstabenListe[i]);
        eingabe.close();
    }
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
