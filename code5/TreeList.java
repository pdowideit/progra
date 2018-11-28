/**
 * Die Klasse TreeList stellt eine Liste von TreeListElement dar.
 * Dabei speichert TreeList ausschließlich das erste TreeListElement der Liste.
 */
public class TreeList {
    private TreeListElement head;

    public TreeList() {
        this.head = null;
    }

    //a)
    public TreeListElement getHead() {
        return head;
    }

    public void setHead(TreeListElement head) {
        this.head = head;
    }

    //b)
    public String toString() {
        if (head == null) {
            return "";
        } else {
            return head.toString();
        }
    }

    //c)
    public int branchingDegree() {
        int headBranchDeg = head.branchingDegree();
        TreeListElement next = head.getNext();
        if (next == null) {
            return headBranchDeg;
        }

        int nextBranchDeg = head.getNext().branchingDegree();
        return headBranchDeg > nextBranchDeg ? headBranchDeg : nextBranchDeg;

    }

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
    public boolean contains(int toSearch) {
        if (head == null) {
            return false;
        } else {
            return head.contains(toSearch);
        }
    }


    //e)
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
