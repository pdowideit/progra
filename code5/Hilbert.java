public class Hilbert {

    /**
     * Methode malt eine Hilbert Links Kurve mit den &uuml;bergebenen Parametern
     * @param c ein Canvas auf dem gemalt werden kann
     * @param ordnung die Ordnung der Hilbert Kurve
     * @param length die L&auml;nge der einzelnen Linien der Hilbert Kurve
     */
  static void hilbertLinks(Canvas c, int ordnung, int length) {
      if(ordnung>0) {
          c.rotate(-90);
          hilbertRechts(c, ordnung - 1, length);
          c.drawForward(length);
          c.rotate(90);
          hilbertLinks(c, ordnung - 1, length);
          c.drawForward(length);
          hilbertLinks(c, ordnung - 1, length);
          c.rotate(90);
          c.drawForward(length);
          hilbertRechts(c, ordnung - 1, length);
          c.rotate(-90);
      }
  }
    /**
     * Methode malt eine Hilbert Rechts Kurve mit den &uuml;bergebenen Parametern
     * @param c ein Canvas auf dem gemalt werden kann
     * @param ordnung die Ordnung der Hilbert Kurve
     * @param length die L&auml;nge der einzelnen Linien der Hilbert Kurve
     */
  static void hilbertRechts(Canvas c, int ordnung, int length) {
      if(ordnung>0) {
          c.rotate(90);
          hilbertLinks(c, ordnung - 1, length);
          c.drawForward(length);
          c.rotate(-90);
          hilbertRechts(c, ordnung - 1, length);
          c.drawForward(length);
          hilbertRechts(c, ordnung - 1, length);
          c.rotate(-90);
          c.drawForward(length);
          hilbertLinks(c, ordnung - 1, length);
          c.rotate(90);
      }
  }

    /**
     * Methode um die Implementationen auszuprobieren
     * @param args Eingaben aus der Konsole als Strings
     */
  public static void main(String[] args) {
        int ordnung = 6;
        int length = 5;
        boolean links = true;
        switch (args.length) {
            case 3:
              if(args[2].equals("r")) {
                links = false;
              } else if (!args[2].equals("l")) {
                System.out.println(
                    "Unbekannter parameter " + args[2]);
                System.out.println(
                    "Nutze Standardwert l");
              }
            case 2:
                length = Integer.parseInt(args[1]);
                // fall-through
            case 1:
                ordnung = Integer.parseInt(args[0]);
                break;
            default:
                System.out.println(
                    "Verwende Standardwerte: Ordnung 6, Laenge 5, links.");
                System.out.println(
                    "Verwendung: java Hilbert [ordnung [laenge [(l|r)]]]");
        }
        if (ordnung < 0) {
            System.out.println("Die Rekursionsordnung muss nicht-negativ sein!");
            return;
        }
        if (length < 1) {
            System.out.println("Die Laenge muss positiv sein!");
            return;
        }
        Canvas c = new Canvas();
        if(links) {
          Hilbert.hilbertLinks(
              c,
              ordnung,
              length
          );
        } else {
          Hilbert.hilbertRechts(
              c,
              ordnung,
              length
          );
        }
        c.refresh();
  }
}
