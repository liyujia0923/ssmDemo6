<%--
  Created by IntelliJ IDEA.
  User: 佳
  Date: 2017/12/9
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="basic.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="page-header">
                    <h1>学生管理系统
                        <small>
                            欢迎${loginUser.nickName}，登录
                            <a href="${pageContext.request.contextPath}/loginOut">注销</a>
                        </small>
                    </h1>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
