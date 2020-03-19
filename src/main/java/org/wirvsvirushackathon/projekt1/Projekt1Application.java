package org.wirvsvirushackathon.projekt1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.wirvsvirushackathon.projekt1.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Projekt1Application {

    public static void main(String[] args) {
        SpringApplication.run(Projekt1Application.class, args);
    }

}
