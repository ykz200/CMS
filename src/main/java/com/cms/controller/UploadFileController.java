package com.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by ykz on 2017/4/5.
 */
@Controller
@RequestMapping("/")
public class UploadFileController {
    private static Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @RequestMapping("/upload/image")
    @ResponseBody
    public String uploadImage(HttpServletRequest request,
                              HttpServletResponse response, HttpSession session,
                              @RequestParam(value = "file", required = true) MultipartFile file)
            throws IllegalStateException, IOException {
        String path = session.getServletContext().getRealPath("/uploadFile");
        System.out.println("real path: " + path);
        String fileName = file.getOriginalFilename();
        String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
        System.out.println("file name: " + fileName);
        fileName = UUID.randomUUID() + "." + type;
        File targetFile = new File(path,  fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
//        String fileUrl = request.getContextPath() + "/uploadFile/" + fileName;
        return fileName;
    }


}
