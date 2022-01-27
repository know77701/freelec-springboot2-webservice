package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
// 테이블과 링크될 클래스임을 명시
@Entity
public class Posts extends BaseTimeEntity {
    // 해당테이블의 PK 필드 여기서는 id값이 pk
    @Id
    // auto_increment 적용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 해당 클래스의 필드는 모두 컬럼
    // 기본값이외의 추가로 변경이 필요할 때 사용할 어노테이션
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //빌더 패턴 클래스 생성
    @Builder
    public Posts(String title, String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
