<%-- 
    Document   : AddEmployee
    Created on : Nov 7, 2024, 10:52:47 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Додати співробітника</title>
    </head>
    <body>
        <h1>Дані співробітника</h1>

    <!-- Form to create the entity object -->
    <form action="createEntityServlet" method="post">
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
            <label for="degree">Degree:</label>
            <select id="degree" name="degree">
                <!-- Populate with degree options from database -->
            </select>
        </div>

        <div>
            <label for="rank">Rank:</label>
            <select id="rank" name="rank">
                <!-- Populate with rank options from database -->
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
