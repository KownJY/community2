<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="profileImg" value="/res/img/fire.png"></c:set>
<c:if test="${sessionScope.loginUser.profileimg != null}">

    <c:set var="profileImg"
           value="/images/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileimg}"></c:set>
</c:if>
<div id="data" data-iuser="${sessionScope.loginUser.iuser}"></div>
<h1>프로필 ^^</h1>
<div id="profile-view" class="pointer circular--img circular--size300"><img src="${profileImg}"> </div>
<input type="file" id="profile-file" class="hidden" accept="image/*">
<div>아이디 : ${sessionScope.loginUser.uid}</div>
<div>이름  :${sessionScope.loginUser.nm}</div>
<div>성별: ${sessionScope.loginUser.gender == 1 ? '남성' : '여성'}</div>
<div></div>
