package com.koreait.community.user;

import com.koreait.community.Const;
import com.koreait.community.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private HttpSession hs;

    @GetMapping("/login")
    public void login() {
    }

    @PostMapping("/login")
    public String login(UserEntity entity, RedirectAttributes reAttr) {
        int result = service.selUser(entity);

        if (result != 1) {
            switch (result) {
                case 0:
                    reAttr.addFlashAttribute(Const.MSG, Const.ERR_1);
                    reAttr.addFlashAttribute("remainId", entity.getUid());
                    break;
                case 2:
                    reAttr.addFlashAttribute("msg", "아이디를 확인해주세요");
                    reAttr.addFlashAttribute("remainId", entity.getUid());
                    break;
                case 3:
                    reAttr.addFlashAttribute("msg", "비번을 확인해주세여");
                    reAttr.addFlashAttribute("remainId", entity.getUid());
                    break;
            }

            return "redirect:/user/login";


        }

        return "redirect:/board/list";

        //로그인에 실패햇을 때 아이디는 유지되도록 하고싶다.
    }


    @GetMapping("/join")
    public void join() {
    }

    @PostMapping("/join")
    public String join(UserEntity entity,RedirectAttributes reAttr) {

        int result = service.userJoin(entity);
        if(result == 0){
            reAttr.addFlashAttribute("msg","회원가입에 실패;;");
            return "redirect:/user/login";
        }
        service.selUser(entity);
        return "redirect:/board/list/1";
    }


    @GetMapping("/idChk/{uid}")
    @ResponseBody //@ResponseBody 이거 하나만 적으면 리턴이 제이슨이된대. //받을때는 리퀘스트바디래
    public Map<String, Integer> idChk(@PathVariable String uid) {
        //@PathVariable자동으로 매핑해준다고??
        System.out.println("uid :" + uid);
        Map<String, Integer> res = new HashMap<>();
        res.put("result", service.idChk(uid));
        return res;
    }

    @GetMapping("/logout")
    public String logout(HttpSession hs){
        hs.invalidate();
        return "redirect:/user/login";
    }

    @GetMapping("/mypage/profile")
    public void mypageProfile(){}

    @ResponseBody
    @PostMapping("/mypage/profile")
    public Map<String, String> mypageProfileProc(MultipartFile profileimg){
       String fileNm =service.uploadProfileImg(profileimg);
        Map<String,String> result = new HashMap<>();

        UserEntity entity = (UserEntity) hs.getAttribute(Const.LOGIN_USER);
        entity.setProfileimg(fileNm);
        hs.setAttribute(Const.LOGIN_USER,entity);
        result.put("result",fileNm);
        return result;
    }
}

//세상만사 하기싫다 구찬타 자살해야겟다
