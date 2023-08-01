<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/may-tinh/update" method="post">
    <div><label><input type="hidden" name="ma" value="${mt.ma}"></label></div>
    <div><label>Tên: <input type="text" name="ten" value="${mt.ten}"></label></div>
    <div><label>Giá: <input type="text" name="gia" value="${mt.gia}"></label></div>
    <div><label>Bộ nhớ: <input type="text" name="bo_nho" value="${mt.bo_nho}"></label></div>
    <div>
        Giới Tính:
        <label>
            <input type="radio" name="mau_sac" <c:if test="${mt.mau_sac == 'Đen'}">checked</c:if> value="Đen"> Đen
        </label>
        <label>
            <input type="radio" name="mau_sac" <c:if test="${mt.mau_sac == 'Trắng'}">checked</c:if> value="Trắng"> Trắng
        </label>
    </div>
    <div>
        <label>Hãng
            <select name="hang" >
                <option <c:if test="${mt.hang == 'MSI'}">selected</c:if> >MSI</option>
                <option <c:if test="${mt.hang == 'ASUS'}">selected</c:if> >ASUS</option>
                <option <c:if test="${mt.hang == 'ACER'}">selected</c:if> >ACER</option>
                <option <c:if test="${mt.hang == 'DELL'}">selected</c:if> >DELL</option>
            </select>
        </label>
    </div>
    <div><label>Mô Tả: <input type="text" name="mieu_ta" value="${mt.mieu_ta}"></label></div>
    <button type="submit">add</button>
</form>
</body>
</html>
