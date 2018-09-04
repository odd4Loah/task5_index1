package com.lihoo.ssm.controller;

import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentHome;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.model.StudentProfession;
import com.lihoo.ssm.service.StudentHomeService;
import com.lihoo.ssm.service.StudentInfoService;
import com.lihoo.ssm.service.StudentProfessionService;
import com.lihoo.ssm.util.AddSalt;
import com.lihoo.ssm.util.MD5Encryption;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.lihoo.ssm.util.AddSalt.getSalt;
import static com.lihoo.ssm.util.MD5Encryption.*;
import static com.lihoo.ssm.util.MD5Utils.getPwdHash;

/**
 * #Title: IndexController
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/28-15:18
 * @author lihoo
 */

@Controller
@RequestMapping("")
public class IndexController {
//    打印日志
    private static Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    StudentInfoService studentInfoService;

    /**
     请求注册数据
     */
    @RequestMapping(value ="/join", method = RequestMethod.GET)
    public String joinForm() {
        logger.debug("join GET 方法被调用……");
        return "join.pa";
    }

    /**
     注册
     */
    @RequestMapping(value ="/join", method = RequestMethod.POST)
    public String join(@RequestParam("username") String username,
                       @RequestParam("pwd") String pwd) {
        logger.debug("开始...");
        logger.debug("join POST 方法被调用……");
        String salt = getSalt();
        String pwdHash = getPwdHash(pwd, salt);
////        创建StudentInfo对象
        StudentInfo joinUser = new StudentInfo();
        joinUser.setUsername(username);
        joinUser.setSalt(salt);
        joinUser.setPwd(pwdHash);
        studentInfoService.insert(joinUser);
        logger.debug("打印添加的用户信息: " + "用户名:"+username+"密码:"+pwd);
        logger.debug("打印添加的用户信息: " + joinUser);

        return "main.home";
    }

    /**
     请求直接登陆页面
     */
    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String loginForm() {
        logger.debug("login GET 方法被调用……");
        return "login.pa";
    }


    /**
     登陆
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "pwd",required = false) String pwd,
                        Model model) {
//        查：全部数据
//        logger.debug("获取数据库表中全部用户信息");
        List<StudentInfo> studentList = studentInfoService.selectAll();
//        for (StudentInfo list : studentList) {
//            logger.debug("数据库用户信息：" + list);
//            logger.debug("用户名：" + list.getUsername() + "密码：" + list.getPwd() + "盐：" + list.getSalt());
//        }
//        验证用户名是否在数据库中

//        通过用户名取出本条数据
//        StudentInfo withUsername = studentInfoService.selectByUsername(username);
//        logger.debug(withUsername);
////        获取数据库中的盐
//        String dbSalt = withUsername.getSalt();
//        logger.debug("数据库中的盐:"+ dbSalt);
////        本次输入的密码
//        logger.debug("****本次输入的密码****");
//        logger.debug("登录名："+ username +" 密码："+ pwd);
////        获取数据库中的密码
//        String dbPwd = withUsername.getPwd();
//        logger.debug("****数据库中取出来的密码****");
//        logger.debug("数据库中的密码:"+ dbPwd);
//        logger.debug("登录名："+ username +" 密码："+ dbPwd);

//                数据库中取出来的salt
//        String salt = withUsername.getSalt();
//        logger.debug("****数据库中取出来的salt****");
//        logger.debug("登录名："+ username +" 密码："+ salt);
//                将输入的密码MD5加盐之后的密码
//        String loginPwdHash = getPwdHash(pwd, salt);
//        logger.debug("****将输入的密码, MD5加盐之后的密码****");
//        logger.debug("登录名："+ username +" 密码："+ loginPwdHash);
//        验证用户输入密码是否与数据库保存密码一致
//        Boolean isPwdSame =  withUsername.getPwd().equals(loginPwdHash);
//        logger.debug("验证用户输入密码是否与数据库保存密码一致: "+ isPwdSame);

        StudentInfo loginUser = new StudentInfo();
        loginUser.setUsername(username);
        logger.debug("皮皮虾用户名："+username);
        loginUser.setPwd(pwd);
        logger.debug("输入的密码："+pwd);
        Boolean isPwdSame = studentInfoService.verifyPwd(loginUser);
        logger.debug(isPwdSame);
//        到集合中查找用户是否存在
        for (StudentInfo stuInfo : studentList) {
            if (stuInfo.getUsername().equals(username) && isPwdSame) {
                model.addAttribute("stuInfo", stuInfo);
                logger.debug("登录成功！！！！");
                return "main.home";
            }
        }
        logger.debug("数据库匹配用户名&密码####失败####");
        return "error.pa";
    }


    @Autowired
    StudentHomeService studentHomeService;
//  主页
    @RequestMapping("/index")
    public String home(Model model) {
        List<StudentHome> selectGreatStudent = studentHomeService.selectGreatStudent();
        int countAll = studentHomeService.countAll();
        int workingCount = studentHomeService.workingCount();


        model.addAttribute("selectGreatStudent", selectGreatStudent);
        model.addAttribute("countAll", countAll);
        model.addAttribute("workingCount", workingCount);

        return "main.home";
    }

    @Autowired
    StudentProfessionService studentProfessionService;
//  职业
    @RequestMapping("/profession")
    public String profession(Model model) {
        List<StudentProfession> selectAll = studentProfessionService.selectAll();
        int countAll = studentProfessionService.countAll();

        model.addAttribute("selectAll", selectAll);
        model.addAttribute("countAll", countAll);

        return "profession.home";
    }
//  推荐
    @RequestMapping("/recommend")
    public String recommend(Model model, ModelMap modelMap) {

        return "recommend.home";
    }


}
