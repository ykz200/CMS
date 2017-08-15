<!--jsp有的版本默认el表达式关闭，如果遇到el表达式没解析，可以试试加上这个-->
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>article Detail</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link href="${context}/css/common.css" rel="stylesheet">
    <link href="${context}/css/app.css" rel="stylesheet">
    <link rel="stylesheet" href="${context}/css/style.css">

</head>
</head>
<body>
<jsp:include page="/WEB-INF/layout/head.jsp"></jsp:include>
<div class="article-detail ">
    <div class="post-wrapper">
        <div id="J_normal_read_5069259" class="post-detail-con-box full-reading mainlib_flex_wapper">
            <div class="mainlib">
                <div class="center_content">
                    <div class="content-wrapper">
                        <div class="article-section" data-articleid="5069259" id="J_post_wrapper_5069259">
                            <div class="mobile_article">
                                <h1>${article.title}</h1>
                                <div class="content-font">
                                    <div class="am-cf author-panel">
                                        <div class="author am-fl" align="right">
                                            <span class="time am-fl">
                                                <abbr class="time"><fmt:formatDate value="${article.time }"
                                                    pattern="yyyy-MM-dd hh:mm:ss"/></abbr>
                                            </span>
                                        </div>
                                    </div>
                                    <section class="summary">${article.mobileArticle}</section>
                                    <section class="headimg">

                                        <%--<c:if test="${'' != article.image}">--%>
                                        <%--<img src="${context}/uploadFile/${article.image}"--%>
                                             <%--alt="${article.mobileArticle}" width="100%"></section>--%>
                                        <%--</c:if>--%>

                                    <div>
                                            ${article.info}
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%--<div class="common-post-like-wrapper"  align="center">--%>
                            <%--<a class="post-pc-like edit" href="${context}/articleUpdate?id=${article.id}">--%>
                                <%--<div class="name">编辑</div>--%>
                            <%--</a>--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
