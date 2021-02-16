package com.qyl.service;

import com.qyl.entity.Emp;

import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/2/15 23:20
 * @Description:
 */
public interface EmpService {

    void addEmp(Emp emp);

    List<Emp> getEmpList();
}
