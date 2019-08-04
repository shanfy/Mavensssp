package com.yang.web.controller;

import com.yang.service.UploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author: shanfy
 * @Date: 2019/8/3 15:22
 */
@Controller
@RequestMapping("/user")
public class UploadFileController {
    @Resource(name="uploadFileService")
    private UploadFileService uploadFileService;
    //图片上传用MultipartFile接收文件,其中参数名要表单中的文件名一致
    @RequestMapping("/uploadpic")
    public String uploadPic(MultipartFile picFile) throws Exception {
        String picUrl = uploadFileService.UploadPic(picFile);
        if (picUrl == null){
            return "redirect:error.html";
        }
        //重定向预览图片
        return "redirect:"+picUrl;
    }
}
