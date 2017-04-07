<%--
  Created by IntelliJ IDEA.
  User: ykz
  Date: 2017/4/5
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <link rel="stylesheet" type="text/css" href="${context}/css/iconfont.css">
    <%--<link rel="stylesheet" type="text/css" href="${context}/css/demo.css">--%>
    <style type="text/css">
        .icon {
            width: 1em;
            height: 1em;
            vertical-align: -0.15em;
            fill: currentColor;
            overflow: hidden;
        }

        .name {
            font-family: "微软雅黑";
            font-size: 12px;
        }
    </style>
</head>
<body>
<div style="height: 8px;"></div>
<div style="width: 100%; height: 55px;" align="center">
    <div style="float:left;width: 40%; height: 100%;white-space:nowrap;"  >
        <a href="${context}/index">
            <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-all"></use>
            </svg>
            <div class="name">首页</div>
        </a>
    </div>
    <div style="float:right;width: 40%; height: 100%;white-space:nowrap;">

        <%--<a href="${context}/articleAdd">--%>
            <%--<svg class="icon" aria-hidden="true">--%>
                <%--<use xlink:href="#icon-add"></use>--%>
            <%--</svg>--%>
            <%--<div class="name">添加</div>--%>
        <%--</a>--%>
    </div>
</div>
</body>
<script src="${context}/js/iconfont.js"></script>
