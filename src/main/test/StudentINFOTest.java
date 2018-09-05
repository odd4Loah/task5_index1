import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.util.MD5Encryption;
import com.lihoo.ssm.util.MD5Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static Logger logger = LogManager.getLogger(StudentINFOTest.class);

    @Autowired
    StudentInfoMapper studentInfoMapper;

//    @Test
//    public void testPwd() {
//        logger.info("开始查询密码");
//        String password = studentInfoMapper.getPwd();
//        logger.info(password);
//    }

    @Test
    public void testFindwithPwd() {
        logger.info("开始***");
        StudentInfo withPwd = studentInfoMapper.selectByPwd("123");

        logger.info("通过密码查找出信息::" + withPwd);
        logger.info("李浩:查询结束");



        logger.info("我是新来的打印日志选手，请多多指教！！！log4j2");
        logger.info("log4j2*******");
    }

    @Test
    public void testFindwithUsername() {
        logger.info("$$$$$$$$$$$$$$$$$");
        StudentInfo  withUsername = studentInfoMapper.selectByUsername("123");

        logger.info("通过用户名查找出信息::" + withUsername);
        logger.info("通过用户名查找出信息::" + withUsername.getSalt());
        logger.info("$$$$$$$$$$$$$$$$$");
    }

    @Test
    public void testAddUser() throws UnsupportedEncodingException {
        logger.info("开始注册用户");

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

        logger.info(uInfo);
        logger.info("添加成功");

    }

    @Test
    public void testFindAll() {
        logger.info("获取数据库表中全部用户信息");
        List<StudentInfo> studentList = studentInfoMapper.selectAll();
        for (StudentInfo list : studentList) {
            logger.info("数据库用户信息：" + list);
        }

        logger.info( "用户信息：" + studentList);
    }
}
