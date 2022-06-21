package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Scanner;

@Controller
public class Main {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        ShellManager shellManager = context.getBean(ShellManager.class);
        boolean commandExec;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите команду");
            String name = scanner.nextLine();
            commandExec= false;
            for(Command command: shellManager.getCommands()){
                if(command.getName().contentEquals(name)){
                    System.out.println(command.exec());
                    commandExec = true;
                    break;
                }
            }
            if(!commandExec){
                System.out.println("Такой команды нет");
            }
        }
    }
}
