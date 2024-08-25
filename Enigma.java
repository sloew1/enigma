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
        int i = 0;
        boolean turn = false;
        for (Rotor r : this.rotorList) {                
            if(i == 0) turn = true;        
            letterTemp = r.encryptCharacter(letterTemp, turn);
            i++;
        }        

        // Buchstabe durch Reflektor
        letterTemp = this.reflektor.encryptCharacter(letterTemp, false);

        // Buchstabe durch alle Rotoren schleusen in umgekehrter Richtung
        for (int j=this.rotorList.size()-1; j>=0; j--) {            
            Rotor r = this.rotorList.get(j);
            letterTemp = r.encryptCharacter(letterTemp, false);        
        }

        return letterTemp;
    }

    public Character decryptCharacter(Character letterIn){
        Character letterTemp = letterIn;

        // Buchstabe durch alle Rotoren schleusen:
        boolean turn = false;
        int i = 0;
        for (Rotor r : this.rotorList) {
            if(i == 0) turn = true;
            letterTemp = r.decryptCharacter(letterTemp, turn);
        }

        if(this.rotorList.size() == 1) return letterTemp;

        // Buchstabe durch Reflektor
        letterTemp = this.reflektor.decryptCharacter(letterTemp, false);

        // Buchstabe durch alle Rotoren schleusen in umgekehrter Richtung
        for (int j=this.rotorList.size()-1; j>=0; j--) {            
            Rotor r = this.rotorList.get(j);
            letterTemp = r.decryptCharacter(letterTemp, false);        
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
        }
    }
}
