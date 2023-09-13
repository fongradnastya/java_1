import java.util.Objects;

/**
 * Класс парусника
 */
public class Sailboat extends Ship{
    /**
     * Количество парусов корабля
     */
    private int numberOfSails;

    /**
     * Цвет парусов
     */
    private String sailColor;

    /**
     * Конструктор парусеика
     */
    public Sailboat(){
        sailColor = "white";
        numberOfSails = 5;
    }

    /**
     * Конструктор парусника с параметрами
     * @param weight вес парусника
     * @param name название парусника
     * @param numbOfSails число парусов
     * @param color цвет парусов
     */
    public Sailboat(double weight, String name, int numbOfSails, String color){
        super(weight, name);
        this.sailColor = (!color.isEmpty()) ? color : "passenger";
        this.numberOfSails = (numbOfSails > 0 && numbOfSails < 50) ? numbOfSails : 5;
    }

    /**
     * Получает число парусов
     * @return количество парусов корабля
     */
    public int getNumberOfSails() {
        return numberOfSails;
    }

    /**
     * Устанавливает число парусов
     * @param numberOfSails количество парусов на корабле
     */
    public void setNumberOfSails(int numberOfSails) {
        if(numberOfSails > 0 && numberOfSails < 50){
            this.numberOfSails = numberOfSails;
        }
    }

    /**
     * Получает цвет парусов
     * @return цвет парусов
     */
    public String getSailColor() {
        return sailColor;
    }

    /**
     * Устанавливает новый цвет парусов
     * @param sailColor цвет парусов
     */
    public void setSailColor(String sailColor) {
        if(!sailColor.isEmpty()) {
            this.sailColor = sailColor;
        }
    }

    /**
     * Сравнивает парусники между собой
     * @param object объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        if (!(object instanceof Sailboat sailboat)) return false;
        return numberOfSails == sailboat.getNumberOfSails() && sailColor.equals(sailboat.getSailColor());
    }

    /**
     * Вычисляет хеш код объекта
     * @return хеш код
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sailColor, numberOfSails);
    }

    /**
     * Создаёт строковое представления объекта
     * @return строка с информацией о паруснике
     */
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
