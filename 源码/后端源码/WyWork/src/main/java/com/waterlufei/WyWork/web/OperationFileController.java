package com.waterlufei.WyWork.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class OperationFileController {
    /** 文件上传*/
    @PostMapping("uploadPictures")
    public void upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println(realPath);
        String folder = "D:\\down\\nginx-1.14.2\\html\\images";
        File localFile = new File(folder, file.getOriginalFilename());
        file.transferTo(localFile);
    }
}
