package com.qyl.controller;

import com.qyl.utils.VerifyCodeUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: qyl
 * @Date: 2021/2/15 19:58
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 生成验证码图片接口
     * @return
     */
    @GetMapping("/getImage")
    public Map<String, Object> getImage() throws IOException {
        Map<String, Object> map = new HashMap<>();
        // 1. 生成验证码
        String code = VerifyCodeUtil.generateVerifyCode(4);
        // 2. 储存验证码 redis
        String codeKey = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(codeKey, code, 5 * 60, TimeUnit.SECONDS);

        // 3. base64转换验证码
        // 现在前端都是以base64的形式来展示图片
        // 固定形式是：{ "src":"xxx", "codeKey":"xxx" }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        VerifyCodeUtil.outputImage(120, 60, byteArrayOutputStream, code);
        // src固定格式是："data:image/png;base64,xxx"
        String data = "data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());

        // 响应数据
        map.put("src", data);
        map.put("codeKey", codeKey);
        return map;
    }
}
