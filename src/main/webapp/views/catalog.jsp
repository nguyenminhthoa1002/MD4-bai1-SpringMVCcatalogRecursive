<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/8/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Catalog Parent</th>
        <th>Create Date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCatalog}" var="cat">
        <tr>
            <td>${cat.catalogID}</td>
            <td>${cat.catalogName}</td>
            <td>${cat.catalogDescription}</td>
            <td>${cat.catalogParentName}</td>
            <td><fmt:formatDate value="${cat.catalogCreateDate}" pattern="dd/MM/yyyy"/> </td>
            <td>${cat.catalogStatus?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/catalogController/initUpdate?catalogID=${cat.catalogID}">Update</a>
                <a href="<%=request.getContextPath()%>/catalogController/delete?catalogID=${cat.catalogID}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/catalogController/initCreate">Create New Catalog</a>
</body>
</html>
