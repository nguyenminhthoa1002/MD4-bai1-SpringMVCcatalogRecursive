<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/9/2022
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Catalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/catalogController/update" method="post">
    <table>
        <tr>
            <td>Catalog ID</td>
            <td><input type="text" name="catalogID" readonly value="${catUpdate.catalogID}"></td>
        </tr>
        <tr>
            <td>Catalog Name</td>
            <td><input type="text" name="catalogName" value="${catUpdate.catalogName}"></td>
        </tr>
        <tr>
            <td>Catalog Description</td>
            <td><input type="text" name="catalogDescription" value="${catUpdate.catalogDescription}"></td>
        </tr>
        <tr>
            <td>Catalog Parent</td>
            <td>
                <select name="catalogParentID" >
                    <option value="${catUpdate.catalogParentID}" selected>${catUpdate.catalogParentName}</option>
                    <c:forEach items="${listCatalogForCreate}" var="catForCreate">
                        <option value="${catForCreate.catalogID}" name="catalogParentID">${catForCreate.catalogName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Create Date</td>
            <td><input type="date" name="catalogCreateDate" value="${catUpdate.catalogCreateDate}"></td>
        </tr>
        <tr>
            <td>Catalog Status</td>
            <td>
                <c:choose>
                    <c:when test="${catUpdate.catalogStatus}">
                        <input type="radio" name="catalogStatus" id="active" value="true" checked/>
                        <label for="active">Hoạt động</label>
                        <input type="radio" name="catalogStatus" id="inactive" value="false"/>
                        <label for="inactive">Không hoạt động</label>
                    </c:when>
                    <c:otherwise>
                        <input type="radio" name="catalogStatus" id="active" value="true"/>
                        <label for="active">Hoạt động</label>
                        <input type="radio" name="catalogStatus" id="inactive" value="false" checked/>
                        <label for="inactive">Không hoạt động</label>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Create"></td>
        </tr>
    </table>
</form>
</body>
</html>
