<%--
  Created by IntelliJ IDEA.
  User: dutc
  Date: 2017/3/14
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>a</title>
</head>
<body>
<ul>
    <c:forEach items="${menu.children}" var="resource">
        <li>${resource.item.name}</li>
    </c:forEach>
</ul>
</body>
</html>
