<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Company Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Company Registration Form</h2>
  
    <form:form method="POST" modelAttribute="company">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <!-- Artist Name -->
            <tr>
                <td><label for="name">Company name: </label> </td>
                <td><form:input path="name" id="name"/></td>
            </tr>
            
            <!-- Manager -->
            <tr>
                <td><label for="manager">Manager: </label> </td>
                <td><form:input path="manager" id="manager"/></td>
            </tr>
            
            <!-- Street -->
            <tr>
                <td><label for="street">Street: </label> </td>
                <td><form:input path="street" id="street"/></td>
            </tr>
            
            <!-- Number -->
            <tr>
                <td><label for="nrBus">Number/Bus: </label> </td>
                <td><form:input path="nrBus" id="nrBus"/></td>
            </tr>
            
            <!-- Postal Code -->
            <tr>
                <td><label for="postCode">Postal code: </label> </td>
                <td><form:input path="postCode" id="postCode"/></td>
            </tr>
            
            <!-- City -->
            <tr>
                <td><label for="city">City: </label> </td>
                <td><form:input path="city" id="city"/></td>
            </tr>
            
            <!-- Country -->
            <tr>
                <td><label for="country">Country: </label> </td>
                <td><form:input path="country" id="country"/></td>
            </tr>
            
            <!-- Phone -->
            <tr>
                <td><label for="phone">Phone: </label> </td>
                <td><form:input path="phone" id="phone"/></td>
            </tr>
            
            <!-- VAT -->
            <tr>
                <td><label for="vat">VAT: </label> </td>
                <td><form:input path="vat" id="vat"/></td>
            </tr>
            
            <!-- Email -->
            <tr>
                <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
            </tr>
            
            <!-- Logo -->
            <tr>
                <td><label for="logoFilePath">Log URL: </label> </td>
                <td><form:input path="logoFilePath" id="logoFilePath"/></td>
            </tr>
            
            <!-- Bank -->
            <tr>
                <td><label for="bankAccount">Bank Account: </label> </td>
                <td><form:input path="bankAccount" id="bankAccount"/></td>
            </tr>
            
            <!-- LegalLine -->
            <tr>
                <td><label for="vatLegalLine">Legal Line: </label> </td>
                <td><form:input path="vatLegalLine" id="vatLegalLine"/></td>
            </tr>
            
            <!-- InvoicePrefix -->
            <tr>
                <td><label for="invoicePreFix">Invoice Prefix: </label> </td>
                <td><form:input path="invoicePreFix" id="invoicePreFix"/></td>
            </tr>
            
            <!-- InvoiceNumber -->
            <tr>
                <td><label for="firstInvoiceNumber">Invoice Number: </label> </td>
                <td><form:input path="firstInvoiceNumber" id="firstInvoiceNumber"/></td>
            </tr>
            
            <!-- Terms -->
            <tr>
                <td><label for="termsAndConditionsUrl">Terms and Conditions: </label> </td>
                <td><form:input path="termsAndConditionsUrl" id="termsAndConditionsUrl"/></td>
            </tr>
                        
         
            <tr>
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td>
                    ${message}
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/company/list' />">List of All Companies </a>
</body>
</html>