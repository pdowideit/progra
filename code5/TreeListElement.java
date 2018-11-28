/**
 * Die Klasse TreeListElement stellt ein Element einer TreeList dar.
 * Dabei speichert das TreeListElement einen Baum als Wert des Objektes und das Folgeobjekt als TreeListElement.
 * Sowohl für den Wert als auch für das Folgeobjekt gibt es Getter und Setter Methoden.
 */
public class TreeListElement {
    private Tree value;

    private TreeListElement next;

    /**
     * TreeListElement hat einen Konstruktor, der die Parameter in die lokalen Variablen überträgt
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
     * Hilfsmethode für die toString Methode aus Tree
     *
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
    public int branchingDegree() {
        return value.branchingDegree();
    }

    public int size() {
        if (next == null) {
            return 1;
        } else {
            return 1 + next.size();
        }
    }

    //d)
    public boolean contains(int toSearch) {
        if (next == null) {
            return value.contains(toSearch);
        } else {
            return (value.contains(toSearch) || next.contains(toSearch));
        }
    }

    //e)
    public TreeListElement getLastItemHelper() {
        if (next == null) {
            return this;
        } else {
            return next.getLastItemHelper();
        }
    }
}
