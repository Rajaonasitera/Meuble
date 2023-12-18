<%--
  Created by IntelliJ IDEA.
  User: taraj
  Date: 11/12/2023
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Accueil</title>
  <link rel="stylesheet" href="resources/css/bootstrap.css">
  <link rel="stylesheet" href="resources/css/index.css">
</head>
<%@include file="./Header.jsp"%>
<body style="background-color:#e7e7e7;">
<center>

  <div class="row" style="margin-top: 100px;width:500px ;padding-left: 40px;height: 400px;border-radius: 10px;background-color: white;box-shadow:0 5px 10px rgba(0, 0, 0, 0.05);padding-right: 30px;">
    <h1>Veuillez inserer une style</h1>
    <form class="form-horizontal" action="InsertionVolume" method="get" style="margin-top: 70px; ">
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">libelle</label>
        <div class="col-sm-10 col-lg-4">
          <input class="form-control" type="text" name="libelle" placeholder="libelle">
        </div>
      </div>

      <div class="form-group">
        <button style="
                        margin-top: 50px;" type="submit" class="btn btn-primary">Confirmer</button>
      </div>
    </form>

  </div>

</center>



</body>
</html>
