package com.qyl.service.impl;

import com.qyl.entity.Emp;
import com.qyl.mapper.EmpMapper;
import com.qyl.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/2/15 23:20
 * @Description:
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }

    @Override
    public List<Emp> getEmpList() {
        return empMapper.getEmpList();
    }
}
