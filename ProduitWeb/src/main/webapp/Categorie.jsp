<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Catégories</title>
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
        
        input[type="text"]{
    	width: 90%;
   		}
        

        input, select, button {
            background-color: #333333;
            color: #ffffff;
            border: 1px solid #444444;
            padding: 5px 10px;
            border-radius: 5px;
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

    <div id="formCategorie">
        <form action="Categorie.do" method="post">
            <table>
                <tr>
                    <td>Code :</td>
                    <td><input type="text" name="codeCat"></td>
                </tr>
                <tr>
                    <td>Libelle :</td>
                    <td><input type="text" name="libelle"></td>
                </tr>
                <tr>
                    <td>Description :</td>
                    <td><input type="text" name="description"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="AjouterCat">
                        <input type="submit" name="action" value="ModifierCat">
                        <input type="submit" name="action" value="RechercherCat">
                    </td>
                </tr>
            </table>
        </form>
    </div>


    <div>
        <table>
            <tr>
                <th>Code</th>
                <th>Libelle</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${categories}" var="ct">
                <tr>
                    <td>${ct.code}</td>
                    <td>${ct.libelle}</td>
                    <td>${ct.description}</td>
                    <td>
                        <form action="Categorie.do" method="post" style="display:inline;">
                            <input type="hidden" name="codeToDeleteCat" value="${ct.code}">
                            <input type="submit" name="action" value="SupprimerCat">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


    <nav>
        <a href="Produit.jsp">Go to Produit Form</a>
    </nav>
</body>
</html>
