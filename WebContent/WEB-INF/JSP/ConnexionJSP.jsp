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
        <form method="post" action="Connexion">
            <fieldset>
                <legend>Connexion utilisateur</legend>
                <p>Vous pouvez vous connecter en renseignant les champs ci-dessous.</p>
                
                <label for="nom">Pseudo</label>
                <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />
                <br />
 
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />
 
                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />
 
               
 
                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>
