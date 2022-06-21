package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Help implements Command{
    @Autowired
    private Set<Command> commands;


    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String exec() {
        String s = "";
        for (Command com: commands){
            s = s + com.help()+'\n';
        }
        return s;
    }

    @Override
    public String help() {
        return "help - помощь";
    }
}
