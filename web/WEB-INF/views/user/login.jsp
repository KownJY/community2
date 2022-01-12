<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>로그인</h1>
<div>${requestScope.msg}</div>
<div class="gamssa">
<div>
<form action="/user/login" method="post" id="login-frm">

    <div><label>id : <input type="text" name="uid" value="${requestScope.remainId}"></label></div>
    <div><label>password : <input type="password" name="upw"></label></div>
    <div>
        <input type="submit" value="로그인">
    </div>
</form>
</div>
<div><a href="/user/join">조인</a> </div>
</div>