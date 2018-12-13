package bird.swallow;

import bird.Swallow;

public class EuropeanSwallow extends Swallow {
    private int airspeedVelocity = 11;

    public EuropeanSwallow(Object cargo){
        super(cargo);
    }

    public int getAirspeedVelocity() {
        return this.calculateRealAirspeedVelocity(airspeedVelocity);
    }
}