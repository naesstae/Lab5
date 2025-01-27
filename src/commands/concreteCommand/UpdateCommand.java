package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Invoker;
import exceptions.IllegalValueOfXException;
import java.util.Scanner;

public class UpdateCommand implements Command {

    private void updateName(Scanner scanner, Dragon dragon) {
        boolean i = true;
        while (i) {
            System.out.println("Введите имя дракона");
            String name = scanner.nextLine();
            if (!name.trim().isEmpty()) {
                dragon.setName(name);
                i = false;
            } else {
                System.out.println("Неверный тип данных");
            }
        }
    }
    private void updateAge(Scanner scanner, Dragon dragon) {
        boolean i = true;
        while (i) {
            System.out.println("Введите новый возраст дракона");
            String string = scanner.nextLine();
            if (string.matches("([-+]?\\d+)")) {
                long age = Long.parseLong(string);
                dragon.setAge(age);
                i = false;
            } else {
                System.out.println("Неверный тип данных");
            }
        }
    }
    private void updateType(Scanner scanner, Dragon dragon) {
        boolean i = true;
        while (i) {
            System.out.println("Введите новый тип дракона (Цифру или полное название) 1 - WATER, 2 - UNDERGROUND, 3 - FIRE");
            String type = scanner.nextLine();
            if (type.equals("1") || type.equals("2") || type.equals("3") || type.equals("WATER") || type.equals("UNDERGROUND") || type.equals("FIRE")) {
                switch (type) {
                    case "1", "WATER" -> dragon.setType(DragonType.WATER);
                    case "2", "UNDERGROUND" -> dragon.setType(DragonType.UNDERGROUND);
                    case "3", "FIRE" -> dragon.setType(DragonType.FIRE);
                }
                i = false;
            } else {
                System.out.println("Неверный тип данных");
            }
        }
    }
    private void updateColor(Scanner scanner, Dragon dragon) {
        boolean i = true;
        while (i) {
            System.out.println("Введите новый цвет дракона (Цифру или полное название) 1 - GREEN, 2 - ORANGE, 3 - BROWN");
            String color = scanner.nextLine();
            if (color.equals("1") || color.equals("2") || color.equals("3") || color.equals("GREEN") || color.equals("ORANGE") || color.equals("BROWN") || color.isEmpty()) {
                switch (color) {
                    case "1", "GREEN" -> dragon.setColor(Color.GREEN);
                    case "2", "ORANGE" -> dragon.setColor(Color.ORANGE);
                    case "3", "BROWN" -> dragon.setColor(Color.BROWN);
                    case "" -> dragon.setColor(null);
                }
                i = false;
            } else {
                System.out.println("Неверный тип данных");
            }
        }
    }
    private void updateCharacter(Scanner scanner, Dragon dragon) {
        boolean i = true;
        while (i) {
            System.out.println("Введите новый характер дракона (Цифру или полное название) 1 - CUNNING, 2 - WISE, 3 - CHAOTIC_EVIL, 4 - FICKLE");
            String character = scanner.nextLine();
            if (character.equals("1") || character.equals("2") || character.equals("3") || character.equals("CUNNING") || character.equals("WISE") || character.equals("CHAOTIC_EVIL") || character.equals("FICKLE") || character.equals("4")) {
                switch (character) {
                    case "1", "CUNNING" -> dragon.setCharacter(DragonCharacter.CUNNING);
                    case "2", "WISE" -> dragon.setCharacter(DragonCharacter.WISE);
                    case "3", "CHAOTIC_EVIL" -> dragon.setCharacter(DragonCharacter.CHAOTIC_EVIL);
                    case "4", "FICKLE" -> dragon.setCharacter(DragonCharacter.FICKLE);
                }
                i = false;
            } else {
                System.out.println("Неверный тип данных");
            }
        }
    }
    private void updateHead(Scanner scanner, Dragon dragon) {
        boolean i = true;
        while (i) {
            System.out.println("Введите новое количество глаз дракона");
            String string = scanner.nextLine();
            try {
                dragon.getHead().setEyesCount(Double.parseDouble(string));
                i = false;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Неверный тип данных");
            }
        }
    }
    private void updateCoordinates(Scanner scanner, Dragon dragon) {
        dragon.getCoordinates().setX(getNewXCoordinate(scanner));
        dragon.getCoordinates().setY(getNewYCoordinate(scanner));
    }
    private long getNewXCoordinate(Scanner scanner) {
        long x = 0;
        boolean i = true;
        while (i) {
            System.out.println("Введите новую координату X дракона");
            String xString = scanner.nextLine();
            try {
                if (xString.matches("([-+]?\\d+)")) {
                    x = Long.parseLong(xString);
                    if (x > 610) {
                        throw new IllegalValueOfXException();
                    } else {
                        i = false;
                    }
                } else {
                    System.out.println("Неверный тип данных");
                }
            } catch (IllegalValueOfXException illegalValueOfXException) {
                System.out.println(illegalValueOfXException.getMessage());
            }
        }
        return x;
    }
    private float getNewYCoordinate(Scanner scanner) {
        float y = 0;
        boolean i = true;
        while (i) {
            System.out.println("Введите новую координату Y дракона");
            String yString = scanner.nextLine();
            try {
                y = Float.parseFloat(yString);
                i = false;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Неверный тип данных");
            }
        }
        return y;
    }
    private String requestInput(Scanner scanner) {
        boolean i = true;
        String s = "";
        while (i) {
            System.out.println("""
                                    Выберите параметр дракона, который хотите изменить:
                                    Имя - введите  1
                                    Возраст - введите 2
                                    Тип - введите 3
                                    Цвет - введите 4
                                    Характер - введите 5
                                    Количество глаз - введите 6
                                    Координаты - введите 7""");
            s = scanner.nextLine();
            i = false;
        }
        return s;
    }
    private void fieldsUpdater(String s, Scanner scanner, Dragon dragon) {
        switch (s) {
            case "1" -> updateName(scanner, dragon);
            case "2" -> updateAge(scanner, dragon);
            case "3" -> updateType(scanner, dragon);
            case "4" -> updateColor(scanner, dragon);
            case "5" -> updateCharacter(scanner, dragon);
            case "6" -> updateHead(scanner, dragon);
            case "7" -> updateCoordinates(scanner, dragon);
        }
        System.out.println("Параметр дракона успешно изменён");
    }
    private void updateDragon(long id) {
        boolean dragonExists = false;
        for (Dragon dragon : DragonsCollection.getDragons()) {
            if (dragon.getId() == id) {
                dragonExists = true;
                Scanner scanner = new Scanner(System.in);
                String s = requestInput(scanner);
                if (!s.equals("1") && !s.equals("2") && !s.equals("3") && !s.equals("4") && !s.equals("5") && !s.equals("6") && !s.equals("7")) {
                    System.out.println("Неверный параметр");
                } else {
                    fieldsUpdater(s, scanner, dragon);
                }
            }
            if (!dragonExists) System.out.println("Такого дракона не существует");
        }
    }
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 2) {
            long id = Long.parseLong(Invoker.getSplit()[1]);
            if (!DragonsCollection.getDragons().isEmpty()) {
                updateDragon(id);
            } else {
                System.out.println("Такого дракона не существует");
            }
        } else {
            System.out.println("Неверная команда");
        }
    }

    @Override
    public String description() {
        return "update id : обновить значение элемента коллекции, id которого равен заданному";
    }
}
