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

<body style="text-align: center;background: #000cdc;color: #eaeaea">
<h1>登录失败！！！</h1>
<h2>看看是不是账号和密码哪一个填错了？</h2>
<button style="font-size: xx-large">
    <a href="${pageContext.request.contextPath}/login">重新登录</a>
</button>
</body>