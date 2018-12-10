package com.codeon.greatjourney.webservice;

import com.codeon.greatjourney.webservice.domain.PostsRepository;
import com.codeon.greatjourney.webservice.domain.PostsSaveRequestDto;
import com.codeon.greatjourney.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private PostsRepository postsRepository ;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}