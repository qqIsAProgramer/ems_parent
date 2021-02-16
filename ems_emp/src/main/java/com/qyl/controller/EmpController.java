package com.qyl.controller;

import com.qyl.client.FileClient;
import com.qyl.entity.Emp;
import com.qyl.service.EmpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qyl
 * @Date: 2021/2/15 22:51
 * @Description:
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Resource
    private EmpService empService;
    
    @Resource
    private FileClient fileClient;
    
    @PostMapping("/add")
    public Map<String, Object> addEmp(Emp emp, MultipartFile photo) {
        Map<String, Object> map = new HashMap<>();

        Map<String, Object> result = fileClient.upload(photo);
        // 保存头像路径
        emp.setAvatar(result.get("url").toString());
        empService.addEmp(emp);

        map.put("state", 1);
        map.put("msg", "ok");
        return map;
    }

    @GetMapping("/list")
    public Map<String, Object> getEmpList() {
        List<Emp> empList = empService.getEmpList();
        System.out.println(empList);
        Map<String, Object> map = new HashMap<>();
        map.put("state", 1);
        map.put("msg", "ok");
        map.put("data", empList);
        return map;
    }
}
