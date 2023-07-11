package com.example.Alpha.Service.AdminService;

import com.alibaba.fastjson.JSONArray;
import com.example.Alpha.Bean.ImgBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class EditorUploadService {
    @Value("${url}")
    String root;

    @Value("${imgurl}")
    String imgUrl;
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

    public ImgBean upLoadImg(MultipartFile file) {
        File useFile = new File(root);

        if (!useFile.exists()) {
            useFile.mkdirs();
        }

        String timeFormat = sdf.format(new Date());

        File timeDirFile = new File(root + timeFormat + "/");

        if (!timeDirFile.isDirectory()) {

            timeDirFile.mkdirs();

        }
        String oldName = file.getOriginalFilename().replaceAll("\\s+", "");;
        String newName = UUID.randomUUID().toString() + "_" + oldName;

        try {
            ImgBean imgBean = new ImgBean();
            file.transferTo(new File(timeDirFile, newName));
            String nowPath = root + timeFormat + "/" + newName;
            imgBean.setNameImg(newName);
            imgBean.setSize(file.getSize());
            imgBean.setPath(imgUrl + timeFormat + "/" + newName);
            imgBean.setType(file.getContentType());
            return imgBean;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public Boolean delateImg(String[] imgarr) {


        for (int i=0;i<imgarr.length;i++){


            String imgPath = imgarr[i].substring(imgarr[i].indexOf("EditorImg/") + "EditorImg/".length());

            // 创建一个File对象
            File file = new File(root+imgPath);

            // 如果文件存在，就删除它
            if (file.exists()) {
                file.delete();
            } else {
                System.out.println("文件不存在。");
            }

        }

        return true;


    }


}
