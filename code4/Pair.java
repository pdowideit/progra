/**
 * Die Klasse Pair stellt ein Paar aus jeweils Schl&uuml;ssel und Wert dar.
 * Dabei werden sowohl Schl&uuml;ssel als auch Wert in einem String gespeichert.
 * Sind die Werte f&uuml;r Schl&uuml;ssel und Wert einmal gesetzt können sie nicht mehr geändert werden.
 * Es gibt zwei verschiedene Konstruktoren f&uuml;r verschiedene Objekttypen des Wertes.
 */

public class Pair{
    /**
     * In diesen Variablen werden die Daten f&uuml;r Schl&uuml;ssel und Wert gespeichert.
     * Sie sind nachdem sie initial gesetzt werden nicht mehr zu ändern.
     */
    final String value,key;

    /**
     * Konstruktor f&uuml;r ein Objekt mit Schl&uuml;ssel und Wert.
     * Es werden zwei Strings &uuml;bergeben die in Variablen gespeichert werden.
     * @param k: Schl&uuml;ssel (String)
     * @param v: Wert (String)
     */
    public Pair(String k, String v){
        value=v;
        key = k;
    }

    /**
     * Konstruktor f&uuml;r ein Objekt  mit Schl&uuml;ssel und Wert.
     * Hier wird ein int als Wert &uuml;bergeben, der zu einem String umgewandelt wird, bevor er in einer Variable gespeichert wird.
     * @param k: Schl&uuml;ssel (String)
     * @param v: Wert (int)
     */
    public Pair(String k, int v){
        value=Integer.toString(v);
        key = k;
    }

    /**
     * Die Methode gibt den Wert des Objektes zur&uuml;ck.
     * @return Wert (String)
     */
    public String getValue(){
        return value;
    }
    /**
     * Die Methode gibt den Schl&uuml;ssel des Objektes zur&uuml;ck.
     * @return Schl&uuml;ssel (String)
     */
    public String getKey(){
        return key;
    }

    /**
     * Die Methode gibt Schl&uuml;ssel und Wert im Format 'Schl&uuml;ssel': 'Wert' zur&uuml;ck.
     * @return String
     */
    public String toString(){
        return "\'" + key+ "\': \'" +value+"\'";
    }

    /**
     * Eine statische Methode die ein Objekt des Typs Pair zur&uuml;ckgibt.
     * Schl&uuml;ssel und Wert werden als String im Format 'Schl&uuml;ssel': 'Wert' &uuml;bergeben.
     * @param input 'Schl&uuml;ssel': 'Wert' (String)
     * @return Pair
     */
    public static Pair fromString(String input){
        input = input.replace(" ","");
        input = input.replace("\'","");
        String[] splitInput = input.split(":");
        return new Pair(splitInput[0],splitInput[1]);
    }

}