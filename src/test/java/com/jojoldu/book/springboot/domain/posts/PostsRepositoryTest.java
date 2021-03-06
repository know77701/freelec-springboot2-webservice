package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRe;

    @After
    public void cleanup(){
        postsRe.deleteAll();
    }

    @Test
    public void Load(){
        //given
        String title = "게시글";
        String content = "본문";

        postsRe.save(Posts.builder()
                .title(title)
                .content(content)
                .author("@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRe.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);

        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity(){
        //given
        LocalDateTime now = LocalDateTime.of(2022,1,27,0,0,0);
        postsRe.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRe.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println("CreateDate = "+ posts.getCreatedDate()+" modifiedDate = " + posts.getModifiedDate());

    }

}
