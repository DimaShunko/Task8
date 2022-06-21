package example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    Command getDate() {
        return new Date();
    }

    @Bean
    Command getDir() {
        return new Dir();
    }

    @Bean
    Command getExit() {
        return new Exit();
    }

    @Bean
    Command getHelp() {
        return new Help();
    }

    @Bean
    Time getTime() {
        return new Time();
    }

    @Bean
    ShellManager getShellManager() throws IllegalAccessException, InstantiationException {
        return new ShellManager();
    }
}
