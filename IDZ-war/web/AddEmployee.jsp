<%-- 
    Document   : AddEmployee
    Created on : Nov 7, 2024, 10:52:47 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Додати співробітника</title>
        <script type="text/javascript">
        // Function to validate the form
        function validateForm() {
            console.log("Validating the form");
            
            const firstName = document.getElementById("firstName").value;
            const middleName = document.getElementById("middleName").value;
            const lastName = document.getElementById("lastName").value;
            const position = document.getElementById("position").value;
            const academicLoad = document.getElementById("academicLoad").value;
            const email = document.getElementById("email").value;
            const birthday = document.getElementById("birthday").value;
            const sex = document.getElementById("sex").value;

            // Validate required fields
            if (firstName.trim() === "" || middleName.trim() === "" || lastName.trim() === "") {
                alert("Full name is required.");
                return false;
            }
         
            if (position.trim() === "") {
                alert("Position is required.");
                return false;
            }
            if (academicLoad.trim() === "" || isNaN(academicLoad) || academicLoad <= 0) {
                alert("Academic Load is required and must be a positive number.");
                return false;
            }
            if (email.trim() === "" || !validateEmail(email)) {
                alert("Please enter a valid email address.");
                return false;
            }
            if (birthday.trim() === "") {
                alert("Birthday is required.");
                return false;
            }
            if (sex === "") {
                alert("Sex is required.");
                return false;
            }

            // All validations passed, submit the form
            return true;
        }

        // Function to validate email format
        function validateEmail(email) {
            const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            return re.test(email);
        }
    </script>
    </head>
    <body>
        <c:if test="${not empty errorMessage}">
            <div style="color: red;">
                <h3>Validation Errors:</h3>
                <p>${errorMessage}</p>
            </div>
        </c:if>
        
        <h1>Дані співробітника</h1>

    <!-- Form to create the entity object -->
    <form method="post" onsubmit="return validateForm()">
        <div>
            <label for="lastName">Прізвище:</label>
            <input type="text" id="lastName" name="lastName" required>
        </div>
        
        <div>
            <label for="lastName">Ім'я:</label>
            <input type="text" id="firstName" name="firstName" required>
        </div>
        
        <div>
            <label for="middleName">По батькові:</label>
            <input type="text" id="middleName" name="middleName" required>
        </div>

        <div>
            <label for="position">Посада:</label>
            <input type="text" id="position" name="position" required>
        </div>

        <div>
            <label for="courses">Дисципліни:</label>
            <input type="text" id="courses" name="courses">
        </div>

        <div>
            <label for="academicLoad">Академічне навантаження:</label>
            <input type="number" id="academicLoad" name="academicLoad" required>
        </div>

        <div>
            <label for="researchActivity">Напрямок наукової діяльності:</label>
            <input type="text" id="researchActivity" name="researchActivity">
        </div>

        <div>
            <label for="organizationalWork">Організаційна робота:</label>
            <input type="text" id="organizationalWork" name="organizationalWork">
        </div>

        <div>
            <label for="partTimeJob">Сумісництво:</label>
            <input type="text" id="partTimeJob" name="partTimeJob">
        </div>

        <div>
            <label for="address">Адреса постійного проживання:</label>
            <input type="text" id="address" name="address" required>
        </div>

        <div>
            <label for="phoneNumber">Номер телефону:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
        </div>

        <div>
            <label for="email">Електронна пошта:</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div>
            <label for="birthday">Дата народження:</label>
            <input type="date" id="birthday" name="birthday" required>
        </div>

        <div>
            <label for="sex">Стать:</label>
            <select id="sex" name="sex">
                <option value="male">Чоловік</option>
                <option value="female">Жінка</option>
            </select>
        </div>

        <div>
            <label for="hobby">Хобі:</label>
            <input type="text" id="hobby" name="hobby">
        </div>

        <!-- Foreign Key fields -->
        <div>
            <label for="academicDegree">Науковий ступень:</label>
            <select name="academicDegree" id="academicDegree">
                <option value="">Відсутній</option>
                <c:forEach items="${degrees}" var="degree">
                    <option value="${degree.id}">
                        ${degree.name}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="academicRank">Вчене звання:</label>
            <select id="academicRank" name="academicRank">
                <option value="">Відсутній</option>
                <c:forEach items="${ranks}" var="rank">
                    <option value="${rank.id}">
                        ${rank.name}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="hrInfo">HR Info:</label>
            <select id="hrInfo" name="hrInfo">
                <!-- Populate with HR info options from database -->
            </select>
        </div>

        <div>
            <button type="submit">Додати</button>
        </div>
    </form>
    </body>
</html>
