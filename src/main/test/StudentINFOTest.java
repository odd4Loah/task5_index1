import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.util.MD5Encryption;
import com.lihoo.ssm.util.MD5Utils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * #Title: StudentINFOTest
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-15:38
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class StudentINFOTest {
    private static Logger logger = Logger.getLogger(StudentINFOTest.class);

    @Autowired
    StudentInfoMapper studentInfoMapper;

//    @Test
//    public void testPwd() {
//        logger.debug("开始查询密码");
//        String password = studentInfoMapper.getPwd();
//        logger.debug(password);
//    }

    @Test
    public void testFindwithPwd() {
        logger.debug("开始***");
        StudentInfo withPwd = studentInfoMapper.selectByPwd("123");

        logger.debug("通过密码查找出信息::" + withPwd);
        logger.debug("李浩:查询结束");
    }

    @Test
    public void testFindwithUsername() {
        logger.debug("$$$$$$$$$$$$$$$$$");
        StudentInfo  withUsername = studentInfoMapper.selectByUsername("123");

        logger.debug("通过用户名查找出信息::" + withUsername);
        logger.debug("通过用户名查找出信息::" + withUsername.getSalt());
        logger.debug("$$$$$$$$$$$$$$$$$");
    }

    @Test
    public void testAddUser() throws UnsupportedEncodingException {
        logger.debug("开始注册用户");

        StudentInfo uInfo = new StudentInfo();

        uInfo.setUsername("root010");
        uInfo.setSalt(MD5Encryption.saltInDB());
        uInfo.setPwd(MD5Encryption.md5_salt("000000"));
//        uInfo.setPwd(MD5Utils.encryptPwd("123456", "x8s5d4f1"));
//        uInfo.setPwd(MD5Encryption.getEncryption("buquhuisi4835"));
        uInfo.setCreateAt(1534655854000L);
        uInfo.setExpireAt(1534666995000L);
        uInfo.setEmail("ojbk@163.com");
        uInfo.setAddress("劲松一区");
        uInfo.setPhone(0L);
        uInfo.setQq(0L);
        uInfo.setStatus(1);
        studentInfoMapper.insert(uInfo);

        logger.debug(uInfo);
        logger.debug("添加成功");

    }

    @Test
    public void testFindAll() {
        logger.debug("获取数据库表中全部用户信息");
        List<StudentInfo> studentList = studentInfoMapper.selectAll();
        for (StudentInfo list : studentList) {
            logger.debug("数据库用户信息：" + list);
        }

        logger.debug( "用户信息：" + studentList);
    }
}
