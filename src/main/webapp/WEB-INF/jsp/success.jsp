<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/22
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ include file="../includes/includes.jsp" %>

<body>
<h5>注册成功，个人信息如下：</h5>
用户名：${studentInfo.username}
<br />密   码：${user.password}
<br />年   龄：${user.age}
<br />电   话：${user.phone}
<br />邮   箱：${user.email}
<br />
</body>