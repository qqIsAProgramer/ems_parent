package com.qyl.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: qyl
 * @Date: 2021/2/15 23:32
 * @Description:
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${upload.dir}")
    private String realPath;

    @Value("${server.port}")
    private int port;

    /**
     * 上传头像文件
     * @param photo
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Map<String, Object> upload(MultipartFile photo) throws IOException {
        Map<String, Object> map = new HashMap<>();
        // 1. 修改文件名
        String ext = FilenameUtils.getExtension(photo.getOriginalFilename());
        String newFilename = UUID.randomUUID().toString() + "." + ext;
        // 2. 文件上传
        photo.transferTo(new File(realPath, newFilename));

        // 3. 返回url
        String url = "http://localhost:" + port + "/" + newFilename;
        map.put("state", 1);
        map.put("url", url);
        return map;
    }
}
