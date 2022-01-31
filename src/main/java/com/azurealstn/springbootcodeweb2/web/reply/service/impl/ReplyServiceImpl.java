package com.azurealstn.springbootcodeweb2.web.reply.service.impl;

import com.azurealstn.springbootcodeweb2.domain.board.Board;
import com.azurealstn.springbootcodeweb2.domain.reply.Reply;
import com.azurealstn.springbootcodeweb2.domain.reply.ReplyRepository;
import com.azurealstn.springbootcodeweb2.web.reply.dto.ReplyDTO;
import com.azurealstn.springbootcodeweb2.web.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Override
    public Long register(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
        return reply.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Long bno) {
        List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());

        return result.stream().map(reply -> entityToDto(reply)).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
    }

    @Override
    public void remove(Long bno) {
        replyRepository.deleteById(bno);
    }
}
