package com.codeon.greatjourney.webservice.domain;

import com.codeon.greatjourney.webservice.domain.posts.Posts;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String author;
    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}
