import java.util.Objects;

public class Steamship extends Ship{
    private double turbinePower;

    private String cargoType;

    public Steamship(){
        cargoType = "passenger";
        turbinePower = 1;
    }

    public Steamship(double weight, String name, double turbinePower, String cargoType){
        super(weight, name);
        this.cargoType = (!cargoType.isEmpty()) ? cargoType : "passenger";
        this.turbinePower = (turbinePower > 0 && turbinePower < 1000) ? turbinePower : 1;
    }

    public double getTurbinePower() {
        return turbinePower;
    }

    public void setTurbinePower(double turbinePower) {
        if(turbinePower > 0 && turbinePower < 1000){
            this.turbinePower = turbinePower;
        }
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        if(!cargoType.isEmpty()){
            this.cargoType = cargoType;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        if (!(object instanceof Steamship steamship)) return false;
        return turbinePower == steamship.getTurbinePower() && cargoType.equals(steamship.getCargoType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), turbinePower, cargoType);
    }

    @Override
    public String toString() {
        String res = super.toString();
        return "Steamship{" + res +
                "turbinePower=" + turbinePower +
                ", cargoType='" + cargoType + '\'' +
                '}';
    }
}
