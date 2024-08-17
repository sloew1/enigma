import java.util.ArrayList;
import java.util.HashMap;

public class Enigma {
    // private Rotor rotor3;
    // private Rotor rotor2;
    // private Rotor rotor1;
    // int anzahlRotoren = 0;
    Plugboard p;
    // Rotor r;
    HashMap<Character, Character> connections;
    private ArrayList<Rotor> rotorList = new ArrayList<>();
    private Rotor reflektor;    

    public static Enigma e;


    private Enigma(int anzahlRotoren, char letter, char letter2){
        // this.anzahlRotoren = anzahlRotoren;
        try {
            this.connections = new HashMap<>();
            this.p = new Plugboard(connections);
            p.setConnections(letter, letter2);
            
            // Rotoren erzeugen und zur Rotoren-Liste hinzufügen:
            for(int i=0; i<anzahlRotoren; i++){
                Rotor r = new Rotor(true);
                this.rotorList.add(r);
            }

            // Reflektor erzeugen:
            this.reflektor = new Rotor(false);

            /*
            if (anzahlRotoren == 1){
                this.rotor1 = new Rotor(true);
            } 
            if (anzahlRotoren == 2) {
                this.rotor1 = new Rotor(true);
                this.rotor2 = new Rotor(true);
            }
            if (anzahlRotoren == 3) {
                this.rotor1 = new Rotor(true);
                this.rotor2 = new Rotor(true);
                this.rotor3 = new Rotor(true);
            }
             */
            
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

    public Character encryptCharacter(Character letterIn){
        Character letterTemp = letterIn;

        // Buchstabe durch alle Rotoren schleusen
        for (Rotor r : this.rotorList) {
            letterTemp = r.encryptCharacter(letterTemp);
        }

        // Buchstabe durch Reflektor
        letterTemp = this.reflektor.encryptCharacter(letterTemp);

        // Buchstabe durch alle Rotoren schleusen in umgekehrter Richtung
        for (int i=this.rotorList.size()-1; i>=0; i--) {
            Rotor r = this.rotorList.get(i);
            letterTemp = r.encryptCharacter(letterTemp);        
        }

        return letterTemp;
    }

    public Character decryptCharacter(Character letterIn){
        Character letterTemp = letterIn;

        // Buchstabe durch alle Rotoren schleusen
        for (Rotor r : this.rotorList) {
            letterTemp = r.decryptCharacter(letterTemp);
        }

        // Buchstabe durch Reflektor
        letterTemp = this.reflektor.decryptCharacter(letterTemp);

        // Buchstabe durch alle Rotoren schleusen in umgekehrter Richtung
        for (int i=this.rotorList.size()-1; i>=0; i--) {
            Rotor r = this.rotorList.get(i);
            letterTemp = r.decryptCharacter(letterTemp);        
        }

        return letterTemp;
    }

    public ArrayList<HashMap<Character, Character>> getStartMappings(){
        ArrayList<HashMap<Character, Character>> startMappings = new ArrayList<>();
        for(Rotor r : this.rotorList){
            HashMap<Character, Character> startMapping = r.getStartMapping();
            startMappings.add(startMapping);
        }

        return startMappings;
    }

    public void setStartMappings(ArrayList<HashMap<Character, Character>> startMappings){
        int i = 0;
        for(Rotor r : this.rotorList){
            r.setMapping(startMappings.get(i));
            i++;
        }
    }
}
