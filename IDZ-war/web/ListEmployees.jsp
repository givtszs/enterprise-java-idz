<%-- 
    Document   : ListEmployees
    Created on : Nov 9, 2024, 2:08:11 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees List</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px 12px;
                border: 1px solid #ddd;
            }
            th {
                background-color: #f2f2f2;
            }
            body {
                min-height: 100%;
            }
        </style>
    </head>
    <body>
        <h1>Employees</h1>
        <a href="AddEmployee">Add employee</a>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Position</th>
<!--                    <th>Degree</th>
                    <th>Rank</th>-->
                    <th>Courses</th>
                    <th>Academic Load</th>
                    <th>Research Activity</th>
                    <th>Organizational Work</th>
                    <th>Part-Time Job</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Birthday</th>
                    <th>Sex</th>
                    <th>Hobby</th>
                    <!--<th>HR Info</th>-->
                </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.middleName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.position}</td>
                    <td>${employee.courses}</td>
                    <td>${employee.academicLoad}</td>
                    <td>${employee.researchActivity}</td>
                    <td>${employee.organizationalWork}</td>
                    <td>${employee.partTimeJob}</td>
                    <td>${employee.address}</td>
                    <td>${employee.phoneNumber}</td>
                    <td>${employee.email}</td>
                    <td>${employee.birthday}</td>
                    <td>${employee.sex}</td>
                    <td>${employee.hobby}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
