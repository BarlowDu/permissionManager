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
    <script type="text/javascript" src='<c:url value="statics/js/jquery-1.12.0.min.js"></c:url>'></script>
    <script type="text/javascript" src='<c:url value="statics/jstree/dist/jstree.min.js"></c:url>'></script>
    <link rel="stylesheet" type="text/css"
          href='<c:url value="statics/jstree/dist/themes/default/style.min.css"></c:url>'/>

</head>
<body>
<div id="divMenu">
    <ul>
        <c:forEach items="${menu}" var="resource">
            <li data-jstree='{ "opened" : true }'>${resource.item.name}
                <c:if test="${resource.children.size()>0}">
                    <ul>
                        <c:forEach items="${resource.children}" var="child">
                            <li data-jstree='{ "icon" : jstree-file }' icon-jstree="jstree-file">${child.item.name}</li>

                        </c:forEach>
                    </ul>

                </c:if>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
<script type="text/javascript">
    $("#divMenu").jstree();

</script>
</html>
