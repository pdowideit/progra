import java.util.*;

public class Main {
    public static void main(String[] args) {
        FunctionalSet<Integer> s = new FunctionalSet<>();
        String line;
        do {
            line = SimpleIO.getString("Enter 'add i', 'remove i', 'min', or 'exit'!");
            String[] words = line.split(" ");
            switch (words[0]) {
            case "exit": break;
            case "add":
                s.add(Integer.parseInt(words[1]));
                System.out.println(s);
                break;
            case "remove":
                s.remove(Integer.parseInt(words[1]));
                System.out.println(s);
                break;
            case "min":
                System.out.println(s.min(Comparator.<Integer>naturalOrder()));
                break;
            default:
                System.out.println("Unknown command.");
            }
        } while (!"exit".equals(line));
    }
}
