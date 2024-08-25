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


    //Zeile 32 löst Exception aus: No such element
    public void setConnections(){
        Scanner eingabe = new Scanner(System.in);
        connections.putAll(getAlphabet()); //in der folgenden Zeile evtl mit while schleife arbeiten
        ArrayList<Character> buchstaben = new ArrayList<>();
        //boolean b = true;
        //while(b){
        System.out.println("Geben Sie bitte hier die Buchstabenpaare ein (zusammengeschrieben), die verknüpft werden sollen:\n Muster --> A-ersetzeDurchBuchtsabeX\nB(oder anderer Buchstabe)-ersetzeDurchBuchtsabeY usw.");
        String buchstabeString = eingabe.next().toUpperCase();
        buchstaben.add(buchstabeString.charAt(0));
        for(int i = 1; i < buchstabeString.length(); i++){
            buchstaben.add(buchstabeString.charAt(i));
            connections.replace(buchstaben.get(i-1), buchstaben.get(i));
           // if (buchstaben.size() >= 52) {
           //    break;
           // }


        //}b = false;
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
