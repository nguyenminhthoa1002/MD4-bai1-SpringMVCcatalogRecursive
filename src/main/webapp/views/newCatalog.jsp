<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/8/2022
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Catalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/catalogController/create" method="post">
  <table>
    <tr>
      <td>Catalog Name</td>
      <td><input type="text" name="catalogName"></td>
    </tr>
    <tr>
      <td>Catalog Description</td>
      <td><input type="text" name="catalogDescription"></td>
    </tr>
    <tr>
      <td>Catalog Parent</td>
      <td>
        <select name="catalogParentID">
          <option value="0" selected>Choose...</option>
          <c:forEach items="${listCatalogForCreate}" var="catForCreate">
            <option value="${catForCreate.catalogID}" name="catalogParentID">${catForCreate.catalogName}</option>
          </c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <td>Create Date</td>
      <td><input type="date" name="catalogCreateDate"></td>
    </tr>
    <tr>
      <td>Catalog Status</td>
      <td>
        <input type="radio" name="catalogStatus" id="active" checked/><label for="active">Active</label>
        <input type="radio" name="catalogStatus" id="inactive"/><label for="inactive">Inactive</label>
      </td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Create"></td>
    </tr>
  </table>
</form>
</body>
</html>
