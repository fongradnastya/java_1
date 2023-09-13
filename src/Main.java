import java.util.ArrayList;
import java.util.Scanner;

/**
 * Основной класс приложения
 */
public class Main {
    /**
     * Коллекция мебели
     */
    private static ArrayList<Ship> listOfShips;

    /**
     * Объект для считывания пользовательких данных из консоли
     */
    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Считывает строку, содержащую одно число типа int
     * @return number - считанное целое число
     */
    public static int getIntString() {
        int number = 0;
        while (number == 0)
        {
            if(scanner.hasNext()){
                String line = scanner.nextLine();
                try
                {
                    number = Integer.parseInt(line);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Wrong number format!");
                    return 0;
                }
            }
        }
        return number;
    }

    /**
     * Считывает комманду из консоли
     * @return - комманда в виде числа типа int
     */
    public static int getCommand(){
        System.out.print("Your command: ");
        return getIntString();
    }

    /**
     * Считывает из консоли число в диапазоне от 0 до maxValue
     * @param maxValue максимальное значение числа
     * @return считанное число, принадлежащее диапазону
     */
    public static int getPositiveNumber(int maxValue){
        if (maxValue < 1) return 0;
        int number = 0;
        while(number < 1){
            System.out.print("You value: ");
            number = getIntString();
            if(number < 1){
                System.out.println("This value should be positive!");
            }
            if(number > maxValue){
                number = 0;
                System.out.printf("This value should be lover then %d\n", maxValue + 1);
            }
        }
        return number;
    }

    /**
     * Считывает из консоли дробное число в диапазоне от 0 до maxValue
     * @param maxValue максимальное значение числа
     * @return считанное число, принадлежащее диапазону
     */
    public static double inputDouble(double maxValue){
        if (maxValue < 1) return 0;
        double number = 0;
        while (number == 0)
        {
            System.out.print("You value: ");
            if(scanner.hasNext()){

                String line = scanner.nextLine();
                try
                {
                    number = Double.parseDouble(line);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Wrong number format!");
                }
                if (number < 0 || number > maxValue){
                    number = 0;
                    System.out.printf("This value should be between 0 and %f\n", maxValue);
                }
            }
        }
        return number;
    }

    /**
     * Считывает из консоли название фильма
     * @return название фильма
     */
    public static String inputString(){
        System.out.print("You value: ");
        return scanner.nextLine();
    }

    /**
     * Выводит в консоль основное меню пользователя
     */
    public static void printMenu(){
        System.out.println("----------------------MENU------------------------");
        System.out.println("1 - add a new ship");
        System.out.println("2 - delete a ship by id");
        System.out.println("3 - print all the ships");
        System.out.println("4 - compare ships by id");
        System.out.println("5 - exit");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Выводит в консоль меню добавления предмета мебели
     */
    public static void printShipMenu(){
        System.out.println("----------------------SHIP------------------------");
        System.out.println("1 - add a ship");
        System.out.println("2 - add a steamship");
        System.out.println("3 - add a sailboat");
        System.out.println("4 - add a corvette");
        System.out.println("5 - add a ship with parameters");
        System.out.println("6 - add a steamship with parameters");
        System.out.println("7 - add a sailboat with parameters");
        System.out.println("8 - add a corvette with parameters");
        System.out.println("9 - cancel");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Создаёт новый объект мебели с параметрами
     * @param type тип объекта 4 - стул, 5 - стол, 6 - гардеробный шкаф
     * @return созданный предмет мебели
     */
    public static Ship createNewShip(int type){
        Ship newShip = null;
        System.out.println("Please, enter a weight");
        double weight = inputDouble(100000);
        System.out.println("Please, enter a ship name");
        String name = inputString();
        if(type == 5){
            newShip = new Ship(weight, name);
        }
        else if (type == 6){
            System.out.println("Please, enter a turbine power");
            double turbinePower = inputDouble(1000);
            System.out.println("Please, enter a cargo type");
            String cargoType = inputString();
            newShip = new Steamship(weight, name, turbinePower, cargoType);
        }
        else if (type == 7){
            System.out.println("Please, enter a number of sails");
            int number = getPositiveNumber(50);
            System.out.println("Please, enter a sail color");
            String sailColor = inputString();
            newShip = new Sailboat(weight, name, number, sailColor);
        }
        else if (type == 8){
            System.out.println("Please, enter a number of guns");
            int number = getPositiveNumber(1000);
            System.out.println("Please, enter a corvette purpose");
            String purpose = inputString();
            newShip = new Corvette(weight, name, number, purpose);
        }
        return newShip;
    }

    /**
     * Добавляет в коллекцию новый объект мебели
     */
    public static void addShip(){
        printShipMenu();
        int command = getCommand();
        switch (command){
            case 1 -> listOfShips.add(new Ship());
            case 2 -> listOfShips.add(new Steamship());
            case 3 -> listOfShips.add(new Sailboat());
            case 4 -> listOfShips.add(new Corvette());
            case 5, 6, 7, 8 -> listOfShips.add(createNewShip(command));
            case 9 -> System.out.println("Successfully quited");
            default -> System.out.println("Wrong command!");
        }
    }

    /**
     * Выводит список всей мебели с её характеристиками
     */
    public static void printShip(){
        int id = 1;
        System.out.println("-----------------------------------SHIP--------------------------------------");
        if (listOfShips.isEmpty()){
            System.out.println("There are no ships yet");
        }
        else {
            for(Ship item : listOfShips){
                System.out.println(id + ")  " + item);
                id++;
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * Сравнивает два предмета мебели и выводит в консоль сообщение о результате сравнения
     */
    public static void compareShips(){
        if(listOfShips.size() < 2){
            System.out.println("Too few items to compare");
        }
        else {
            printShip();
            int maxValue = listOfShips.size();
            System.out.print("Please, enter 1 furniture ID\n");
            int furnitureId1 = getPositiveNumber(maxValue);
            Ship ship1 = listOfShips.get(furnitureId1 - 1);
            System.out.print("Please, enter 2 furniture ID\n");
            int ship2 = getPositiveNumber(maxValue);
            Ship furniture2 = listOfShips.get(ship2 - 1);
            if (furnitureId1 == ship2){
                System.out.println("You are truing to compare an object with itself");
            }
            else if (ship1.equals(furniture2)){
                System.out.println("This objects are equals");
            }
            else {
                System.out.println("This objects are different");
            }
        }
    }

    /**
     * Удаляет предмет мебели, имеющий определённый номер
     */
    public static void deleteShip(){
        if(listOfShips.size() < 1){
            System.out.println("Nothing to delete");
        }
        else {
            printShip();
            int maxValue = listOfShips.size();
            System.out.print("Please, enter furniture ID\n");
            int ship = getPositiveNumber(maxValue);
            listOfShips.remove(ship);
            System.out.println("Item was successfully deleted!");
        }
    }

    /**
     * Точка входа в программу, запускает основную логику приложения
     * @param args введённые пользователем аргументы командной строки
     */
    public static void main(String[] args) {
        listOfShips = new ArrayList<>();
        boolean end = false;
        while(!end){
            printMenu();
            int command = getCommand();
            switch (command){
                case 1 -> addShip();
                case 2 -> deleteShip();
                case 3 -> printShip();
                case 4 -> compareShips();
                case 5 -> end = true;
                default -> System.out.println("Wrong command!");
            }
        }
        scanner.close();
    }
}