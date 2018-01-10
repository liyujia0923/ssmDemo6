<%--
  Created by IntelliJ IDEA.
  User: 佳
  Date: 2017/12/27
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../comm/easyuiBasic.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#dg").datagrid({
                url: '${pageContext.request.contextPath}/hobby/queryAll',
                method: 'GET',
                rownumbers: true,
                pagination: true,
                striped: true,
                toolbar: [
                    {
                        text: '添加',
                        iconCls: 'icon-save',
                        handler: function () {
                            $("#addHobbyWindow").window("open");
                        }
                    },
                    {
                        text: '删除',
                        iconCls: 'icon-remove',
                        handler: function () {
                            var checkHobby = $("#dg").datagrid("getChecked");
                            if(checkHobby==null || checkHobby <=0) {
                                alert("请选择要删除的爱好");
                                return ;
                            }
                            var idStr = "";
                            $.each(checkHobby,function (index,item) {
                                idStr = idStr + item.id + ",";

                            })
                            if(confirm("确定要删除吗？")){
                                $.post("${pageContext.request.contextPath}/hobby/deleteHobbyList",{"ids":idStr},
                                function (data) {
                                    alert(data.msg);
                                    $("#dg").datagrid('reload');
                                })
                            }
                        }
                    }
                ],
                columns: [[
                    {field: 'ck', checkbox: true},
                    {field: 'hobbyName', title: '爱好名称'},
                    {
                        field: 'createTime', title: '创建时间', formatter: function (value, row, index) {
                        var date = new Date(value);
                        var Y = date.getFullYear();
                        var M = date.getMonth() + 1;
                        var D = date.getDate();
                        var h = date.getHours();
                        var m = date.getMinutes();
                        var s = date.getSeconds();
                        return Y + "-" + M + "-" + D + " " + h + ":" + m + ":" + s;
                    }
                    },
                    {
                        field: 'id', title: '操作列', formatter: function (value, row, index) {
                        var queryHobby = "<button onclick='queryHobby(" + value + ")'>详情</button>";
                        var updateHobby = "<button onclick='updateHobby(" + value + ")'>修改</button>";
                        var deleteHobby = "<button onclick='deleteHobby(" + value + ")'>删除</button>";
                        return queryHobby + "" + updateHobby + "" + deleteHobby;

                    }
                    }
                ]]
            });
            $("#saveAddHobbyButton").click(function () {
                var hobby = $("#addHobbyForm").serialize();
                $.post("${pageContext.request.contextPath}/hobby/addHobby",hobby,
                function (data) {
                    alert(data.msg);
                    $("#addHobbyForm").form("clear");
                    $("#addHobbyWindow").window("close");
                    $("#dg").datagrid("reload");
                })
            })
            $("#saveUpdateHobbyButton").click(function () {
                var hobby = $("#updateHobbyForm").serialize();
                $.post("${pageContext.request.contextPath}/hobby/updateHobby",hobby,
                function (data) {
                    alert(data.msg);
                    $("#updateHobbyWindow").window("close");
                    $("#dg").datagrid('reload');
                })
            })

        })
        function queryHobby(id) {
            $.get("${pageContext.request.contextPath}/hobby/queryHobby",{"id":id},
            function (data) {
                $("#queryHobbyWindow").window("open");
                var date = new Date(data.createTime);
                var Y = date.getFullYear();
                var M = date.getMonth() + 1;
                var D = date.getDate();
                var h = date.getHours();
                var m = date.getMinutes();
                var s = date.getSeconds();
                data.createTime = Y + "-" + M + "-" + D + " " + h + ":" + m + ":" + s;
                $("#queryHobbyForm").form('load', data);
            })
        }
        function updateHobby(id) {
            $.get("${pageContext.request.contextPath}/hobby/queryHobby",{"id":id},
                function (data) {
                    $("#updateHobbyWindow").window("open");
                    var date = new Date(data.createTime);
                    var Y = date.getFullYear();
                    var M = date.getMonth() + 1;
                    var D = date.getDate();
                    var h = date.getHours();
                    var m = date.getMinutes();
                    var s = date.getSeconds();
                    data.createTime = Y + "-" + M + "-" + D + " " + h + ":" + m + ":" + s;
                    $("#updateHobbyForm").form('load', data);
                })
        }
        function deleteHobby(id) {
          $.post("${pageContext.request.contextPath}/hobby/deleteHobby",{"id":id},
          function (data) {
              alert(data.msg);
              $("#dg").datagrid('reload');
          })
        }
    </script>
</head>
<body>
    <table id="dg"></table>
    <%--添加--%>
    <div class="easyui-window" style="width: 500px;height: 300px;padding: 60px 120px;"
         title="添加" id="addHobbyWindow" closed="true">
        <form id="addHobbyForm">
            <div>
                <label>爱好名称:</label>
                <input class="easyui-textbox" name="hobbyName">
            </div>
        </form>
        <button id="saveAddHobbyButton">保存</button>
    </div>
    <%--详情--%>
    <div class="easyui-window" style="width: 500px;height: 300px;padding: 60px 120px;"
         title="详情" id="queryHobbyWindow" closed="true">
        <form id="queryHobbyForm">
            <div>
                <label>爱好名称:</label>
                <input class="easyui-textbox" name="hobbyName">
            </div>
            <div>
                <label>创建时间:</label>
                <input class="easyui-textbox" name="createTime">
            </div>
        </form>

    </div>
    <%--修改--%>
    <div class="easyui-window" style="width: 500px;height: 300px;padding: 60px 120px;"
         title="修改" id="updateHobbyWindow" closed="true">
        <form id="updateHobbyForm">
            <div>
                <label>爱好名称:</label>
                <input class="easyui-textbox" name="hobbyName">
                <input type="hidden" name="id">
            </div>
        </form>
        <button id="saveUpdateHobbyButton">保存</button>
    </div>

</body>
</html>
