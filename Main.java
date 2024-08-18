

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
/*
        HashMap<Character, Character> exampleHashmap = new HashMap<>();

        Plugboard p = new Plugboard(exampleHashmap);
        p.setConnections('A', 'Z');

        Rotor r = new Rotor();

        //exampleHashmap = r.getScrambledAlphabet();

        System.out.println(r.getScrambledAlphabet());
*/
        Enigma eni = Enigma.createEnigma(2);

        //Enigma.e.p.setConnections();
        System.out.println(Enigma.e.connections);
    }
}