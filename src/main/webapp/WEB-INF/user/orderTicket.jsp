<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<% 
	String uId = session.getAttribute("uId").toString(); 
	out.print(uId);
%>
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
        <form method="post" id="form1" action="/airsys/user/payTicket/${orderFlight.fId}/<%=session.getAttribute("uId") %>" >
            <center><h1 class="h1">航空航天票据</h1></center>
            <center><h3>${ orderFlight.fName }</h3></center>
            <div><span>${orderFlight.fFromcity}</span></div>
            <div><span>${orderFlight.fTocity}</span></div>
            <div><span>${orderFlight.fStarttime}</span></div>
            <div><span>${orderFlight.fEndtime}</span></div>
            <div><span>${orderFlight.fMoney}</span></div>		
            <input class="submit" type="submit" value="确认订单">
        </form>
    </div>
</body>
</html>