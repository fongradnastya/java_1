import java.util.Objects;

public class Sailboat extends Ship{
    private int numberOfSails;

    private String sailColor;

    public Sailboat(){
        sailColor = "white";
        numberOfSails = 5;
    }

    public Sailboat(double weight, String name, int numbOfSails, String color){
        super(weight, name);
        this.sailColor = (!color.isEmpty()) ? color : "passenger";
        this.numberOfSails = (numbOfSails > 0 && numbOfSails < 50) ? numbOfSails : 5;
    }

    public int getNumberOfSails() {
        return numberOfSails;
    }

    public void setNumberOfSails(int numberOfSails) {
        if(numberOfSails > 0 && numberOfSails < 50){
            this.numberOfSails = numberOfSails;
        }
    }

    public String getSailColor() {
        return sailColor;
    }

    public void setSailColor(String sailColor) {
        if(!sailColor.isEmpty()) {
            this.sailColor = sailColor;
        }
    }
    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        if (!(object instanceof Sailboat sailboat)) return false;
        return numberOfSails == sailboat.getNumberOfSails() && sailColor.equals(sailboat.getSailColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sailColor, numberOfSails);
    }

    @Override
    public String toString() {
        return "Sailboat{" +
                "name=" + getName() +
                ", weight=" + getWeight() +
                ", numberOfSails=" + numberOfSails +
                ", sailColor='" + sailColor + '\'' +
                '}';
    }
}
