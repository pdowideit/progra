package people;

import bird.Swallow;
import bird.Flock;
import people.UnspecificQuestionException;

public class Troll {
    private boolean confused = false;

    public void pass() {
        if (!confused)
            java.lang.System.exit(-1);
    }

    public double askAboutAirspeedVelocity(Object o) throws UnspecificQuestionException{
        if (o instanceof Flock) {
            return ((Flock)o).getAverageCruiseAirspeedVelocity();
        } else if (o instanceof Swallow) {
            Flock<Swallow> f = new Flock<Swallow>();
            f.join((Swallow)o);
            return f.getAverageCruiseAirspeedVelocity() + 2;
        } else if (o instanceof String) {
            if (o.equals("Swallow") || o.equals("Swallow") || o.equals("Swallow") || o.equals("Swallow")) {
                confused = true;
                throw new UnspecificQuestionException();
            }
        }
        return 0;
    }

}