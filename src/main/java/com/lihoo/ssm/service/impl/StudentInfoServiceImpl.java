package com.lihoo.ssm.service.impl;

import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * #Title: StudentInfoServiceImpl
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-9:35
 */

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StudentInfo> selectAll() {
        return studentInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StudentInfo record) {
        return studentInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(StudentInfo record) {
        return studentInfoMapper.insert(record);
    }

    @Override
    public StudentInfo selectByPrimaryKey(Long id) {
        return studentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public StudentInfo selectByUsername(String username) {
        return studentInfoMapper.selectByUsername(username);
    }

    @Override
    public StudentInfo selectByPwd(String pwd) {
        return studentInfoMapper.selectByPwd(pwd);
    }
}
