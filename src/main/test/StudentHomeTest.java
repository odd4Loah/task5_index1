import com.lihoo.ssm.dao.StudentHomeMapper;
import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentHome;
import com.lihoo.ssm.model.StudentInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * #Title: StudentHomeTest
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/28-14:09
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class StudentHomeTest {

    private static Logger logger = Logger.getLogger(StudentHomeTest.class);

    @Autowired
    StudentHomeMapper studentHomeMapper;

    @Test
    public void testAllStudents() {
        logger.debug("查找所有学生");
        List<StudentHome> list = studentHomeMapper.selectAll();

        for (StudentHome allStus :
                list) {
            logger.debug(allStus);
        }

        logger.debug("查询结束");
    }

    @Test
    public void testFindById() {
        logger.debug("通过ID查找");
        StudentHome stu = studentHomeMapper.selectByPrimaryKey(1L);
        logger.debug(stu);
        logger.debug("查询结束");

    }

    @Test
    public void testCountAll() {
        logger.debug("开始查询");
        int list = studentHomeMapper.countAll();
        logger.debug(list);
        logger.debug("总人数为：" + list );
    }

    @Test
    public void testWorkingCounts() {
        logger.debug("查询就业人数");
        int workList = studentHomeMapper.workingCount();
        logger.debug(workList);
        logger.debug("已经就业人数为：" + workList + "人");
    }

    @Test
    public void testGreatStudents() {
        logger.debug("查询优秀学员");
        List<StudentHome> greatList = studentHomeMapper.selectGreatStudent();

//        String i = greatList.toString();
//        logger.debug("mySOS:" + i );

        for (StudentHome list : greatList) {
            logger.debug(list);
            logger.debug(list.getHeadImg());
            logger.debug(list.getUsername());
            logger.debug(list.getUserInfo());
        }

//        logger.debug(l);
        logger.debug("查询成功");
    }

    @Autowired
    StudentInfoMapper studentInfoMapper;

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

        logger.debug("通过密码查找出信息::" + withUsername);
        logger.debug("$$$$$$$$$$$$$$$$$");
    }
}
