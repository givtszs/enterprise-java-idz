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
                border: 1px solid #000000;
            }
            th {
                background-color: #f5f5f5;
            }
            tr:hover {
                background-color: #f2f2f2;
                cursor: pointer;
            }
            body {
                min-height: 100%;
            }
        </style>
        <script>
            function submitForm(event) {
                console.log('Submitting the form');
                event.preventDefault();

                // Get the selected filter and sort values
                const academicDegree = document.getElementById("academicDegree").value;
                        const academicRank = document.getElementById("academicRank").value;
                        const sortType = document.getElementById("sortType").value;
                        console.log('degree', academicDegree, 'rank', academicRank, 'sort', sortType);

                // Start building the URL
                let url = "ListEmployees?";
                        const params = [];
                        // Add parameters only if they have a value
                        if (academicDegree)
                    params.push("academicDegree=" + encodeURIComponent(academicDegree));
                if (academicRank)
                    params.push("academicRank=" + encodeURIComponent(academicRank));
                if (sortType)
                    params.push("sortType=" + encodeURIComponent(sortType));

                // Append parameters to the URL
                url += params.join("&");

                // Redirect to the new URL
                window.location.href = url;
            }
        </script>
    </head>
    <body>
        <div class="header-section">
            <h1><a href="ListEmployees">Співробітники кафедри</a></h1>
            <a href="AddEmployee" class="add-button">Додати дані співробітника</a>
        </div>

        <div class="filter-section">
            <form method="get">
                <label for="academicDegree">Фільтрувати за науковим ступенем:</label>
                <select name="academicDegree" id="academicDegree" onchange="submitForm(event)">
                    <option value="">Оберіть науковий ступінь</option>
                    <option value="null" ${param.academicDegree == 'null' ? 'selected' : ''}>Відсутній</option>
                    <c:forEach items="${degrees}" var="degree">
                        <option value="${degree.id}" ${param.academicDegree eq degree.id ? 'selected' : ''}>
                            ${degree.name}
                        </option>
                    </c:forEach>
                </select>
                <br/>
                <label for="academicRank">Фільтрувати за вченим званням:</label>
                <select name="academicRank" id="academicRank" onchange="submitForm(event)">
                    <option value="">Оберіть вчене звання</option>
                    <option value="null" ${param.academicRank == 'null' ? 'selected' : ''}>Відсутній</option>
                    <c:forEach items="${ranks}" var="rank">
                        <option value="${rank.id}" ${param.academicRank eq rank.id ? 'selected' : ''}>
                            ${rank.name}
                        </option>
                    </c:forEach>
                </select>
                <label for="sortType">Сортувати за:</label>
                <select name="sortType" id="sortType" onchange="submitForm(event)">
                    <option value="">Оберіть тип сортування</option>
                    <option value="contractEndDate" ${param.sortType eq 'contractEndDate' ? 'selected' : ''}>Дата завершення контракту</option>
                    <option value="nextVacationStartDate" ${param.sortType eq 'nextVacationStartDate' ? 'selected' : ''}>Дата наступної відпустки</option>  
                </select>
            </form>
        </div>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Прізвище</th>
                    <th>Ім'я</th>
                    <th>По батькові</th>
                    <th>Науковий ступінь</th>
                    <th>Вчене звання</th>
                    <th>Дата завершення контракту</th>
                    <th>Дата наступної відпустки</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr onclick="window.location.href = 'ShowEmployee?employeeId=${employee.id}'">
                        <td>${employee.id}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.middleName}</td>
                        <td>${employee.academicDegree eq null ? 'Відсутній' : employee.academicDegree.name}</td>
                        <td>${employee.academicRank eq null ? 'Відсутній' : employee.academicRank.name}</td>
                        <td>${employee.contractInfo.contractEndDate}</td>
                        <td>${employee.contractInfo.nextVacationStartDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
