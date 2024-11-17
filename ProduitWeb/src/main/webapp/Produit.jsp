<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Gestion des produits</title>
<style>
    body {
        background-color: #121212;
        color: #ffffff;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }

    th, td {
        border: 1px solid #333333;
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #1e1e1e;
    }

    td {
        background-color: #1c1c1c;
    }

    input, select, button {
        background-color: #333333;
        color: #ffffff;
        border: 1px solid #444444;
        padding: 5px 10px;
        border-radius: 5px;
    }
    
    input[type="text"]{
    	width: 90%;
    }

    input[type="submit"] {
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #555555;
    }

    a {
        color: #1e90ff;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    div {
        margin: 20px;
    }

    nav {
        margin-top: 20px;
        text-align: center;
    }

    nav a {
        font-size: 18px;
        background-color: #333333;
        padding: 10px 20px;
        border-radius: 5px;
    }

    nav a:hover {
        background-color: #555555;
    }
</style>
</head>
<body>
    <div id="formProduit">
        <form action="controleur.do" method="post">
            <table>
                <tr>
                    <td>Code :</td>
                    <td><input type="text" name="code"></td>
                </tr>
                <tr>
                    <td>Designation :</td>
                    <td><input type="text" name="designation"></td>
                </tr>
                <tr>
                    <td>Prix :</td>
                    <td><input type="text" name="prix"></td>
                </tr>
                <tr>
                    <td>Quantite :</td>
                    <td><input type="text" name="quantite"></td>
                </tr>
                <tr>
                    <td>Categorie :</td>
                    <td>
                        <select name="categorie" id="categorie">
                            <c:forEach items="${categories}" var="cat">
                                <option value="${cat.libelle}">${cat.libelle}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Ajouter">
                        <input type="submit" name="action" value="Modifier">
                        <input type="submit" name="action" value="Rechercher">
                        <input type="submit" name="action" value="+ Quantite">
                        <input type="submit" name="action" value="- Quantite">
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div>
        <table>
            <tr>
                <th>Code</th>
                <th>Designation</th>
                <th>Prix</th>
                <th>Quantite</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${produits}" var="pr">
                <tr>
                    <td>${pr.code}</td>
                    <td>${pr.libelle}</td>
                    <td>${pr.prix}</td>
                    <td>${pr.quantite}</td>
                    <td>
                        <form action="Categorie.do" method="post" style="display:inline;">
                            <input type="hidden" name="codeToDelete" value="${pr.code}">
                            <input type="submit" name="action" value="Supprimer">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <nav>
        <a href="Categorie.jsp">Go to Categorie Form</a>
    </nav>
</body>
</html>
