<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/08/2020
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post">
        <div class="form-group row">
            <label  class="col-sm-2 col-form-label col-form-label-sm">TÀI KHOẢN :</label>
            <div class="col-sm-3">
                <input type="text" class="form-control form-control-sm" placeholder="Name" name="name" id="name">
            </div>
        </div>
        <div class="form-group row">
            <label  class="col-sm-2 col-form-label">MẬT KHẨU :</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" placeholder="password" id="password" name="password">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="save" >ĐĂNG NHẬP </button>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="save">ĐĂNG KÍ</button>
            </div>
        </div>
    </form>
</div>
<link rel="stylesheet" href="../style.css" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
