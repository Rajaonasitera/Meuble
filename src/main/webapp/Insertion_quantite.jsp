<%@ page import="com.example.meuble.connection.Connect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.meuble.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Style_materiel[] allSM = (Style_materiel[]) request.getAttribute("allSM");
    Categorie[] allC = (Categorie[]) request.getAttribute("allC");
    Volume[] allV = (Volume[]) request.getAttribute("allV");
    Style[] allSt = (Style[]) request.getAttribute("allSt");
    Materiel[] allM = (Materiel[]) request.getAttribute("allM");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body style="background-color:#e7e7e7;">
          
          <div style="padding-left: 60px;padding-right: 60px;box-sizing: border-box;">
            <div class="details" style="height: 140px;background-color: white;border-radius: 20px;box-shadow:0 5px 10px rgba(0, 0, 0, 0.05);display: flex;">
              <div class="logo">  
                <img width="80px" src="images/logo.jpg" style=" margin-top: 18px;margin-left: 30px;" alt="">
              </div>
              <div class="infoResto" style="padding-left: 20px;padding-top: 10px;">
                <h3>FANAKA</h3>
                <p style="margin-left: 30px;color: gray;"><span class="glyphicon glyphicon-map-marker"></span> Andoharanofotsy</p>
              </div>  
            </div>
          </div>
          <center>
        
            <div class="row" style="margin-top: 100px;width:500px ;padding-left: 40px;height: 400px;border-radius: 10px;background-color: white;box-shadow:0 5px 10px rgba(0, 0, 0, 0.05);padding-right: 30px;">
                <h1>Veuillez inserer un quantite</h1>
                <form class="form-horizontal" action="Insert" method="post" style="margin-top: 70px; ">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Style et materiaux</label>
                      <div class="col-sm-10 col-lg-3">
                       <select name="stylemateriaux" id="" class="form-control">
                           <% for (int i = 0; i < allSM.length; i++) {%>
                               <option value="<%out.print(allSM[i].getId_style_materiel());%>"><%out.print(allSt[i].getLibelle());%> , <%out.print(allM[i].getLibelle());%></option>
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
<%}catch (Exception e){

}
%>