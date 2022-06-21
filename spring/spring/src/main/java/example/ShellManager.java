package example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShellManager {

    @Autowired
    private Set<Command> commands;

    public void doShell(String name) {
        boolean commandExec = false;
        for (Command command : commands) {
            if (command.getName().contentEquals(name)) {
                System.out.println(command.exec());
                commandExec = true;
                break;
            }
        }
        if (!commandExec) {
            System.out.println("Такой команды нет");
        }
    }

}
