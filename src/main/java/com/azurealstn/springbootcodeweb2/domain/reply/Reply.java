package com.azurealstn.springbootcodeweb2.domain.reply;

import com.azurealstn.springbootcodeweb2.domain.BaseEntity;
import com.azurealstn.springbootcodeweb2.domain.board.Board;
import lombok.*;

import javax.persistence.*;

@ToString(exclude = "board")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
