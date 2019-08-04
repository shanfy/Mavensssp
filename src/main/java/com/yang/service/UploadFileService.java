package com.yang.service;

import com.yang.dao.UploadFileDao;
import com.yang.entity.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: shanfy
 * @Date: 2019/8/3 15:22
 */
@Service("uploadFileService")
public class UploadFileService {
    @Autowired
    private UploadFileDao uploadFileDao;

    public String UploadPic(MultipartFile picFile) {
        try {
            // 图片新名字
            String name = UUID.randomUUID().toString();
            // 图片原名字
            String oldName = picFile.getOriginalFilename();
            // 后缀名
            String exeName = oldName.substring(oldName.lastIndexOf("."));
            //保存图片路径为绝对路径
            File pic = new File("D:/workspace/ideaspace/Mavensssp/src/main/webapp/jpg/" + name + exeName);
            // 保存图片到本地磁盘
            picFile.transferTo(pic);

            //保存数据到数据库中
            uploadFileDao.save(new Pic(name,"../jpg/"+name+exeName));
            return "/jpg/"+name+exeName;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
