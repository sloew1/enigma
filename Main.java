import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Character> charMap = new HashMap<>();

        // Add mappings to the HashMap
        charMap.put('A', 'B');
        charMap.put('L', 'X');
        charMap.put('P', 'Q');

        Plugboard pb = new Plugboard(charMap);
        Character letter = pb.getLetter('A');

        // System.out.println(letter);

        Rotor rotor1 = new Rotor();
        System.out.println(rotor1.getCharacter('A'));
        System.out.println(rotor1.getCharacter('A'));
        System.out.println(rotor1.getCharacter('B'));
        System.out.println(rotor1.getCharacter('C'));



        // Iterate using entrySet()
        //for (Map.Entry<Character, Character> entry : map.entrySet()) {
        //    Character key = entry.getKey();
        //    Character value = entry.getValue();
        //    System.out.println("Key: " + key + ", Value: " + value);
        //}
    }

}
