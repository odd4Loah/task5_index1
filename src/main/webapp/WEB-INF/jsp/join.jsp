<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ include file="../includes/includes.jsp" %>


<%--<h1 style="background-color: #02ff32;">注册界面</h1>--%>


<div class="login-bgc">
    <div class="container">
        <div class="row log-main">
            <div class="log-table col-xs-9 col-sm-6 col-md-4 col-lg-4">
                <h4>注册</h4>
                <div class="content1">
                    <input id="result1" class="write-user" type="text" name="Name" placeholder="user">
                </div>
                <div class="content1">
                    <input id="result2" class="write-code" type="password" name="Password" placeholder="code">
                </div>
                <div id="alert1"></div>
                <button class="btn login-btn" id="sign-in">注册</button>
            </div>
        </div>
    </div>
</div>
