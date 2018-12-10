package com.codeon.greatjourney.webservice.domain;

import com.codeon.greatjourney.webservice.domain.PostsRepository;
import com.codeon.greatjourney.webservice.domain.posts.Posts;
import com.codeon.greatjourney.webservice.domain.posts.Posts;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void save_and_load_content() {
        //given
        postsRepository.save(Posts.builder().title("title").author("John").content("This is the post").build());

        //when
        List<Posts> list = postsRepository.findAll();

        //then
        Posts posts = list.get(0);
        Assert.assertEquals(posts.getTitle(), "title");
        Assert.assertEquals(posts.getAuthor(), "John");
    }

    @Test
    public void BaseTimeEntity_register() {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        Assert.assertTrue(posts.getCreatedDate().isAfter(now));
        Assert.assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
