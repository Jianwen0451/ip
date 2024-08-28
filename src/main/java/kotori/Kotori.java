package kotori;

import kotori.command.Command;
import kotori.parser.Parser;
import kotori.storage.Storage;
import kotori.taskList.TaskList;
import kotori.command.ExitCommand;
import kotori.command.GreetCommand;

import java.util.Scanner;

public class Kotori {
    private Storage storage;
    private TaskList list;
    private Parser parser;

    public Kotori () {
        this.storage = new Storage("data", "Kotori.txt");
        this.list = storage.load();
        this.parser = new Parser(storage, list);
    }

    public void run() {
        Scanner s = new Scanner(System.in);
        new GreetCommand().execute();
        while (s.hasNextLine()) {
            Command command = parser.parse(s.nextLine());
            command.execute();
            if (command instanceof ExitCommand) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Kotori().run();
    }
}


