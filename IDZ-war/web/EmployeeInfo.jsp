<%-- 
    Document   : EmployeeInfo
    Created on : Nov 9, 2024, 10:52:45 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Дані про співробітника</title>
    </head>
    <body>
        <a href="ListEmployees">Home</a>
        <h1>Дані про співробітника</h1>

        <c:if test="${not empty employee}">
            <div>
                <p><strong>Прізвище:</strong> ${employee.lastName}</p>
                <p><strong>Ім'я:</strong> ${employee.firstName}</p>
                <p><strong>По батькові:</strong> ${employee.middleName}</p>
                <p><strong>Посада:</strong> ${employee.position}</p>
                <p><strong>Дисципліни:</strong> ${employee.courses}</p>
                <p><strong>Академічне навантаження:</strong> ${employee.academicLoad}</p>
                <p><strong>Напрямок наукової діяльності:</strong> ${employee.researchActivity}</p>
                <p><strong>Організаційна робота:</strong> ${employee.organizationalWork}</p>
                <p><strong>Сумісництво:</strong> ${employee.partTimeJob}</p>
                <p><strong>Адреса постійного проживання:</strong> ${employee.address}</p>
                <p><strong>Номер телефону:</strong> ${employee.phoneNumber}</p>
                <p><strong>Електронна пошта:</strong> ${employee.email}</p>
                <p><strong>Дата народження:</strong> ${employee.birthday}</p>
                <p><strong>Стать:</strong> ${employee.sex}</p>
                <p><strong>Хобі:</strong> ${employee.hobby}</p>
            </div>

            <div>
                <p><strong>Науковий ступінь:</strong> ${employee.academicDegree.name}</p>
                <p><strong>Вчене звання:</strong> ${employee.academicRank.name}</p>
            </div>

            <div>
                <p><strong>Дата прийняття на посаду:</strong> ${employee.contractInfo.hiringDate}</p>
                <p><strong>Дата початку контракту:</strong> ${employee.contractInfo.contractStartDate}</p>
                <p><strong>Дата завершення контракту:</strong> ${employee.contractInfo.contractEndDate}</p>
                <p><strong>Дата початку останньої відпустки:</strong> ${employee.contractInfo.prevVacationStartDate}</p>
                <p><strong>Дата завершення останньої відпустки:</strong> ${employee.contractInfo.prevVacationEndDate}</p>
                <p><strong>Дата початку наступної відпустки:</strong> ${employee.contractInfo.nextVacationStartDate}</p>
                <p><strong>Дата завершення наступної відпустки::</strong> ${employee.contractInfo.nextVacationEndDate}</p>
            </div>
        </c:if>

        <c:if test="${empty employee}">
            <p>Даних про співробітника не знайдено</p>
        </c:if>
    </body>
</html>
