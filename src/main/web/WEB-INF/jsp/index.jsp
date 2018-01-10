<%--
  Created by IntelliJ IDEA.
  User: 佳
  Date: 2017/12/27
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="comm/easyuiBasic.jsp"%>
</head>
<body>
    <div class="easyui-window" style="width: 500px;height: 300px; padding:60px 110px;"
         title="登录">
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input class="easyui-textbox" name="userName"></td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;码：</td>
                    <td><input class="easyui-passwordbox" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="登录">
                        <input type="reset" value="重置">
                    </td>

                </tr>
            </table>
        </form>
    </div>

</body>
</html>
