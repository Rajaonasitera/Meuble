<%@ page import="com.example.meuble.model.Style" %>
<%@ page import="com.example.meuble.model.Categorie" %>
<%@ page import="com.example.meuble.model.Volume" %>
<%--
  Created by IntelliJ IDEA.
  User: taraj
  Date: 11/12/2023
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Style[] allS = (Style[]) request.getAttribute("style");
    Categorie[] allC = (Categorie[]) request.getAttribute("categorie");
    Volume[] allV = (Volume[]) request.getAttribute("volume");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertion Meuble</title>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <%@include file="./Header.jsp"%>
</head>
<body style="background-color:#e7e7e7;">
        
          <center>
        
            <div class="row" style="margin-top: 100px;width:500px ;padding-left: 40px;height: 400px;border-radius: 10px;background-color: white;box-shadow:0 5px 10px rgba(0, 0, 0, 0.05);padding-right: 30px;">
                <h1>Veuillez inserer un meuble</h1>
                <form class="form-horizontal" action="InsertionMeuble" method="get" style="margin-top: 70px; ">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Style</label>
                        <div class="col-sm-10 col-lg-4">
                         <select name="style" id="" class="form-control">
                             <%
                                 for (int i = 0; i < allS.length; i++) {%>
                             <option value="<%out.print(allS[i].getId_style());%>"><%out.print(allS[i].getLibelle());%></option>
                             <%}%>
                         </select>

                        </div>
                      </div>
                      <div class="form-group">
                          <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Categorie</label>
                          <div class="col-sm-10 col-lg-4">
                           <select name="categorie" id="" class="form-control">
                               <%
                                   for (int i = 0; i < allC.length; i++) {%>
                               <option value="<%out.print(allC[i].getId_categorie());%>"><%out.print(allC[i].getLibelle());%></option>
                               <%}%>
                           </select>

                          </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Volume</label>
                            <div class="col-sm-10 col-lg-4">
                             <select name="volume" id="" class="form-control">
                                 <%
                                     for (int i = 0; i < allV.length; i++) {%>
                                 <option value="<%out.print(allV[i].getId_volume());%>"><%out.print(allV[i].getLibelle());%></option>
                                 <%}%>
                             </select>
                             </select>
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Prix</label>
                            <div class="col-sm-10 col-lg-4">
                             <input type="text" class="form-control" name="prix" placeholder="prix">
                            </div>
                          </div>
                      
                    <div class="form-group">
                        <button style="
                        margin-top: 20px;" type="submit" class="btn btn-primary">Confirmer</button>
                    </div>
                  </form>
                  
                </div>
            
        </center>
        

    
</body>
</html>
