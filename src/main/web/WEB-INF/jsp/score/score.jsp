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
            $("#scoreDataGrid").datagrid({
                url:'${pageContext.request.contextPath}/score/queryAll',
                method:'GET',
                pagination:true,
                rownumbers:true,
                striped:true,
                checkOnSelect:false,
                toolbar:[
                    {
                        text:'添加',
                        iconCls:'icon-add',
                        handler:function () {

                        }
                    },
                    {
                        text:'删除',
                        iconCls:'icon-remove',
                        handler:function () {
                            var checkScore = $("#scoreDataGrid").datagrid("getChecked");
                            if(checkScore==null || checkScore.length<=0) {
                                alert("请选择要删除的爱好");
                                return;
                            }
                            var idStr = "";
                            $.each(checkScore,function (index, item) {
                                idStr = idStr + item.id + ",";
                            })
                            if(confirm("确定要删除吗？")){
                                $.post("${pageContext.request.contextPath}/score/deleteScoreByIds",{"ids":idStr},
                                function (data) {
                                    alert(data.msg);
                                    $("#scoreDataGrid").datagrid('reload');
                                })
                            }
                        }
                    }
                ],
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:'grade',title:'年级',formatter:function (value, row, index) {
                        return row.student6.grade6.gradeName;
                    }},
                    {field:'student6',title:'姓名',formatter:function (value, row, index) {
                        return value.studentName;
                    }},
                    {field:'course6',title:'课程',formatter:function (value, row, index) {
                        return value.courseName;
                    }},
                    {field:'score',title:'成绩'},
                    {field:'id',title:'操作列',formatter:function (value, row, index) {
                        var queryScoreById = "<button onclick='queryScoreById("+value+")'>详情</button>";
                        var updateScore = "<button onclick='updateScore("+value+")'>修改</button>";
                        var deleteScore = "<button onclick='deleteScore("+value+")'>删除</button>";
                        return queryScoreById + updateScore + deleteScore;
                    }}
                ]]
            })
            //查询班级信息
            $.get("${pageContext.request.contextPath}/student/queryGrade",function (grade) {
                var grade1 = $.parseJSON('{"id":-1,"gradeName":"--请选择--"}');
                grade.push(grade1);
                $("#queryGradeCombobox").combobox({
                    valueField:'id',
                    textField:'gradeName',
                    data:grade,
                    onLoadSuccess:function () {
                        $(this).combobox("select", -1);
                    },
                    onSelect:function (grade) {//为选中的班级加载对应的学生
                        var gradeId = grade.id;
                        $.get("${pageContext.request.contextPath}/student/queryStudentByGradeId",
                            {"gradeId":gradeId},function (student) {
                                var student1 = $.parseJSON('{"id":-1,"studentName":"--请选择--"}');
                                student.push(student1);
                            $("#queryStudentCombobox").combobox({
                                    valueField: 'id',
                                    textField:'studentName',
                                    data:student,
                                    onLoadSuccess:function () {
                                        $(this).combobox("select", -1);
                                    }
                                });
                            })
                    }
                })

            })
            $("#queryScoreButton").click(function () {
                var gradeId = $("#queryGradeCombobox").val();
                var studentId = $("#queryStudentCombobox").val();
                $("#scoreDataGrid").datagrid('load',{
                    "gradeId":gradeId,
                    "studentId":studentId
                })
            });

        })
        function queryScoreById(id) {

           $.get("${pageContext.request.contextPath}/score/queryScoreById",{"id":id},
           function (data) {
               $("#queryGradeName").textbox('setValue', data.student6.grade6.gradeName);
               $("#queryStudentName").textbox('setValue', data.student6.studentName);
               $("#queryCourseName").textbox('setValue', data.course6.courseName);
               $("#queryScore").textbox('setValue', data.score);
           })
            $("#queryScoreByIdsWindow").window('open');
        }
        function updateScore(id) {
            
        }
        function deleteScore(id) {
            if(confirm("确定要删除吗？")){
                $.post("${pageContext.request.contextPath}/score/deleteScoreById",{"id":id},
                function (data) {
                    alert(data.msg);
                    $("#scoreDataGrid").datagrid('reload');
                })
            }
        }
    </script>
</head>
<body>
    <div>
        <form>
            班级：<input id="queryGradeCombobox" name="gradeId">
            学生：<input id="queryStudentCombobox" name="studentId"/>
            <a href="#" class="easyui-linkbutton" id="queryScoreButton" iconCls="icon-search">查询</a>
        </form>
    </div>
    <table id="scoreDataGrid"></table>
    <%--详情--%>
    <div class="easyui-window" id="queryScoreByIdsWindow"
         style="top: 30%; left: 30%; width: 500px; height: 300px; padding:60px 120px;"
         title="成绩详情" closed="true">
        <form id="queryScoreByIdForm">
            <div>
                班级：<input class="easyui-textbox" id="queryGradeName"/>
            </div>
            <div>
                学生：<input class="easyui-textbox" id="queryStudentName"/>
            </div>
            <div>
                课程：<input class="easyui-textbox" id="queryCourseName"/>
            </div>
            <div>
                 成绩：<input class="easyui-textbox" id="queryScore"/>
             </div>

        </form>
    </div>

    <%--添加--%>
    <div class="easyui-window" id="addScoreWindow"
         style="top: 30%; left: 30%; width: 500px; height: 300px; padding:60px 120px;"
         title="添加成绩" closed="true">
        <form id="addScoreForm">
            <div>
                班级：<input class="easyui-textbox" id="addGradeName" name="student6.grade6.id"/>
            </div>
            <div>
                学生：<input class="easyui-textbox" id="addStudentName" name="student6.id"/>
            </div>
            <div>
                课程：<input class="easyui-textbox" id="addCourseName" name="course6.id"/>
            </div>
            <div>
                成绩：<input class="easyui-textbox" id="addScore" name="score"/>
            </div>
        </form>
        <button id="saveAddScoreButton">保存</button>
    </div>

    <%--修改--%>
    <div class="easyui-window" id="updateScoreWindow"
         style="top: 30%; left: 30%; width: 500px; height: 300px; padding:60px 120px;"
         title="修改成绩" closed="true">
        <form id="updateScoreForm">
            <div>
                班级：<input class="easyui-textbox" id="updateGradeName"/>
                <input type="hidden" id="updateScoreId" name="id">
            </div>
            <div>
                学生：<input class="easyui-textbox" id="updateStudentName"/>
            </div>
            <div>
                课程：<input class="easyui-textbox" id="updateCourseName"/>
            </div>
            <div>
                成绩：<input class="easyui-textbox" id="updateScore" name="score"/>
            </div>
        </form>
        <button id="saveUpdateScoreButton">保存</button>
    </div>
</body>
</html>
