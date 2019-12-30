package com.project.news.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class ImgUtil {

    public static String uploadImg(MultipartFile multipartFile) {
        String baseImg = null;
        try {


            final Base64.Encoder encoder = Base64.getEncoder();

            String[] suffix = multipartFile.getOriginalFilename().split("\\.");

            String preffix = "data:image/jpg;base64,".replace("jpg", suffix[suffix.length - 1]);
            byte[] bytes = multipartFile.getBytes();
            baseImg = preffix + encoder.encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseImg;
    }
}
