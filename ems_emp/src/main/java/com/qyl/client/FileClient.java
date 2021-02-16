package com.qyl.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: qyl
 * @Date: 2021/2/15 23:24
 * @Description:
 */
@FeignClient("files")
public interface FileClient {

    /**
     * 调用文件上传服务（微服务间的通信）
     * 注意：使用 openfeign 传递参数含有文件类型时必须指定 consumes = MediaType.MULTIPART_FORM_DATA_VALUE
     * @param photo
     * @return
     */
    @PostMapping(value = "/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String, Object> upload(@RequestPart("photo") MultipartFile photo);
}
