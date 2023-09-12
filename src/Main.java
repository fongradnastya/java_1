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

    /*
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
        System.out.println("--------------------FURNITURE---------------------");
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
    public static Ship createNewFurniture(int type){
        Ship newShip = null;
        System.out.println("Please, enter a weight");
        double weight = inputDouble(100000);
        System.out.println("Please, enter a ship name");
        String name = inputString();
        if(type == 4){
            System.out.println("Please, enter a number of legs");
            int legs = getPositiveNumber(10);
            System.out.println("Please, enter a chair type");
            String chairType = inputString();
            newShip = new Steamship(weight, material, legs, chairType);
        }
        else if (type == 5){
            System.out.println("Please, enter a number of persons");
            int persons = getPositiveNumber(100);
            System.out.println("Please, enter a tabletop shape");
            String tabletopShape = inputString();
            newShip = new Sailboat(weight, material, persons, tabletopShape);
        }
        else if (type == 6){
            System.out.println("Please, enter a wardrobe height");
            double height = inputDouble(3);
            System.out.println("Please, enter a wardrobe purpose");
            String purpose = inputString();
            newShip = new Corvette(weight, material, height, purpose);
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
            case 1 -> listOfShips.add(new Chair());
            case 2 -> listOfShips.add(new Table());
            case 3 -> listOfShips.add(new Wardrobe());
            case 4 -> listOfShips.add(new Corvette());
            case 5, 6, 7, 8 -> listOfShips.add(createNewFurniture(command));
            case 9 -> System.out.println("Successfully quited");
            default -> System.out.println("Wrong command!");
        }
    }

    /**
     * Выводит список всей мебели с её характеристиками
     */
    public static void printFurniture(){
        int id = 1;
        System.out.println("---------------------------------FURNITURE------------------------------------");
        if (listOfShips.isEmpty()){
            System.out.println("There are no furniture yet");
        }
        else {
            for(Furniture item : listOfShips){
                System.out.println(id + ")  " + item);
                id++;
            }
        }
        System.out.println("------------------------------------------------------------------------------");
    }

    /**
     * Сравнивает два предмета мебели и выводит в консоль сообщение о результате сравнения
     */
    public static void compareFurniture(){
        if(listOfShips.size() < 2){
            System.out.println("Too few items to compare");
        }
        else {
            printFurniture();
            int maxValue = listOfShips.size();
            System.out.print("Please, enter 1 furniture ID\n");
            int furnitureId1 = getPositiveNumber(maxValue);
            Furniture furniture1 = listOfShips.get(furnitureId1 - 1);
            System.out.print("Please, enter 2 furniture ID\n");
            int furnitureId2 = getPositiveNumber(maxValue);
            Furniture furniture2 = listOfShips.get(furnitureId2 - 1);
            if (furnitureId1 == furnitureId2){
                System.out.println("You are truing to compare an object with itself");
            }
            else if (furniture1.equals(furniture2)){
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
    public static void deleteFurniture(){
        if(listOfShips.size() < 1){
            System.out.println("Nothing to delete");
        }
        else {
            printFurniture();
            int maxValue = listOfShips.size();
            System.out.print("Please, enter furniture ID\n");
            int furniture = getPositiveNumber(maxValue);
            listOfShips.remove(furniture);
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
        while(! end){
            printMenu();
            int command = getCommand();
            switch (command){
                case 1 -> addShip();
                case 2 -> deleteFurniture();
                case 3 -> printFurniture();
                case 4 -> compareFurniture();
                case 5 -> end = true;
                default -> System.out.println("Wrong command!");
            }
        }
        scanner.close();
    }
}