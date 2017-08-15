<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--jsp有的版本默认el表达式关闭，如果遇到el表达式没解析，可以试试加上这个-->
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en" class="translated-ltr" style="font-size: 20px;">

<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
    <title>登录</title>
    <!-- Custom Theme files -->
    <link href="${context}/css/style_login.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="登录" />
    <!--Google Fonts-->
    <!--<link href='//fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    --><!--Google Fonts-->
</head>
<body>
<!--header start here-->
<div class="login-form">
    <div class="top-login">
        <span><img src="${context}/image/group.png" alt=""/></span>
    </div>
    <h1>登录</h1>
    <div class="login-top">
        <form action="${context}/api_login">
            <div class="login-ic">
                <i ></i>
                <input type="text" name="userName"  value="用户" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'User name';}"/>
                <div class="clear"> </div>
            </div>
            <div class="login-ic">
                <i class="icon"></i>
                <input type="password" name="passWord" value="密码" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'password';}"/>
                <div class="clear"> </div>
            </div>

            <div class="log-bwn">
                <input type="submit"  value="Login" >
            </div>
        </form>
    </div>
    <p class="copy">© 2017 加密协议防泄漏  <a href="${context}" target="_blank"></a></p>
</div>
<!--header start here-->
</body>
</html>