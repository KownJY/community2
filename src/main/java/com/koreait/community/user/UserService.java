package com.koreait.community.user;

import com.koreait.community.Const;
import com.koreait.community.MyFileUtils;
import com.koreait.community.UserUtils;
import com.koreait.community.model.UserEntity;
import org.springframework.beans.BeanUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private MyFileUtils myFileUtils;

    public int idChk(String uid) {

        //아이디잇으면 리턴 0 없으면 1
        UserEntity entity = new UserEntity();
        entity.setUid(uid);
        UserEntity result = mapper.selUser(entity);

        return result == null ? 1 : 0;
    }

    public int userJoin(UserEntity entity) {
        //비밀번호 암호화
//        String hashPw = BCrypt.hashpw(entity.getUpw(), BCrypt.gensalt());
//        entity.setUpw(hashPw);
//        return mapper.insUser(entity);

        UserEntity copyEntity = new UserEntity();
        BeanUtils.copyProperties(entity, copyEntity);

        String hashPw = BCrypt.hashpw(copyEntity.getUpw(), BCrypt.gensalt());
        copyEntity.setUpw(hashPw);
        return mapper.insUser(copyEntity);
    }

    public int selUser(UserEntity entity) {
        UserEntity loginUser = null;

        try {
            loginUser = mapper.selUser(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0; //에러발생
        }

        if (loginUser == null) {
            return 2; //아이디가 존재하지 않는다.
        } else if (!BCrypt.checkpw(entity.getUpw(), loginUser.getUpw())) {

            return 3; //비번틀림
        }

        loginUser.setUpw(null);
        loginUser.setMdt(null);
        loginUser.setRdt(null); //이 세개 지워주면 메모리상 좋다
        userUtils.setLoginUser(loginUser); //세션에 박아주고
        return 1;
    }

    //이미지 업로드 처리 및 저장 파일명 리턴
    public String uploadProfileImg(MultipartFile mf) {
        if (mf == null) {
            return null;
        }
        final String PATH = Const.UPLOAD_IMG_PATH + "/user/" + userUtils.getLoginUserPk();
        String fileNm = myFileUtils.saveFile(PATH, mf);
        System.out.println("^-^fileNm :" + fileNm + "^~^");

        if (fileNm == null) {
            return null;
        }

        //파일명을 t_user 테이블에 update 해주
        UserEntity entity = new UserEntity();
        entity.setIuser(userUtils.getLoginUserPk());
        entity.setProfileimg(fileNm);
        mapper.updUser(entity);

        return fileNm;
    }
}

