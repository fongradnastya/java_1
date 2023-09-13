import java.util.Objects;

/**
 * Класс корабля
 */
public class Ship {
    /**
     * Вес корабля
     */
    private double weight;

    /**
     * Название коабля
     */
    private String name;

    /**
     * Конструктор корабля
     */
    public Ship(){
        name = "Default";
    }

    /**
     * Конструктор корабля с параметрами
     * @param weight вес корабля
     * @param name название корабля
     */
    public Ship(double weight, String name){
        this.name = (!name.isEmpty()) ? name : "Default";
        this.weight = (weight > 0 && weight < 100000) ? weight : 0;
    }

    /**
     * Получение веса корабля
     * @return вес судна
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Установка веса корабля
     * @param weight вес судна
     */
    public void setWeight(double weight) {
        if (weight > 0 && weight < 100000){
            this.weight = weight;
        }
    }

    /**
     * Получение названия судна
     * @return название корабля
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название корабля
     * @param name название судна
     */
    public void setName(String name) {
        if(!name.isEmpty()){
            this.name = name;
        }
    }

    /**
     * Сравнивает корабли между собой
     * @param object объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Ship furniture)) return false;
        return Double.compare(furniture.getWeight(), getWeight()) == 0
                && Objects.equals(getName(), furniture.getName());
    }

    /**
     * Вычисляет хеш объекта
     * @return полученное значение хеша
     */
    @Override
    public int hashCode() {
        return Objects.hash(weight, name);
    }

    /**
     * Создание строкового представления объекта
     * @return строка с информацией о корабле
     */
    @Override
    public String toString() {
        return "Ship{" +
                "name=" + name +
                ", weight='" + weight + '\'' +
                '}';
    }
}
