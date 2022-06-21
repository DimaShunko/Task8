package example;

import org.springframework.stereotype.Component;

@Component
public class Dir implements Command{
    @Override
    public String getName() {
        return "dir";
    }

    @Override
    public String exec() {
        return ("Директоия: "+ System.getProperty("user.dir"));
    }

    @Override
    public String help() {
        return "dir - дериктория";
    }
}
