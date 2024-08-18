import java.util.*;

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
        ArrayList<Character> buchstaben = new ArrayList<>(); //ArrayList statt Array, in diser form: arraylänge = 1
        boolean b = true;
        while(b){
        System.out.println("Geben Sie bitte hier die Buchstabenpaare ein (zusammengeschrieben), die verknüpft werden sollen:\n Muster --> A-ersetzeDurchBuchtsabeX\nB(oder anderer Buchstabe)-ersetzeDurchBuchtsabeY usw.");
        String buchstabeString = eingabe.next();
        for(int i = 1; i < buchstabeString.length(); i++){
            buchstaben.add(buchstabeString.charAt(0));
            buchstaben.add(buchstabeString.charAt(i));
            if (buchstaben.size() >= 52) {
                b = false;
            }
            connections.replace(buchstaben.get(i-1), buchstaben.get(i));

        }b = false;
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
