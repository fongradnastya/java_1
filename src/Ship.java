import java.util.Objects;

public class Ship {
    private double weight;

    private String name;

    public Ship(){
        name = "Default";
    }

    public Ship(double weight, String name){
        this.name = (!name.isEmpty()) ? name : "Default";
        this.weight = (weight > 0 && weight < 100000) ? weight : 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0 && weight < 100000){
            this.weight = weight;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.isEmpty()){
            this.name = name;
        }
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Ship furniture)) return false;
        return Double.compare(furniture.getWeight(), getWeight()) == 0
                && Objects.equals(getName(), furniture.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, name);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
