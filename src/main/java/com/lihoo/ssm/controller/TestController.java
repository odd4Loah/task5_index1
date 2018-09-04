package com.lihoo.ssm.controller;

import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.lihoo.ssm.util.AddSalt.getSalt;
import static com.lihoo.ssm.util.MD5Utils.getPwdHash;

/**
 * #Title: TestController
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/4-9:46
 */


public class TestController {

//    @Autowired
//    StudentInfoService studentInfoService;
//
//////    进入注册页面
////    @RequestMapping(value = "/registerform")
////    public String registerform(Model model) {
////        model.addAttribute("studentInfo", new StudentInfo());
////        return "join.pa";
////    }
////
//////    注册请求的响应方法
////    @RequestMapping(value = "/register")
////    public String register(@ModelAttribute("studentInfo") StudentInfo studentInfo, Model model) {
////        model.addAttribute("studentInfo", studentInfo);
////        return "success.home";
////    }
//
//    @RequestMapping(value ="/join", method = RequestMethod.GET)
//    public String joinForm() {
//        logger.debug("join GET 方法被调用……");
//        return "join.pa";
//    }
//
//    //    注册
//    @RequestMapping(value ="/join", method = RequestMethod.POST)
//    public String join(@RequestParam("username") String username,
//                       @RequestParam("pwd") String pwd) {
//        logger.debug("开始...");
//        logger.debug("join POST 方法被调用……");
//
//        String salt = getSalt();
//        String pwdHash = getPwdHash(pwd, salt);
//
////        创建StudentInfo对象
//        StudentInfo joinUser = new StudentInfo();
//
//        joinUser.setUsername(username);
//        joinUser.setSalt(salt);
//        joinUser.setPwd(pwdHash);
//
//        studentInfoService.insert(joinUser);
//
//        logger.debug("打印添加的用户信息: " + "用户名:"+username+"密码:"+pwd);
//        logger.debug("打印添加的用户信息: " + joinUser);
//
////        model.addAttribute("username", username);
////        model.addAttribute("joinin", joinin);
//
//        return "login.pa";
//    }
//
//
//
//
//
//
//
//    //    登陆
//    @RequestMapping(value = "/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("pwd") String pwd,
//                        Model model) {
////        查：全部数据
//        logger.debug("获取数据库表中全部用户信息");
//        List<StudentInfo> studentList = studentInfoService.selectAll();
//        for (StudentInfo list : studentList) {
////            logger.debug("数据库用户信息：" + list);
//            logger.debug("用户名：" + list.getUsername() + "密码：" + list.getPwd() + "盐：" + list.getSalt());
//        }
////        验证用户名是否在数据库中
//
////        通过用户名取出本条数据
//        StudentInfo  withUsername = studentInfoService.selectByUsername(username);
//        logger.debug(withUsername);
//
////        获取数据库中的盐
//        String dbSalt = withUsername.getSalt();
//        logger.debug("数据库中的盐:"+ dbSalt);
//
////        获取数据库中的密码
//        String dbPwd = withUsername.getPwd();
//        logger.debug("数据库中的密码:"+ dbPwd);
//
////        String saltInputPwdMD5ful = DB_md5_salt(pwd, dbSalt);
//
////        logger.debug("MD5加盐：" + saltInputPwdMD5ful);
//
////        logger.debug("是否是同一字符串:" + MD5Encryption.verify(dbPwd, saltInputPwdMD5ful));
//
////        本次输入的密码
//        logger.debug("****本次输入的密码****");
//        logger.debug("登录名："+ username +" 密码："+ pwd);
////        数据库中取出来的密码
//        logger.debug("****数据库中取出来的密码****");
//        logger.debug("登录名："+ username +" 密码："+ dbPwd);
////        将输入的密码MD5加盐之后的密码
//        logger.debug("****将输入的密码MD5加盐之后的密码****");
////        logger.debug("登录名："+ username +" 密码："+ saltInputPwdMD5ful);
//
////        StudentInfo studentInfo1 = studentInfoMapper.selectByUsername(studentInfo.getUsername());
//        String salt = withUsername.getSalt();
//        String loginPwdHash = getPwdHash(username, salt);
//        Boolean isPwdSame =  withUsername.getPwd().equals(loginPwdHash);
//
////        到集合中查找用户是否存在，此处用来模拟数据库验证
//        for (StudentInfo stuInfo : studentList) {
//            if (stuInfo.getUsername().equals(username) && isPwdSame) {
//                model.addAttribute("stuInfo", stuInfo);
//                logger.debug("登录成功！！！！");
//                return "main.home";
//            }
//        }
//        logger.debug("数据库中未找到对应数据");
//
//        return "login.pa";
//    }



}
