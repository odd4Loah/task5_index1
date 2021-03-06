package com.lihoo.ssm.service;

import com.lihoo.ssm.model.StudentHome;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SuppressWarnings("unused")
public interface StudentHomeService {
    //    查询优秀学员
    List<StudentHome> selectGreatStudent();

    //    通过ID查找学生
    StudentHome selectByPrimaryKey(Long id);

    //    已就业人数
    int workingCount();

    //    总人数
    int countAll();

    //    查询所有学员
    List<StudentHome> selectAll();

}
