package com.koreait.community.board;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.koreait.community.Const;
import com.koreait.community.model.BoardDTO;
import com.koreait.community.model.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list/{icategory}")
    public String list(@PathVariable int icategory, BoardDTO dto, Model model) {
        model.addAttribute(Const.I_CATEGORY, icategory);
        model.addAttribute(Const.LIST, service.selBoardList(dto));
        dto.setIcategory(icategory);
        return "board/list";

    }

    @GetMapping("/write")
    public void write() {
    }

    // 포스트 라이트 추가


    @PostMapping("/write")
    public String write(BoardEntity entity) {
        int result = service.insBoard(entity);
        return "redirect:/board/list/" + entity.getIcategory();
    }

    @GetMapping("/detail")
    public void detail(Model model, BoardDTO dto, HttpServletRequest req) {

        String lastIp = req.getHeader("X-FORWARDED-FOR");
        if(lastIp == null){
            lastIp = req.getRemoteAddr();
        }


        System.out.println("lastip is " +lastIp);
        dto.setLastip(lastIp);
        model.addAttribute("data", service.selDetail(dto));
    }

    @GetMapping("/mod")
    public String mod(BoardDTO dto,Model model){
        model.addAttribute("data",service.selDetail(dto));
        return "board/write";
    }

    @PostMapping("/mod")
    public String modProc(BoardEntity entity) {
        int result = service.modBoard(entity);
        return "redirect:/board/detail?iboard=" + entity.getIboard();
    }

    @GetMapping("/del")
    public String delProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.delBoard(entity);

        return "redirect:/board/list" + entity.getIcategory();
    }

}
