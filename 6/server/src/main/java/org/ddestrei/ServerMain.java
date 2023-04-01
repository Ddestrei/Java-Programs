package org.ddestrei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ServerMain {
    public static void main(String[] args) {
        SpringApplication.run(ServerMain.class, args);
    }
}
