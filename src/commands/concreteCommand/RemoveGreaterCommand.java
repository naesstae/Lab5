package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Invoker;
import java.util.ArrayList;
import java.util.Collections;

public class RemoveGreaterCommand implements Command {

    private void removerGreater(boolean dragonExists, Dragon thisDragon) {
        int countOfDragons = 0;
        if (dragonExists) {
            boolean isThereYoungerDragons = true;
            do {
                ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
                Collections.sort(dragons);
                Dragon dragon = Collections.max(dragons);
                if (dragon != thisDragon) {
                    DragonsCollection.getDragons().remove(dragon);
                    ++countOfDragons;
                } else {
                    isThereYoungerDragons = false;
                }
            } while (isThereYoungerDragons);
        } else {
            System.out.println("Заданного дракона не существует");
        }
        if (countOfDragons != 0) {
            System.out.println("Количество удалённых драконов " + countOfDragons);
        } else if (dragonExists) {
            System.out.println("Драконов старше заданного не существует");
        }
    }
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 2) {
            long id = Long.parseLong(Invoker.getSplit()[1]);
            boolean dragonExists = false;
            Dragon thisDragon = new Dragon("", new Coordinates(0,0), Long.parseLong("0"),Color.ORANGE, DragonType.WATER, DragonCharacter.FICKLE,new DragonHead(Double.parseDouble("0")));
            if (!DragonsCollection.getDragons().isEmpty()) {
                for (Dragon dragon : DragonsCollection.getDragons()) {
                    if (dragon.getId() == id) {
                        dragonExists = true;
                        thisDragon = dragon;
                    }
                }
                removerGreater(dragonExists, thisDragon);
            } else {
                System.out.println("Коллекция пуста, заданного дракона не существует");
            }
        } else {
            System.out.println("Неверная команда");
        }
    }
    @Override
    public String description() {
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
    }
}
