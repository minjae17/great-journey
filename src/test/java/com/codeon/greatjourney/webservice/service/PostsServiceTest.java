package com.codeon.greatjourney.webservice.service;

import com.codeon.greatjourney.webservice.domain.PostsRepository;
import com.codeon.greatjourney.webservice.domain.PostsSaveRequestDto;
import com.codeon.greatjourney.webservice.domain.posts.Posts;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @Before
    public void setup() {
    }

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder().author("author").title("title").content("content").build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        Assert.assertEquals(posts.getAuthor(), dto.getAuthor());
        Assert.assertEquals(posts.getTitle(), dto.getTitle());
        Assert.assertEquals(posts.getContent(), dto.getContent());
    }
}
