<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 佳
  Date: 2017/12/14
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../basic.jsp"%>
    <script type="text/javascript">
        $(function () {
            //单条删除
            $("button[name=deleteStudentButton]").click(function () {
                var studentId = $(this).attr("studentId");
                $.post("${pageContext.request.contextPath}/student/deleteStudentByIds",
                    {"studentId":studentId},function (data) {
                        alert(data.msg);
                        location.href = location.href;
                    });
            })
            //批量删除
            $("#deleteStudentByIdsButton").click(function () {
                var studentId = "";
                $.each($("input[name=addStudentCheckBox]"),function () {
                    if(this.checked){
                        studentId = studentId + $(this).val() + ",";
                    }
                });
                if(studentId==""){
                    alert("请选择要删除的班级");
                    return;
                }
                if(confirm("确定要删除吗？")){
                    $.post("${pageContext.request.contextPath}/student/deleteStudentByIds",
                        {"studentId":studentId},function (data) {
                            alert(data.msg);
                            location.href = location.href;
                        });
                }

            })
            //添加显示模态框
            $("#addStudentButton").click(function () {
                showGrade();
                $("#addStudentModal").modal("show");
            })
            //添加
            $("#saveAddStudentModalButton").click(function () {
                var student = $("#addStudentForm").serialize();
                $.post("${pageContext.request.contextPath}/student/addStudent",student,
                function (data) {
                    alert(data.msg);
                    location.href = location.href;
                })
                
            })
            //详情
            $("button[name=queryStudentButton]").click(function () {
                var studentId = $(this).attr("studentId");
                $.get("${pageContext.request.contextPath}/student/queryStudentById",
                    {"id":studentId},function (data) {
                        $("#queryStudentName").val(data.studentName);
                        $("#queryStudentNum").val(data.studentNum);
                        $("#queryAge").val(data.age);
                        $("#queryGender").val(data.gender);
                        $("#queryGradeName").val(data.grade6.gradeName);
                    });
                $("#queryStudentModal").modal("show");
            })
            //修改显示模态框
            $("button[name=updateStudentButton]").click(function () {
                var studentId = $(this).attr("studentId");
                $.get("${pageContext.request.contextPath}/student/queryStudentById",
                    {"id":studentId},function (data) {
                        $("#updateStudentName").val(data.studentName);
                        $("#updateId").val(data.id);
                        $("#updateStudentNum").val(data.studentNum);
                        $("#updateAge").val(data.age);
                        if("男"==data.gender){
                            $("#updateGender1").attr("checked", true);
                        }else{
                            $("#updateGender2").attr("checked", true);
                        }
                        var gradeId = data.grade6.id;
                        showGrade($("#updateStudentSelect"),gradeId);
                    });
                $("#updateStudentModal").modal("show");
            })
            //修改
            $("#saveUpdateStudentModalButton").click(function () {
                var student = $("#updateStudentForm").serialize();
                $.post("${pageContext.request.contextPath}/student/updateStudent",
                student,function (data) {
                        alert(data.msg);
                        location.href = location.href;
                    })
                
            })
        })
        //显示班级
        function showGrade(ele,gradeId) {
            ele.empty();
            $.get("${pageContext.request.contextPath}/student/queryGrade",function (data) {
                for(var i=0;i<data.length;i++) {
                    var option = "<option value='"+data[i].id+"'>"+data[i].gradeName+"</option>"
                    ele.append(option);
                }
                if(null!=gradeId) {
                    ele.val(gradeId);
                }
            });
        }
    </script>
</head>
<body>
<%@include file="../top.jsp"%>
<%@include file="../left.jsp"%>
<div class="container">
    <div class="row">

        <div class="col-lg-4 col-lg-offset-2">
            <h3>班级管理</h3>
        </div>
        <div class="col-lg-2 col-lg-offset-2">
            <button class="btn btn-danger" id="deleteStudentByIdsButton">删除</button>
            <button class="btn btn-danger" id="addStudentButton">添加</button>
        </div>

    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2" >
            <table class="table table-bordered">
                <tr>
                    <td></td>
                    <td>学生id</td>
                    <td>学生姓名</td>
                    <td>学生学号</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>年级</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${pageInfo.list}" var="student">
                    <tr>
                        <td>
                            <input type="checkbox" name="addStudentCheckBox" value="${student.id}">
                        </td>
                        <td>${student.id}</td>
                        <td>${student.studentName}</td>
                        <td>${student.studentNum} </td>
                        <td>${student.age}</td>
                        <td>${student.gender}</td>
                        <td>${student.grade6.gradeName}</td>
                        <td>
                            <button type="button" class="btn btn-info " name="queryStudentButton" studentId="${student.id}">详情</button>
                            <button type="button" class="btn btn-info btn " name="updateStudentButton" studentId="${student.id}">修改</button>
                            <button type="button" class="btn btn-danger btn" name="deleteStudentButton" studentId="${student.id}" >删除</button>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>

    <%@include file="../page.jsp"%>
    <%--添加学生模态框--%>
    <div class="modal fade" tabindex="-1" role="dialog" id="addStudentModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">添加学生</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="addStudentForm">
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">学生姓名</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="studentName" placeholder="学生姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">学生编号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="studentNum" placeholder="学生学号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-3 control-label">年龄</label>
                            <div class="col-sm-8">
                                <input type="number" class="form-control" name="age" min="1">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-8">


                                    <input type="radio" name="gender" value="男">男
                                    <input type="radio" name="gender" value="女">女

                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">班级</label>
                            <div class="col-sm-8">

                                <select class="form-control" name="grade6.id" id="addStudentSelect">
                                </select>
                                <input type="hidden" name="grade6.gradeName" id="addStudentGradeName">
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="saveAddStudentModalButton">保存</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <%--详情模态框--%>
    <div class="modal fade" tabindex="-1" role="dialog" id="queryStudentModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">添加学生</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="queryStudentForm">
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">学生姓名</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="studentName" id="queryStudentName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">学生学号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="studentNum" id="queryStudentNum">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">年龄</label>
                            <div class="col-sm-8">
                                <input type="number" class="form-control" name="age" id="queryAge" min="1">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="gender" id="queryGender" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">班级</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="grade6.id" id="queryGradeName"/>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <%--修改学生模态框--%>
    <div class="modal fade" tabindex="-1" role="dialog" id="updateStudentModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改学生</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="updateStudentForm">
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">学生名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="studentName" id="updateStudentName">
                                <input type="hidden" name="id" id="updateId">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">学生编号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="updateStudentNum" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">年龄</label>
                            <div class="col-sm-8">
                                <input type="number" class="form-control" name="age" id="updateAge" min="1">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-8">
                                <input type="radio" name="gender" id="updateGender1" value="男">男
                                <input type="radio" name="gender" id="updateGender2" value="女">女
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">班级</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="grade6.id" id="updateStudentSelect">
                                </select>
                            </div>
                        </div>

                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="saveUpdateStudentModalButton">保存</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div>
</body>
</html>
