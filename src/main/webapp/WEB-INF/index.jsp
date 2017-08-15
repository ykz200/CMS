<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--jsp有的版本默认el表达式关闭，如果遇到el表达式没解析，可以试试加上这个-->
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en" class="translated-ltr" style="font-size: 20px;">

<head>
    <title>CMS - index</title>
    <meta name="keywords" content="keywords">
    <meta name="description" content="description">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link href="${context}/css/common.css" rel="stylesheet">
    <link href="${context}/css/app.css" rel="stylesheet">
    <link href="http://at.alicdn.com/t/font_ha8yx11rd70vygb9.css" rel="stylesheet">
    <style type="text/css">
        .head {
            width: 100%;
            height: 48px;
            text-align: right;
        }

        .common-post-like-wrapper a.post-pc-like.liked {
            background-color: #F4606C;
        }
    </style>
</head>

<body>
<jsp:include page="/WEB-INF/layout/head.jsp"></jsp:include>

<div class="head">

</div>
<div class="kr_article_list">
    <div>
        <ul class="feed_ul">

            <c:forEach items="${articleList}" var="article" varStatus="status">
                <li>
                    <a href="${context}/articleDetail?id=${article.id}" target="_blank">
                        <div class="am-cf inner_li inner_li_abtest">

                            <%--<div class="img_box">--%>
                                <%--<c:if test="${'' == article.image || null == article.image}">--%>
                                    <%--<img src="${context}/image/0852484FK.jpg" width="100%">--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${'' != article.image || null != article.image}">--%>
                                    <%--<img src="${context}/uploadFile/${article.image}" width="100%">--%>
                                <%--</c:if>--%>

                            <%--</div>--%>
                            <div class="intro">
                                <h3>
                                    <a href="${context}/articleDetail?id=${article.id}" target="_blank"
                                       style="overflow: hidden; text-overflow: ellipsis; -webkit-box-orient: vertical; display: -webkit-box; -webkit-line-clamp: 2;">
                                        <font class="">${article.title}</font>
                                    </a>
                                </h3>
                                <div class="abstract"
                                     style="overflow: hidden; text-overflow: ellipsis; -webkit-box-orient: vertical; display: -webkit-box; -webkit-line-clamp: 3;">
                                    <font>
                                        <font>${article.mobileArticle}</font>
                                    </font>
                                </div>
                                <div class="info">
                                    <div class="info-list info-list-abtest">
                                        <div class="user-info">
                                            <a href="#" target="_blank" class="name">
                                                <fmt:formatDate value="${article.time }"
                                                                pattern="yyyy-MM-dd hh:mm:ss"/>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

</body>

<script charset="utf-8" src="//at.alicdn.com/t/font_ha8yx11rd70vygb9.js" type="text/javascript"></script>
</html>