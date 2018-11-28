public class ListExercise {

    /**
     * Sorts the given list.
     * @param list the list that will be sorted
     * @return the sorted list
     */
    public static List mergesort(List list) {
        if (list.isEmpty() || list.getNext().isEmpty()) {
            return list;
        } else {
            List[] twoLists = divide(list);
            List newListA = mergesort(twoLists[0]);
            List newListB = mergesort(twoLists[1]);
            return merge(newListA, newListB);
        }
    }

    /*
     * Merges two sorted lists to one sorted list.
     */
    private static List merge(List first, List second) {
        if (first.isEmpty()) {
            return second;
        }
        if (second.isEmpty()) {
            return first;
        }
        if (first.getValue() > second.getValue()) {
            return new List(merge(first, second.getNext()), second.getValue());
        } else {
            return new List(merge(first.getNext(), second), first.getValue());
        }
    }

    /*
     * Divides a list of at least two elements into two lists of the same 
     * length (up to rounding).
     */
    private static List[] divide(List list) {
        List[] res = new List[2];
        int length = list.length() / 2;
        res[0] = list.getSublist(length);
        for (int i = 0; i < length; i++) {
            list = list.getNext();
        }
        res[1] = list;
        return res;
    }
    
    /**
     * Creates a list from the given inputs and outputs the sorted list and 
     * the original list thereafter.
     * @param args the elements of the list to be sorted
     */
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            List list = buildList(0,args);
            System.out.println(mergesort(list));
            System.out.println(list);
        }
    }

    /*
     * Builds a list from the given input array.
     * 
     */
    private static List buildList(int i, String[] args) {
        if (i < args.length) {
            return new List(buildList(i + 1,args), Integer.parseInt(args[i]));
        } else {
            return List.EMPTY;
        }
    }
    
}
