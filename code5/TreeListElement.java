/**
 * Die Klasse TreeListElement stellt ein Element einer TreeList dar.
 * Dabei speichert das TreeListElement einen Baum als Wert des Objektes und das Folgeobjekt als TreeListElement.
 * Sowohl f&uuml;r den Wert als auch f&uuml;r das Folgeobjekt gibt es Getter und Setter Methoden.
 */
public class TreeListElement {
    private Tree value;

    private TreeListElement next;

    /**
     * TreeListElement hat einen Konstruktor, der die Parameter in die lokalen Variablen &uuml;bertr&auml;gt
     *
     * @param inputValue Ein Baum der den Wert des aktuellen Objektes darstellt
     * @param inputNext  Das folgende TreeListElement
     */
    public TreeListElement(Tree inputValue, TreeListElement inputNext) {
        this.value = inputValue;
        this.next = inputNext;
    }

    //a)

    /**
     * Getter Methode f&uuml; Wert
     * @return Tree
     */
    public Tree getValue() {
        return value;
    }

    /**
     * Setter Methode f&uuml; Wert
     * @param v Tree neuer Wert
     */
    public void setValue(Tree v) {
        value = v;
    }


    /**
     * Getter Methode f&uuml; Folgeobjekt
     * @return TreeListElement
     */
    public TreeListElement getNext() {
        return next;
    }

    /**
     * Setter Methode f&uuml; Folgeobjekt
     * @param n TreeListElement neues Folgeobjekt
     */
    public void setNext(TreeListElement n) {
        next = n;
    }

    //b)

    /**
     * Hilfsmethode f&uuml;r die toString Methode aus Tree
     * Ruft die toString Methode von Tree f&uuml;r den aktuellen Wert auf, f&uuml;gt ein Komma an und ruft die Methode dann f&uuml;r das Folgeelement auf, sofern vorhanden.
     * @return String
     */
    public String toString() {
        if (next == null) {
            return value.toString();
        } else {
            if (value == null) {
                return next.toString();
            } else {
                return value.toString() + "," + next.toString();
            }
        }

    }

    //c)

    /**
     * Hilfsmethode f&uuml;r die branchingDegree Methode aus Tree
     * Ruft die branchingDegree Methode von Tree f&uuml;r den aktuellen Wert auf.
     * @return int
     */
    public int branchingDegree() {
        return value.branchingDegree();
    }

    /**
     * Hilfsmethode f&uuml;r die size Methode aus TreeList
     * Berechnet die Menge der Folgeelemente plus 1 rekursiv.
     * @return int
     */
    public int size() {
        if (next == null) {
            return 1;
        } else {
            return 1 + next.size();
        }
    }

    //d)

    /**
     * Hilfsmethode f&uuml;r die contains Methode aus Tree
     * Ruft die contains Methode aus Tree f&uuml;r den aktuellen Wert auf und, sofern vorhanden, die lokale contains Methode f&uuml;r das Folgeelement
     * @param toSearch zu suchendes Label eines Tree
     * @return boolean der angibt, ob das zu suchende Objekt im aktuellen Baum oder einem der Folgeobjekte vorkommt
     */
    public boolean contains(int toSearch) {
        if (next == null) {
            return value.contains(toSearch);
        } else {
            return (value.contains(toSearch) || next.contains(toSearch));
        }
    }

    //e)

    /**
     * Hilfsmethode f&uuml;r die getLastItem Methode aus TreeList
     * Gibt, wenn kein Folgeobjekt vorhanden ist das aktuelle Objekt zur&uuml;ck und ruft die Methode ansonsten auf das Folgeobjekt auf
     * @return das letzte TreeListElement
     */
    public TreeListElement getLastItemHelper() {
        if (next == null) {
            return this;
        } else {
            return next.getLastItemHelper();
        }
    }
}
