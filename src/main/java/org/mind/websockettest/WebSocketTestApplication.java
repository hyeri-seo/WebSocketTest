package org.mind.websockettest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.mind.websockettest.domain.repository")
@EnableMongoRepositories(basePackages = "org.mind.websockettest.domain.mongo")
public class WebSocketTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketTestApplication.class, args);
    }

}
