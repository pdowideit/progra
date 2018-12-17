package people;

import cargo.Nut;
import bird.Swallow;

/*  
 *  Falls Ihnen Teile der Aufgabe, Texte oder Variablenbenennungen komisch
 *  oder unlogisch erscheinen, sollten Sie den Film zu Erklaerung schauen.
 */

public class KingArthur {
  public static void main(String[] args) {
    System.out.println("King Arthur reitet in die Szene");
    Nut horse = new Nut();
    horse.setName("Kokosnuesse");
    horse.setWeight(7);
    System.out.println("Patsy imitiert ein Pferd und nutzt dazu " + horse.getName());
    System.out.println("Die " + horse.getName() + " wiegen " + horse.getWeight());

    System.out.println("Auf der Bruecke des Todes sitzt ein Troll.");
    Troll troll = new Troll();

    System.out.println("Was ist die Fluggeschwindigkeit dieser Kokusnuss?");
    try {
      System.out.println("Troll: " + troll.askAboutAirspeedVelocity(horse));
    }
    catch(UnspecificQuestionException e) {
    }
      System.out.println("Der Troll ist bestimmt harmlos, genau wie Kaninchen! Wir gehen einfach vorbei!");

    troll.pass(); //auskommentieren damit der Code aus Aufgabenteil h) erreicht wird
    System.out.println("King Arthur hat den Troll sicher passiert!");

    System.out.println("Ein weiterer Troll erscheint!");
    Troll troll2 = new Troll();
    System.out.println("King Arthur stellt dem Troll eine Frage.");
    try {
      troll2.askAboutAirspeedVelocity("Swallow");
    }
    catch(UnspecificQuestionException e){
      System.out.println("Der Troll ist von der Frage verwirrt!");

    }
    troll2.pass();
    System.out.println("King Arthur hat den zweiten Troll sicher passiert!");

  }
}
