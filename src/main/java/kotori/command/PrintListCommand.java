package kotori.command;

import kotori.taskList.TaskList;

import static kotori.Ui.Ui.printList;

/**
 * This class represents the command of printing the list.
 * */

public class PrintListCommand extends Command {
    private TaskList list;

    public PrintListCommand(TaskList list) {
        this.list = list;
    }

    /**
     * Activates the command and print the list.
     * */

    @Override
    public void execute() {
        printList(list);
    }
}
