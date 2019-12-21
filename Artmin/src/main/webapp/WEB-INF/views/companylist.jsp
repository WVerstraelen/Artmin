<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Companies</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
 
 
<body>
    
    <h2>List of Companies</h2>  
    <table>
        <tr>
            <td>ID</td>
            <td>Companyname</td>
            <td></td>
            <td></td>
        </tr>
        
        <c:forEach items="${companies}" var="company">
            <tr>
            <td>${company.id}</td>
            <td>${company.name}</td>
            <td><a href="<c:url value='/company/edit-${company.id}-company' />">edit</a></td>
            <td><a href="<c:url value='/company/delete-${company.id}-company' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/company/new' />">Add New Company</a>
</body>
</html>
