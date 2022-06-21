package example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        ShellManager shellManager = context.getBean(ShellManager.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду");
            String name = scanner.nextLine();
            shellManager.doShell(name);
        }
    }
}
