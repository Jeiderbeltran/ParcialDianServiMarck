package org.mycompany.servimark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.mycompany.servimark")
public class ServiMarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiMarkApplication.class, args);
    }

}
