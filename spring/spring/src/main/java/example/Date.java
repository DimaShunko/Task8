package example;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Date implements Command{

    @Override
    public String getName() {
        return "date";
    }

    @Override
    public String  exec() {
        return String.valueOf(LocalDate.now());
    }

    @Override
    public String help() {
        return "help - помощь";
    }
}
