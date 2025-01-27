package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;
import java.util.ArrayList;
import java.util.Collections;

public class PrintAscendingCommand implements Command {

    private void ascendingPrinter() {
        ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
        Collections.sort(dragons);
        for (Dragon dragon : dragons) {
            System.out.println(dragon);
        }
    }
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 1) {
            if (DragonsCollection.getDragons().size() == 0) {
                System.out.println("Коллекция пуста");
            } else {
                ascendingPrinter();
            }
        } else {
            System.out.println("Неверная команда");
        }
    }
    @Override
    public String description() {
        return "print_ascending : вывести элементы коллекции в порядке возрастания";
    }
}
