package com.qyl.mapper;

import com.qyl.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/2/15 23:17
 * @Description:
 */
@Mapper
public interface EmpMapper {

    int addEmp(Emp emp);

    List<Emp> getEmpList();
}
