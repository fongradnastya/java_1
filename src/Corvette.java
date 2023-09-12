import java.util.Objects;

public class Corvette extends Ship{

    public int numberOfGuns;

    public String purpose;

    public Corvette(){
        numberOfGuns = 0;
        purpose = "reserve";
    }

    public Corvette(double weight, String name, int numberOfGuns, String purpose){
        super(weight, name);
        this.numberOfGuns = (numberOfGuns >= 0 && numberOfGuns < 1000) ? numberOfGuns : 0;
        this.purpose = (purpose.isEmpty()) ? "reserve" : purpose;
    }

    public int getNumberOfGuns() {
        return numberOfGuns;
    }

    public void setNumberOfGuns(int numberOfGuns) {
        if(numberOfGuns >= 0 && numberOfGuns < 1000) {
            this.numberOfGuns = numberOfGuns;
        }
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        if(!purpose.isEmpty()){
            this.purpose = purpose;
        }
    }
    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        if (!(object instanceof Corvette corvette)) return false;
        return numberOfGuns == corvette.getNumberOfGuns() && purpose.equals(corvette.getPurpose());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfGuns, purpose);
    }

    @Override
    public String toString() {
        String res = super.toString();
        return "Corvette{" + res +
                "numberOfGuns=" + numberOfGuns +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
