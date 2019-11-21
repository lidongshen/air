<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>pay</title>
    <link rel="stylesheet" href="/airsys/assets/css/bootstrap.css">
    <link rel="stylesheet" href="/airsys/assets/css/userorder.css">
</head>
<body>
    <div class="zong">
        <form method="post" id="form1" action="/airsys/payTicket/${oneFlight.fId}/<%=session.getAttribute("cId") %>" >
            <center><h1 class="h1">航空航天订单</h1></center>
            <center><h3>${oneFlight.fName}</h3></center>
            <div><span>${oneFlight.fFromcity}</span></div>
            <div><span>${oneFlight.fTocity}</span></div>
            <div><span>${oneFlight.fStarttime}</span></div>
            <div><span>${oneFlight.fEndtime}</span></div>
            <div><span>${oneFlight.fMoney}</span></div>		
            <input class="submit" type="submit" value="确认订单">
        </form>
    </div>
</body>
</html>