<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--    <link rel="stylesheet" href="/res/css/<tiles:getAsString name="commonCss"/>">--%>
    <%--    <link rel="stylesheet" href="/res/css/<tiles:getAsString name="menuCss"/>">--%>
    <%--    <link rel="stylesheet" href="/res/css/<tiles:getAsString name="eachCss"/>">--%>
    <link rel="stylesheet" href="/res/css/<tiles:getAsString name="common"/>.css">
    <link rel="stylesheet" href="/res/css/<tiles:getAsString name="addr1"/>/index.css">
    <link rel="stylesheet" href="/res/css/<tiles:getAsString name="addr2"/>.css">
    <%--    디퍼랑 어싱크 한번 검색해보세요--%>
    <script defer src="/res/js/<tiles:getAsString name="common"/>.js"></script>
    <script defer src="/res/js/<tiles:getAsString name="addr1"/>/index.js"></script>
    <script defer src="/res/js/<tiles:getAsString name="addr2"/>.js"></script>
    <title>tiles</title>
</head>
<body>
<div id="container">
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
    <section>
        <%--                    <tiles:insertAttribute name="content"></tiles:insertAttribute>--%>
        <tiles:insertAttribute name="body"></tiles:insertAttribute>
    </section>

    <tiles:insertAttribute name="footer"></tiles:insertAttribute>


</div>
</body>
</html>