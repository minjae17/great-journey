package com.codeon.greatjourney;

import com.codeon.greatjourney.webservice.domain.posts.Posts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreatJourneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreatJourneyApplication.class, args);
//        Posts post = Posts.builder().author("author").content("this is content").title("Title").build();
    }
}
