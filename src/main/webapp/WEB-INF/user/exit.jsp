<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	session.removeAttribute("userlogin");
	session.removeAttribute("uId");
	out.println("ok");
%>