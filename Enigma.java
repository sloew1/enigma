import java.util.HashMap;

public class Enigma {
    private Rotor rotor3;
    private Rotor rotor2;
    private Rotor rotor1;
    int anzahlRotoren = 0;
    Plugboard p;
    Rotor r;
    HashMap<Character, Character> connections;

    public static Enigma e;


    private Enigma(int anzahlRotoren, char letter, char letter2){
        this.anzahlRotoren =anzahlRotoren;
        try {
            this.connections = new HashMap<>();
            this.p = new Plugboard(connections);
            p.setConnections(letter, letter2);
            if (anzahlRotoren == 1) this.rotor1 = new Rotor();
            if (anzahlRotoren == 2) {
                this.rotor1 = new Rotor();
                this.rotor2 = new Rotor();
            }
            if (anzahlRotoren == 3) {
                this.rotor1 = new Rotor();
                this.rotor2 = new Rotor();
                this.rotor3 = new Rotor();
            }
        }catch (Exception e){
            throw new IllegalArgumentException("Falscher EIngabewert angegeben");
        }
    }

    public static Enigma createEnigma(int anzahlRotoren, char letter1, char letter2){
        if(e == null) {
            e = new Enigma(anzahlRotoren, letter1, letter2);
        }
        return e;
    }
}
