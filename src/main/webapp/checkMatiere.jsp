<%@ page import="com.example.meuble.model.Materiel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Materiel[] allM = (Materiel[]) request.getAttribute("materiel");
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
                <h1>Choisissez une matière </h1>
                <form class="form-horizontal" action="Insert" method="post" style="margin-top: 70px; ">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label col-lg-4">Matière</label>
                      <div class="col-sm-10 col-lg-3">
                       <select name="materiel" id="" class="form-control">
                           <%
                               for (int i = 0; i < allM.length; i++) {%>
                                    <option value="<%out.print(allM[i].getId_materiel());%>"> <%out.print(allM[i].getLibelle());%></option>
                              <% }%>
                       </select>
                      </div>
                    </div>
                    
                    <div class="form-group">
                        <button style="
                        margin-top: 50px;" type="submit" class="btn btn-primary">Voir liste meubles</button>
                    </div>
                  </form>
                  
                </div>
            
        </center>
        

    
</body>
</html>