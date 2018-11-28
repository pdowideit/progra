/**
 * Die Klasse Tree stellt einen rekursiven Baum mit beliebiger Anzahl an Kinder für jeden Knoten.
 * Dabei besteht ein Baum immer aus einem ganzzahligen Wert und einer Liste an Kindern.
 * Tree hat zwei Variablen, für die es jeweils Getter und Setter Methoden gibt.
 */
public class Tree {
    private int label;

    private TreeList children;

    public Tree(int inputLabel, TreeList inputChildren) {
        this.label = inputLabel;
        this.children = inputChildren;
    }

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
    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    //b)

    public TreeList getChildren() {
        return children;
    }

    //c)

    public void setChildren(TreeList children) {
        this.children = children;
    }

    //d)

    public String toString() {
        String res = label + "->[";
        if (children != null) {
            res += children.toString();
        }
        res += "]";
        return res;
    }

    //e)

    public int branchingDegree() {
        if (children == null)
            return 0;
        int childrenBranchDeg = children.branchingDegree();
        int childrenSize = children.size();
        return childrenSize > childrenBranchDeg ? childrenSize : childrenBranchDeg;
    }

    public boolean contains(int toSearch) {
        if (label == toSearch) {
            return true;
        }
        if (children != null) {
            return children.contains(toSearch);
        }
        return false;

    }

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
