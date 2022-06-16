<%@page import="Util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		DBManager.getConnection();
		out.println("ok");
%>