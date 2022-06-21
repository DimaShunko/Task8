package example;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Time implements Command{
    @Override
    public String getName() {
        return "time";
    }

    @Override
    public String exec() {
        return String.valueOf(LocalTime.now());
    }

    @Override
    public String help() {
        return "time - Московское время";
    }
}
