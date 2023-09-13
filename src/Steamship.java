import java.util.Objects;

/**
 * Класс парохода
 */
public class Steamship extends Ship{
    /**
     * Мощность турбины
     */
    private double turbinePower;

    /**
     * Тип пароходного груза
     */
    private String cargoType;

    /**
     * Конструктор парохода
     */
    public Steamship(){
        cargoType = "passenger";
        turbinePower = 1;
    }

    /**
     * Конструктор парохода с параметрами
     * @param weight вес парохода
     * @param name название парохода
     * @param turbinePower мощность турбин
     * @param cargoType тип груза парохода
     */
    public Steamship(double weight, String name, double turbinePower, String cargoType){
        super(weight, name);
        this.cargoType = (!cargoType.isEmpty()) ? cargoType : "passenger";
        this.turbinePower = (turbinePower > 0 && turbinePower < 1000) ? turbinePower : 1;
    }

    /**
     * Получение мощности турбин
     * @return мощность двигателя
     */
    public double getTurbinePower() {
        return turbinePower;
    }

    /**
     * Устанавливает мощность турбины
     * @param turbinePower мощность для установки
     */
    public void setTurbinePower(double turbinePower) {
        if(turbinePower > 0 && turbinePower < 1000){
            this.turbinePower = turbinePower;
        }
    }

    /**
     * Получает тип груза парохода
     * @return тип груза
     */
    public String getCargoType() {
        return cargoType;
    }

    /**
     * Устанавливает тип груза парохода
     * @param cargoType тип груза
     */
    public void setCargoType(String cargoType) {
        if(!cargoType.isEmpty()){
            this.cargoType = cargoType;
        }
    }

    /**
     * Сравнивает пароходы между собой
     * @param object объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        if (!(object instanceof Steamship steamship)) return false;
        return turbinePower == steamship.getTurbinePower() && cargoType.equals(steamship.getCargoType());
    }

    /**
     * Вычисляет хеш объекта
     * @return хеш объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), turbinePower, cargoType);
    }

    /**
     * Создаёт строковое представление объекта
     * @return строка с информацией о пароходе
     */
    @Override
    public String toString() {
        return "Steamship{" +
                "name=" + getName() +
                ", weight=" + getWeight() +
                ", turbinePower=" + turbinePower +
                ", cargoType='" + cargoType + '\'' +
                '}';
    }
}
