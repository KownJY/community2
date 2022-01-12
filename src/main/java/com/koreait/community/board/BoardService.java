package com.koreait.community.board;

import com.koreait.community.UserUtils;
import com.koreait.community.model.BoardDTO;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Object;

import java.util.List;
import java.util.Objects;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;


    @Autowired
    private UserUtils userUtils;

    public List<BoardVO> selBoardList(BoardDTO dto) {

        return mapper.selBoardList(dto);
    }

    //요기 매퍼에 한거 구현
    public int insBoard(BoardEntity entity) {
        entity.setIuser(userUtils.getLoginUserPk());
        return mapper.insBoard(entity);
    }

    public BoardVO selDetail(BoardDTO dto) {
        BoardVO detail = mapper.selDetail(dto);
        if(!Objects.equals(dto.getLastip(),detail.getLastip())){
            int hitsResult = mapper.addHits(dto);
            if(hitsResult == 1){
                detail.setHits(detail.getHits() + 1);
            }
            mapper.updBoard(dto);
        }
        return detail;
    }

    public void addHits(BoardDTO dto){
        mapper.addHits(dto);
    }

    public int delBoard(BoardEntity entity){


       entity.setIuser(userUtils.getLoginUserPk());
       entity.setIsdel(1);
            return mapper.delBoard(entity);

    }

    public int modBoard(BoardEntity entity){

        try {
            entity.setIuser(userUtils.getLoginUserPk());
            return mapper.updBoard(entity);
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }
    }

}
