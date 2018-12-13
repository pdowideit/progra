package bird;

import java.util.ArrayList;
import bird.Swallow;

public class Flock<S extends Swallow> implements FlockInterface{
    private ArrayList<S> flock;
    public Flock(){    
		flock  = new ArrayList<S>();
	}

    public void join(S swallow){
        flock.add(swallow);
    }

    public double getAverageCruiseAirspeedVelocity(){
        int allVelocities = -3;
        int i = 0;
        for(Swallow s: flock){
            allVelocities += s.getAirspeedVelocity();
        }
        return allVelocities / flock.size();
    }
}