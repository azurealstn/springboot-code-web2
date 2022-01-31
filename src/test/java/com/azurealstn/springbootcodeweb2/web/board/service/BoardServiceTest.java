package com.azurealstn.springbootcodeweb2.web.board.service;

import com.azurealstn.springbootcodeweb2.web.board.dto.BoardDTO;
import com.azurealstn.springbootcodeweb2.web.cmmn.dto.PageRequestDTO;
import com.azurealstn.springbootcodeweb2.web.cmmn.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void testRegister() {
        BoardDTO dto = BoardDTO.builder()
                .title("Test.")
                .content("Test...")
                .writerEmail("user55@aaa.com")
                .build();

        Long bno = boardService.register(dto);
    }

    @Test
    void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
        for (BoardDTO boardDTO : result.getDtoList()) {
            System.out.println(boardDTO);
        }
    }

    @Test
    void testGet() {
        Long bno = 100L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }

    @Test
    void testRemove() {
        Long bno = 1L;
        boardService.removeWithReplies(bno);
    }

    @Test
    void testModify() {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(2L)
                .title("변경된 제목")
                .content("변경된 내용")
                .build();
        boardService.modify(boardDTO);
    }

}