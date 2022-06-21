package example;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShellManager {
    @Autowired
    private Date date;
    @Autowired
    private Dir dir;
    @Autowired
    private Exit exit;
    @Autowired
    private Time time;
    @Autowired
    private Help help;
    private static List<Command> commands;

    ShellManager() throws IllegalAccessException, InstantiationException {
        commands = new ArrayList<>();
        init(commands);
    }

    void init(List<Command> commands) throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("example", new SubTypesScanner(false));
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class).stream().collect(Collectors.toSet());

        for (Class<?> cl : allClasses) {
            Annotation[] annotations = cl.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Component) {
                    commands.add((Command) cl.newInstance());
                }
            }
        }
    }

    public static List<Command> getCommands() {
        return commands;
    }

}
