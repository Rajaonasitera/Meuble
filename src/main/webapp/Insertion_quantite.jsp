<%@ page import="com.example.meuble.connection.Connect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.meuble.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Style[] allS = (Style[]) request.getAttribute("allS");
    Categorie[] allC = (Categorie[]) request.getAttribute("allC");
    Volume[] allV = (Volume[]) request.getAttribute("allV");
    Materiel[] allM = (Materiel[]) request.getAttribute("allM");
    Style_materiel[] allSM = (Style_materiel[]) request.getAttribute("allSM");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertion quantite</title>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <%@include file="./Header.jsp"%>
</head>

<body style="background-color:#e7e7e7;">
          <center>
        
            <div class="row" style="margin-top: 100px;width:500px ;padding-left: 40px;height: 400px;border-radius: 10px;background-color: white;box-shadow:0 5px 10px rgba(0, 0, 0, 0.05);padding-right: 30px;">
                <h1>Veuillez inserer un quantite</h1>
                <form class="form-horizontal" action="InsertionQuantite" method="get" style="margin-top: 70px; ">
                    <div class="form-group" >
                      <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Style et materiaux</label>
                      <div class="col-sm-10 col-lg-3">
                       <select name="styleMateriel" id="" class="form-control" style="width: 200px">
                           <% for (int i = 0; i < allSM.length; i++) {%>
                               <option value="<%out.print(allSM[i].getId_style());%>"><%out.print(allS[i].getLibelle());%> , <%out.print(allM[i].getLibelle());%></option>
                           <%}%>
                       </select>
                      </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Categorie</label>
                        <div class="col-sm-10 col-lg-3">
                         <select name="categorie" id="" class="form-control">
                             <% for (int i = 0; i < allC.length; i++) {%>
                             <option value="<%out.print(allC[i].getId_categorie());%>"><%out.print(allC[i].getLibelle());%> </option>
                             <%}%>
                         </select>
                        </div>
                      </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Volume</label>
                        <div class="col-sm-10 col-lg-3">
                            <select name="volume" id="" class="form-control">
                                <% for (int i = 0; i < allV.length; i++) {%>
                                <option value="<%out.print(allV[i].getId_volume());%>"><%out.print(allV[i].getLibelle());%> </option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                      <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Quantite</label>
                        <div class="col-sm-10 col-lg-3">
                         <input type="number" name="quantite" id="" class="form-control" value="1">
                        </div>
                      </div>
                    
                    <div class="form-group">
                        <button style="
                        margin-top: 40px;" type="submit" class="btn btn-primary">Inserer</button>
                    </div>
                  </form>
                  
                </div>
            
        </center>
        

    
</body>
</html>
