import java.util.Objects;

/**
 * Класс корвета
 */
public class Corvette extends Ship{
    /**
     * Число пушек на корабле
     */
    public int numberOfGuns;

    /**
     * Предназначение корабля
     */
    public String purpose;

    /**
     * Конструктор корвета
     */
    public Corvette(){
        numberOfGuns = 0;
        purpose = "reserve";
    }

    /**
     * Конструктор корвета с параметрами
     * @param weight вес корабля
     * @param name название корабля
     * @param numberOfGuns число пушек на корабле
     * @param purpose назначение корабля
     */
    public Corvette(double weight, String name, int numberOfGuns, String purpose){
        super(weight, name);
        this.numberOfGuns = (numberOfGuns >= 0 && numberOfGuns < 1000) ? numberOfGuns : 0;
        this.purpose = (purpose.isEmpty()) ? "reserve" : purpose;
    }

    /**
     * Получает текущее число пушек на корале
     * @return число пушек
     */
    public int getNumberOfGuns() {
        return numberOfGuns;
    }

    /**
     * Устанавливает число пушек
     * @param numberOfGuns количество оружия
     */
    public void setNumberOfGuns(int numberOfGuns) {
        if(numberOfGuns >= 0 && numberOfGuns < 1000) {
            this.numberOfGuns = numberOfGuns;
        }
    }

    /**
     * Получение назначения
     * @return назначение корабля
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * Назначение новой цели корабля
     * @param purpose назначение корабля
     */
    public void setPurpose(String purpose) {
        if(!purpose.isEmpty()){
            this.purpose = purpose;
        }
    }

    /**
     * Сравнение корветов между собой
     * @param object объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        if (!(object instanceof Corvette corvette)) return false;
        return numberOfGuns == corvette.getNumberOfGuns() && purpose.equals(corvette.getPurpose());
    }

    /**
     * Подсчёт хеша объекта
     * @return полученный хеша
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfGuns, purpose);
    }

    /**
     * Создание строкового представления объекта
     * @return строка с информацией о корвете
     */
    @Override
    public String toString() {
        return "Corvette{" +
                "name=" + getName() +
                ", weight=" + getWeight() +
                ", numberOfGuns=" + numberOfGuns +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
