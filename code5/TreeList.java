/**
 * Die Klasse TreeList stellt eine Liste von TreeListElement dar.
 * Dabei speichert TreeList ausschließlich den Kopf der Liste, der als TreeListElement dargestellt wird.
 */
public class TreeList {
    private TreeListElement head;

    /**
     * Einziger Konstruktor von TreeList
     * Setzt Kopfelement auf null.
     */
    public TreeList() {
        this.head = null;
    }

    //a)

    /**
     * Getter Methode f&uuml; Kopfelement der Liste
     * @return Tree
     */
    public TreeListElement getHead() {
        return head;
    }

    /**
     * Setter Methode f&uuml;r Kopfelement
     * @param head neuer Kopf der Liste
     */
    public void setHead(TreeListElement head) {
        this.head = head;
    }

    //b)

    /**
     * Gibt einen leeren String zur&uuml;ck, wenn das Kopfelement leer ist.
     * Gibt ansonsten den R&uuml;ckgabewert der toString Methode f&uuml;r das Kopfelement zur&uuml;ck.
     * @return String
     */
    public String toString() {
        if (head == null) {
            return "";
        } else {
            return head.toString();
        }
    }

    //c)

    /**
     * Gibt die Anzahl der Kinder des Kopfelements zur&uuml;ck, wenn es kein Folgeobjekt gibt.
     * Gibt es ein Folgeobjekt ist der R&uuml;ckgabewert die gr&ouml;ßte Anzahl an Kindern in der TreeList und ihren Kindern
     * @return gr&ouml;ßte Anzahl an Kindern eines Objektes der TreeList und seinen Kindern als int
     */
    public int branchingDegree() {
        int headBranchDeg = head.branchingDegree();
        TreeListElement next = head.getNext();
        if (next == null) {
            return headBranchDeg;
        }

        int nextBranchDeg = head.getNext().branchingDegree();
        return headBranchDeg > nextBranchDeg ? headBranchDeg : nextBranchDeg;

    }

    /**
     * Gibt 0 zur&uuml;ck, wenn kein Kopfelement vorhanden ist.
     * Gibt 1 zur&uuml;ck, wenn ein Kopfelement, aber kein Folgeelement vorhanden ist.
     * Ruft ansonsten die size Methode von TreeListElement f&uuml;r das Kopfelement auf
     * @return Menge der Kinder dieser TreeList als int
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        if (head.getNext() == null) {
            return 1;
        } else {
            return head.size();
        }
    }

    //d)

    /**
     * Gibt false zur&uuml;ck, wenn das Kopfobjekt leer ist.
     * Ruft ansonsten die contains Methode von TreeListElement f&uuml;r das Kopfelement auf
     * @param toSearch in der Liste zu findender int Wert
     * @return boolean ob das toSearch Objekt in der Liste oder einer ihrer Kinder vorkommt
     */
    public boolean contains(int toSearch) {
        if (head == null) {
            return false;
        } else {
            return head.contains(toSearch);
        }
    }


    //e)

    /**
     * Gibt null zur&uuml;ck, wenn das Kopfelement leer ist
     * Gibt ansonsten das Kopfelement zur&uuml;ck, wenn kein Folgeelement vorhanden ist
     * Ruft ansonsten die getLastItemHelper Methode aus TreeListElement f&uuml;r das Folgeelement auf
     * @return das letzte TreeListElement der TreeList
     */
    public TreeListElement getLastItem() {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        } else {
            TreeListElement n = head.getNext();
            return n.getLastItemHelper();
        }
    }
}
