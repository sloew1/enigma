import java.util.ArrayList;
import java.util.HashMap;

public class Enigma {
    // private Rotor rotor3;
    // private Rotor rotor2;
    // private Rotor rotor1;
    // int anzahlRotoren = 0;
    Plugboard p;
    //Rotor r;
    HashMap<Character, Character> connections;
    public ArrayList<Rotor> rotorList = new ArrayList<>();
    public Rotor reflektor;    

    public static Enigma e;


    private Enigma(int anzahlRotoren){
        // this.anzahlRotoren = anzahlRotoren;
        try {
            this.connections = new HashMap<>();
            
            // this.p = new Plugboard(connections);
            // p.setConnections(letter, letter2);
            
            // Rotoren erzeugen und zur Rotoren-Liste hinzufügen:
            for(int i=0; i<anzahlRotoren; i++){
                Rotor r = new Rotor(false, false);
                this.rotorList.add(r);
            }

            // Reflektor erzeugen:
            if(anzahlRotoren > 1){
                this.reflektor = new Rotor(false, true);                
            }
            else{
                this.reflektor = null;
            }            
        }
        catch (Exception e){
            throw new IllegalArgumentException("Falscher EIngabewert angegeben");
        }
    }

    public static Enigma createEnigma(int anzahlRotoren){
        if(e == null) {
            e = new Enigma(anzahlRotoren);
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

        if(this.rotorList.size() == 1) return letterTemp;

        // Buchstabe durch Reflektor
        letterTemp = this.reflektor.decryptCharacter(letterTemp);

        // Buchstabe durch alle Rotoren schleusen in umgekehrter Richtung
        for (int i=this.rotorList.size()-1; i>=0; i--) {
            Rotor r = this.rotorList.get(i);
            letterTemp = r.decryptCharacter(letterTemp);        
        }

        return letterTemp;
    }

    public ArrayList<HashMap<Character, Character>> getStartMappings() {
        ArrayList<HashMap<Character, Character>> startMappings = new ArrayList<>();
        for (Rotor r : this.rotorList) {
            // Create a deep copy of each startMapping
            HashMap<Character, Character> startMappingCopy = new HashMap<>(r.getStartMapping());
            startMappings.add(startMappingCopy);
        } 

        return startMappings;
    }
    

    public void setStartMappings(ArrayList<HashMap<Character, Character>> startMappings){
        for(int i=0; i<startMappings.size(); i++){            
            Rotor r = this.rotorList.get(i);
            r.setMapping(startMappings.get(i));
            i++;
        }
    }
}
