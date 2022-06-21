package example;

import org.springframework.stereotype.Component;

@Component
public class Help implements Command{

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String exec() {
        String s = "";
        for (Command com: ShellManager.getCommands()){
            s = s + com.help()+'\n';
        }
        return s;
    }

    @Override
    public String help() {
        return "help - помощь";
    }
}
