package com.codeon.greatjourney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class GreatJourneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreatJourneyApplication.class, args);
//        Posts post = Posts.builder().author("author").content("this is content").title("Title").build();
    }
}
