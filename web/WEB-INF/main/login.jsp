<%--
  Created by IntelliJ IDEA.
  User: 热带雨林
  Date: 2018/9/24
  Time: 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>达内－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
</head>
<body class="index">
<div class="login_box">
    <%--有密码不能用get--%>
    <form action="login.form" method="post">
        <table>
            <tr>
                <td class="login_info">账号：</td>
                <%--
                这种方式退出后不能保存账号密码，只能在转发中保留账号密码
                <td colspan="2"><input name="admin_code" type="text" class="width150" value="${param.admin_code}"/></td>
                在会话中保存
                <td colspan="2"><input name="admin_code" type="text" class="width150" value="<%=session.getAttribute("admin_code")%>"/></td>
                在浏览器保存
                <td colspan="2"><input name="admin_code" type="text" class="width150" value="${cookie.admin_code.value}"/></td>
                --%>
                <td colspan="2"><input name="adminCode" type="text" class="width150" value="${sessionScope.adminCode}"/></td>
                <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
            </tr>
            <tr>
                <td class="login_info">密码：</td>
                <%--
                <td colspan="2"><input name="password" type="password" class="width150" value="${param.password}"/></td>
                <td colspan="2"><input name="password" type="password" class="width150" value="<%=session.getAttribute("password")%>"/></td>  等价于${sessionScope.admin.password}  或${admin.password}
                <td colspan="2"><input name="password" type="password" class="width150" value="${cookie.password.value}"/></td>
                --%>
                <td colspan="2"><input name="pwd" type="password" class="width150" value="${sessionScope.pwd}"/></td>
                <td><span class="required">30长度的字母、数字和下划线</span></td>
            </tr>

            <%--input中要有name--%>
            <%--
                    换图片是DOM操作，DOM可以读写节点的内容、值、属性，但是该节点没有内容和值，
                    所以只能改属性src，this.setAttribute('src','createImg.do')，对于新浏览器，这样写就可以了，
                    旧的浏览器的写法this.setAttribute('src','createImg.do?x='+Math.random())
                 --%>
            <%--
            <tr>
                <td class="login_info">验证码：</td>
                <td class="width70"><input name="number" type="text" class="width70" /></td>
                <td><img src="createImg.do" alt="验证码" title="点击更换"  id="img1"/></td>
                <td><a href="javascript:;"onclick="document.getElementById('img1').src='createImg.do?'+Math.random();">看不清，换一个</a></td>
            </tr>
            --%>

            <!--
                        表单有onsubmit事件，点击submit按钮，就触发该事件
                        表单有submit方法，调用该方法也可以提交表单
                        在超链接上写JS，但必须声明，语法：javascript:js代码;
                        DOM获取元素：id，document.getElementsByTagName('form')[0];(以下是简单写法)
                    -->
            <tr>
                <td></td>
                <td class="login_button" colspan="2">
                    <a href="javascript:document.forms[0].submit(); "><img src="images/login_btn.png" /></a>
                </td>
                <td><span class="required">${error}</span></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>