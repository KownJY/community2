<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="titleVal" value="글쓰기" />
<c:set var="actionVal" value="/board/write" />
<c:set var="submitVal" value="WRITE" />
<c:set var="iboardVal" value="0" />
<c:set var="icategoryVal" value="${param.icategory}" />
<c:if test="${requestScope.data != null && requestScope.data.iboard > 0}">
    <c:set var="titleVal" value="수정" />
    <c:set var="actionVal" value="/board/mod" />
    <c:set var="submitVal" value="MOD" />
    <c:set var="iboardVal" value="${requestScope.data.iboard}" />
    <c:set var="icategoryVal" value="0" />
</c:if>
<div>
    <h1>${titleVal}</h1>
    <form action=${actionVal} method="post">
        <input type="hidden" name="iboard" value="${iboardVal}">
        <input type="hidden" name="icategory" value="${icategoryVal}">
        <div><label>제목:  <input type="text" name="title" value="<c:out value='${data.title}'/>"></label></div>
        <div><label>내용:  <textarea type="text" name="ctnt"><c:out value='${data.ctnt}'/></textarea></label></div>
        <div><input type="submit" value="${submitVal}"></div>
    </form>
</div>