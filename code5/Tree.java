/**
 * Die Klasse Tree stellt einen rekursiven Baum mit beliebiger Anzahl an Kinder f&uuml;r jeden Knoten.
 * Dabei besteht ein Baum immer aus einem ganzzahligen Wert und einer Liste an Kindern.
 * Tree hat zwei Variablen, f&uuml;r die es jeweils Getter und Setter Methoden gibt.
 */
public class Tree {
    private int label;

    private TreeList children;

    /**
     * Einziger Konstruktor von Tree, der beide Parameter in lokalen Variablen speichert
     * @param inputLabel int der den Wert des aktuellen Baum darstellt
     * @param inputChildren TreeList, die die Kinder des aktuellen Baum darstellt
     */
    public Tree(int inputLabel, TreeList inputChildren) {
        this.label = inputLabel;
        this.children = inputChildren;
    }

    /**
     * Erstellt einen neuen Baum mit dem &uuml;bergebenen Wert und einer TreeList aus den &uuml;bergebenen Kindern
     * Dazu wird die Hilfsmethode addChildren benutzt
     * @param value Wert des Baumes
     * @param children Kinder des Baumes
     * @return Tree mit Wert value und den &uuml;bergebenen Kindern children
     */
    public static Tree buildTree(int value, Tree... children) {
        if (children.length == 0) {
            return new Tree(value, null);
        } else {
            Tree[] trees = children;
            Tree t = new Tree(value, null);
            t.addChildren(trees, 0);
            return t;
        }
    }

    /**
     * Method for trying out some of the implemented commands.
     *
     * @param args input strings from the console
     */

    public static void main(String[] args) {
        Tree[] trees = {buildTree(1, buildTree(2), buildTree(3), buildTree(4)), buildTree(-1), buildTree(4, buildTree(1, buildTree(1, buildTree(1, buildTree(1), buildTree(1), buildTree(1)), buildTree(1), buildTree(1))), buildTree(2), buildTree(2, buildTree(2))),
                buildTree(72, buildTree(27), buildTree(11), buildTree(54, buildTree(89, buildTree(10), buildTree(20), buildTree(42))), buildTree(23)),
                buildTree(54, buildTree(89, buildTree(10), buildTree(20), buildTree(42)))
        };

        for (Tree tree : trees) {
            if (tree != null) {
                String test = "";
                test = test + tree.toString() + "\n";
                test = test + "Branching Degree: " + tree.branchingDegree() + "\n";
                test = test + "2 contained: " + tree.contains(2) + "\n";
                test = test + "42 contained: " + tree.contains(42) + "\n";
                test = test + "1 contained: " + tree.contains(1) + "\n";
                SimpleIO.output(test);
            }
        }
    }

    //a)

    /**
     * Getter Methode f&uuml; Wert des Baumes
     * @return int Wert des Baumes
     */
    public int getLabel() {
        return label;
    }

    /**
     * Setter Methode f&uuml; Wert des Baumes
     * @param neuer Wert des Baumes als int
     */
    public void setLabel(int label) {
        this.label = label;
    }

    /**
     * Getter Methode f&uuml;r Kinder des Baumes
     * @return Kinder des Baumes als TreeList
     */
    public TreeList getChildren() {
        return children;
    }

    /**
     * Setter Methode f&uuml;r Kinder des Baumes
     * @param neue Kinder des Baumes als TreeList
     */
    public void setChildren(TreeList children) {
        this.children = children;
    }

    //b)

    /**
     * Methode die den aktuellen Baum zu einem String parst und zur&uuml;ck gibt
     * @return kompletter Baum mit allen Kindern und Kindern der Kinder als String
     */
    public String toString() {
        String res = label + "->[";
        if (children != null) {
            res += children.toString();
        }
        res += "]";
        return res;
    }

    //c)

    /**
     * Methode die die maximale Anzahl an Kindern aller Unterobjekte des Baumes rekursiv berechnet
     * @return maximale Anzahl an Kindern aller Unterobjekt des Baumes
     */
    public int branchingDegree() {
        if (children == null)
            return 0;
        int childrenBranchDeg = children.branchingDegree();
        int childrenSize = children.size();
        return childrenSize > childrenBranchDeg ? childrenSize : childrenBranchDeg;
    }


    //d)

    /**
     * Methode die den kompletten Baum nach dem als Parameter &uuml;bergebenen Wert durchsucht
     * @param toSearch zu suchender Wert
     * @return boolean true, wenn Wert Teil des Baumes, false wenn nicht
     */
    public boolean contains(int toSearch) {
        if (label == toSearch) {
            return true;
        }
        if (children != null) {
            return children.contains(toSearch);
        }
        return false;

    }

    //e)

    /**
     * Methode die der TreeList des Baums die &uuml;bergebenen B&auml;ume als TreeListElements rekursiv anh&auml;ngt.
     * @param trees die hinzuzuf&uuml;genden B&auml;ume
     * @param idx der Startindex der f&uuml;r die Rekursion ben&ouml;tigt wird
     */
    public void addChildren(Tree[] trees, int idx) {
        if (idx < trees.length) {
            if (children == null) {
                TreeList tl = new TreeList();
                tl.setHead(new TreeListElement(trees[idx], null));
                children = tl;
            } else {
                TreeListElement last = children.getLastItem();
                last.setNext(new TreeListElement(trees[idx], null));
            }
            addChildren(trees, idx + 1);
        }
    }

}
