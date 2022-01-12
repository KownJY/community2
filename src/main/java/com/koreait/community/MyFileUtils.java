package com.koreait.community;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
public class MyFileUtils {
    //폴더 만들기..
    public void makeFolders(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    //폴더 삭제는 쓸 일이 거의 없으나 그래도 만들자
    //폴더 안에 이미지가 있으면 지울 수가 없으니 이미지부터 몽땅 지우고 폴더를 지워야 합니다.
    //아래 코드는 폴더는 지우기 싫으나 이미지만 전부 지우고 싶을 때도 이용가능하다.

    public void delFolderFiles(String path, boolean isDelFolder) {
        File file = new File(path); //폴더이던 이미지이던 파일 객체로 만들어져 순서대로 배열에 들어갈것입니다.
        if (file.exists() && file.isDirectory()) {
            File[] fileArr = file.listFiles();
            if (fileArr != null) {
                for (File f : fileArr) {
                    if (f.isDirectory()) { //재귀처리
                        delFolderFiles(f.getPath(), true); //자기 자신을 삭제한다.
                    } else {
                        f.delete();
                    }
                }
            }
        }

        if (isDelFolder) {
            file.delete();
        }
    }


    //랜덤 파일명 만들기
    public String getRandomFileNm(){
        return UUID.randomUUID().toString();
    }

    //.확장자는 그대로 쓰고 파일 명만 바꿔주는 메소드.
    public String getRandomFileNm(String fileNm){
        return getRandomFileNm() + getExt(fileNm);
    }

    //확장자 구하기
    public String getExt(String fileNm){
//      return fileNm.substring(fileNm.lastIndexOf('.'));
        int lastIdx = fileNm.lastIndexOf(".");
        return fileNm.substring(lastIdx);
    }

    //파일저장하기 -> 저장 된 랜덤 파일명을 리턴.
    public String saveFile(String path, MultipartFile mf){
        makeFolders(path); //폴더만들고
        String randomfileNm = getRandomFileNm(mf.getOriginalFilename()); //랜덤한 파일명 얻어오고

        File targetFile = new File(path, randomfileNm);

        try {
            mf.transferTo(targetFile);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return randomfileNm;

    }

}
