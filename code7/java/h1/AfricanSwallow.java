package bird.swallow;

import bird.Swallow;

public class AfricanSwallow extends Swallow{
    private int airspeedVelocity = 12;

    public AfricanSwallow(Object cargo){
        super(cargo);
    }

    public int getAirspeedVelocity(){
        return this.calculateRealAirspeedVelocity(airspeedVelocity);
    }


}