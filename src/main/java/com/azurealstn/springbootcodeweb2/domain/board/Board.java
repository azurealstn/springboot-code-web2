package com.azurealstn.springbootcodeweb2.domain.board;

import com.azurealstn.springbootcodeweb2.domain.BaseEntity;
import com.azurealstn.springbootcodeweb2.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@ToString(exclude = "writer")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }
}
