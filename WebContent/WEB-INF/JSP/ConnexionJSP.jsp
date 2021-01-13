<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8 ">
<title>Connexion</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/ConnexionCSS.css" />
</head>
<body>
<div>
        <br><label for="name">Nom :</label>
        <input type="text" id="name" name="user_name">
        
    </div>
    <div>
        <br><label for="mail">e-mail :</label>
        <input type="email" id="mail" name="user_mail">
    </div>
    <div>
        <br><label for="msg">Message :</label>
         <br><textarea id="msg" name="user_message"></textarea> <br>
        <br><button class="button"  type="submit" value="VALIDER">Valider</button>
        
    </div>
  <br><a href="/ProjetApplication/Accueil">Retour accueil</a>
</body>
</html>