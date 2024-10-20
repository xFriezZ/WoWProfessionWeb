package org.project.wowprofessionweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WoWProfessionWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoWProfessionWebApplication.class, args);
    }

}
