package example;

import org.springframework.stereotype.Component;

@Component
public class Exit implements Command{
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String exec() {
        System.exit(0);
        return ("Выход");

    }

    @Override
    public String help() {
        return "exit - выход";
    }
}
