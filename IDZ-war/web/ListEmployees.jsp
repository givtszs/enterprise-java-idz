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
        <div class="header-section">
            <h1>Employees</h1>
            <a href="AddEmployee" class="add-button">Add employee</a>
        </div>

        <div class="filter-section">
            <form action="ListEmployees" method="get">
                <label for="academicDegree">Filter by academic degree:</label>
                <select name="academicDegree" id="academicDegree" onchange="this.form.submit()">
                    <option value="">All Degrees</option>
                    <option value="null" ${param.academicDegree == 'null' ? 'selected' : ''}>Відсутній</option>
                    <c:forEach items="${degrees}" var="degree">
                        <option value="${degree.id}" ${param.academicDegree eq degree.id ? 'selected' : ''}>
                            ${degree.name}
                        </option>
                    </c:forEach>
                </select>
            </form>
        </div>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Position</th>
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
                    <th>Academic degree</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employees}" var="employee">
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
                        <td>${employee.academicDegree eq null ? 'Відсутній' : employee.academicDegree.name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
