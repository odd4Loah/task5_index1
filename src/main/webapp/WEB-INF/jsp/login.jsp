<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ include file="../includes/includes.jsp" %>


<%--<h1 style="background-color: #ff4871;">登录界面</h1>--%>


<div class="login-bgc">
    <div class="container">
        <div class="row log-main">
            <div class="log-table col-xs-9 col-sm-6 col-md-4 col-lg-4">
                <h4>请输入账号密码登录</h4>
                <div class="content1">
                    <input id="result1" class="write-user" type="text" name="Name" placeholder="user">
                </div>
                <div class="content1">
                    <input id="result2" class="write-code" type="password" name="Password" placeholder="code">
                </div>
                <div id="alert1"></div>
                <button class="btn login-btn" id="sign-in">登录</button>
                <div>$</div>
                <div>
                    <button class="btn login-btn">
                        <a href="${pageContext.request.contextPath}/" style="color: #ffffff;">返回神奈川</a>
                    </button>

                </div>
            </div>
        </div>
    </div>
</div>
