
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="submenu-section">
    <div class="p10">
        <ul>
            <li><a href="">프로필</a></li>
            <li><a href="">비밀번호변경</a></li>
        </ul>
    </div>
    <div>
        <tiles:insertAttribute name="content" />
    </div>
</div>
