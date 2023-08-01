<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<form action="/may-tinh/add" method="post">
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
<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Giá</th>
        <th scope="col">Bộ Nhớ</th>
        <th scope="col">Màu Sắc</th>
        <th scope="col">Hãng</th>
        <th scope="col">Mô Tả</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="mt" items="${list}">
        <tr>
            <th scope="col">${mt.ma}</th>
            <th scope="col">${mt.ten}</th>
            <th scope="col">${mt.gia}</th>
            <th scope="col">${mt.bo_nho}</th>
            <th scope="col">${mt.mau_sac}</th>
            <th scope="col">${mt.hang}</th>
            <th scope="col">${mt.mieu_ta}</th>
            <th scope="col">
                <a type="button" href="/may-tinh/detail?ma=${mt.ma}" class="btn btn-secondary">Detail</a>
                <a type="button" href="/may-tinh/delete?ma=${mt.ma}" class="btn btn-danger">Delete</a>
                <a type="button" href="/may-tinh/view-update?ma=${mt.ma}" class="btn btn-primary">Update</a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>