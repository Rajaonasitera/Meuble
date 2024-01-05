<%@ page import="com.example.meuble.model.AffichageQuantite" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AffichageQuantite[] allAQ = (AffichageQuantite[]) request.getAttribute("allAQ");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil</title>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/index.css">
</head>
<body style="background-color:#e7e7e7;">
        <nav class="navbar">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" style="margin-left: 30px;font-family: 'Bauhaus 93';" href="#">FANAKA</a>
              </div>
          
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
                <ul class="nav navbar-nav" style="
                margin-left: 600px;">
                 <li class="active"><a href="index.jsp">Accueil <span class="sr-only">(current)</span></a></li>
                 <li class="active"><a href="PageInsertionStyle">Insert Style <span class="sr-only">(current)</span></a></li>
                 <li class="active"><a href="PageInsertionCategorie">Insert Categorie <span class="sr-only">(current)</span></a></li>
                 <li class="active"><a href="PageInsertionMateriel">Insert Materiel <span class="sr-only">(current)</span></a></li>
                 <li class="active"><a href="PageInsertionVolume">Insert Volume <span class="sr-only">(current)</span></a></li>
                 <li class="active"><a href="PageInsertionMeuble">Insert Meuble <span class="sr-only">(current)</span></a></li>
                 <li class="active"><a href="PageInsertionStyleMateriel">Insert Style Materiel <span class="sr-only">(current)</span></a></li>            
                  <li><a href="#">Contactez-nous</a></li>
                 
                  <li><a href="#">Contactez-nous</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="#">Link</a></li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Action</a></li>
                      <li><a href="#">Another action</a></li>
                      <li><a href="#">Something else here</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="#">Separated link</a></li>
                    </ul>
                  </li>
                </ul>
              </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
          </nav>
          
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
        <h1>Scandinave</h1>
        <div style="width: 80px;height: 5px;background: #337ab7;border-radius: 7px;margin-bottom: 50px;"></div>
        <table class='table table-hover'>
            <tr>
                <th>Meuble</th>
                <th>Taille</th>
                <th>Quantite</th>
            </tr>
            <tr>
                <% for (int i = 0; i < allAQ.length; i++) {%>
                <td><%out.print(allAQ[i].getCategorie().getLibelle());%></td>
                <td><%out.print(allAQ[i].getVolume().getLibelle());%></td>
                <td><%out.print(allAQ[i].getQuantite());%></td>
                <%}%>
            </tr>

        </table>
           
            
        </center>
        

    
</body>
</html>