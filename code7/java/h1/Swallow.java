package bird;

public abstract class Swallow {
    private Object cargo = null;

    public Swallow(Object cargo) {
        this.cargo = cargo;
    }

    public Swallow(){
        this(null);
    }

    public Object getCargo() {
        return cargo;
    }

    public boolean isLadden(){
        return (this.cargo == null);
    }

    public abstract int getAirspeedVelocity();

    protected int calculateRealAirspeedVelocity(int airspeedVelocity) {
        if (this.getCargo() != null && this.getCargo() instanceof cargo.Nut) {
            int realAirspeedVelocity = airspeedVelocity - ((cargo.Nut) this.getCargo()).getWeight();
            return realAirspeedVelocity < 0 ? realAirspeedVelocity : 0;
        }
        else if(this.getCargo() != null){
            return airspeedVelocity / 2;
        }
        else{
            return airspeedVelocity;
        }
    }
}