
<%--
  Created by IntelliJ IDEA.
  User: ykz
  Date: 2017/4/4
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<!--jsp有的版本默认el表达式关闭，如果遇到el表达式没解析，可以试试加上这个-->
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>article edit</title>
</head>
<link rel="stylesheet" href="${context}/css/jedate.css" type="text/css"/>
<link href="${context}/css/common.css" rel="stylesheet">
<link href="${context}/css/app.css" rel="stylesheet">
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${context}/css/style.css">
<style type="text/css">
    body {
        text-align: center
    }

    .tail {
        width: 100%;
        height: 35px;
    }

    .div {
        margin: 0 auto;
        /*border: 1px solid #F00;*/
    }

    table, tr {
        /*width: 100%;*/
        height: 56px;
        /*align-content: center;*/
        margin: 0 auto;

    }

    tr, td {
        width: 400px;
        /*height: 200px;*/
        text-align: center;
    }

    .trtd {
        width: 721px;
        /*height: 200px;*/
        text-align: left;
    }

    input {
        width: 300px;
        height: 30px;
    }
</style>
<body>
<jsp:include page="/WEB-INF/layout/manageHead.jsp"></jsp:include>
<div class="div">
    <form name="articleFrom" id="articleFrom">
        <input type="hidden" id="id" name="id" value="${article.id}">
        <table>
            <tr>
                <td><span>标题：</span></td>
                <td class="trtd">
                    <input name="title" value="${article.title}">
                </td>
            </tr>
            <tr>
                <td><span>发布时间：</span></td>
                <td class="trtd">
                    <%--<input name="updateTime" value="<fmt:formatDate value="${article.time }" pattern="yyyy-MM-dd"/>"/>--%>
                    <input class="laydate-icon" name="updateTime" id="textymdhms" type="text" placeholder="yyyy-MM-dd hh:mm:ss" value="<fmt:formatDate value="${article.time }" pattern="yyyy-MM-dd hh:mm:ss" />"  readonly>
                </td>
            </tr>
            <tr>
                <td><span>预览描述：</span></td>
                <td class="trtd">
                    <input class="summary" name="mobileArticle" value="${article.mobileArticle}">
                </td>
            </tr>
            <tr>
                <td><span>预览图片：</span></td>
                <td class="trtd">
                    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                        预览图管理界面
                    </button>
                    <input type="hidden" name="image" id="image" value="${article.image}">
                </td>
            </tr>
            <tr>
                <td><span>内容：</span></td>
                <td style="height: 500px;" class="trtd">
                    <textarea id="editor" type="text/plain" name="info" style="width:100%;height:500px;">
                        ${article.info}
                    </textarea>
                </td>
            </tr>
        </table>

        <div class="common-post-like-wrapper" align="center">
            <a class="post-pc-like liked" id="cancel">
                <div class="name">取消</div>
            </a>

            <a class="post-pc-like" id="submit">
                <div class="name">保存</div>
            </a>
        </div>

    </form>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" align="center">
            <form id="form" enctype="multipart/form-data">
                upload image
                <input type="file" id="image_input" name="file"/>
                <a href="#" onclick="upload()">上传图片</a>
            </form>
            <div id="imgDiv" align="center">
                <c:if test="${'' != article.id && null != article.id }">
                    <img src="${context}/uploadFile/${article.image}" style="width: 90%;"/>
                </c:if>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭页面</button>
            </div>
        </div>
    </div>
</div>
<div class="tail">
</div>

</body>

<script charset="utf-8" src="${context}/js/jquery.min.js" type="text/javascript"></script>
<script charset="utf-8" src="${context}/js/jedate.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${context}/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${context}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script charset="utf-8" src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
<script charset="utf-8" src="${context}/js/jquery.from.js" type="text/javascript"></script>

<script>
    UEDITOR_CONFIG.UEDITOR_HOME_URL = '${context}/ueditor/'; //一定要用这句话，否则你需要去ueditor.config.js修改路径的配置信息
    UE.getEditor('editor');

    var id = ${article.id}

    $("#submit").click(function () {
        if (""== id || null == id) {
           add();
        } else {
            update();
        }

    })

    function update() {

        $.ajax({
            type: "POST",
            url: "${context}/api/articleUpdate",
            data: $("#articleFrom").serialize(),
            success: function (data) {
                if (data.success) {
                    alert("文章更新成功！");
                    window.location.href= "${context}/articleDetail?id=${article.id}"
                } else {
                    alert(data.errorMessages.join());
                }
            }
        });

        return false;
    }

    function add() {
        $.ajax({
            type: "POST",
            url: "${context}/api/articleAdd",
            data: $("#articleFrom").serialize(),
            success: function (data) {
//                alert(data)
                if (data.success) {
                    alert("文章更新成功！");
                    window.location.href = "${context}/index"
                } else {
                    alert(data.errorMessages.join());
                }
            }
        });
        return false;
    }


    $("#cancel").click(function () {
        window.history.go(-1)

    })
    function upload() {
        var imagePath = $("#image_input").val();
        if (imagePath == "") {
            alert("please upload image file");
            return false;
        }
        var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);
        if (strExtension != 'jpg' && strExtension != 'gif'
            && strExtension != 'png' && strExtension != 'bmp'
            && strExtension != 'jpeg'  ) {
            alert("please upload file that is a image");
            return false;
        }
        $("#form").ajaxSubmit({
            type: 'POST',
            url: '${context}/upload/image',
            success: function (data) {
                alert("上传成功");
                $("#imgDiv").empty();
                $("#imgDiv").html('<img src="${context}/uploadFile/' + data + '" style="width:90%"/>');
                $("#imgDiv").show();
                $("#image").val(data);
            },
            error: function () {
                alert("上传失败，请检查网络后重试");
            }
        });

    }

    jeDate({
        dateCell:"#textymdhms",
        format:"YYYY-MM-DD hh:mm:ss",
        //isinitVal:true,
        isTime:true,
        festival: true, //显示节日
        minDate:"2015-09-19 00:00:00",
        maxDate:"2019-09-19 00:00:00"
    })

</script>
</html>
