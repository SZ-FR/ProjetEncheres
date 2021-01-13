<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/InscriptionCSS.css" />

</head>
<body>

		
 <div id="modal-dialog-form" class="dialog-form" title="Mon compte">
 
 
         <img class="img" src="https://fontmeme.com/permalink/210112/fe36ca54d5d57997e31b828b540fcfde.png" alt="script-fonts" border="0">
            
            <form name="form_compte" action="" method="get">
                <br><div class="form-message">Vos informations personnelles</div>
                <br/>
                    <div class="form-label">
                        <label for="fld-pseudo">Pseudo : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-name" type="text" class="fld-field" required="required" placeholder="Bobby" />
                    </div>
                    <br/>
                    <div class="form-label">
                        <label for="fld-name">Nom : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-name" type="text" class="fld-field" required="required" placeholder="Marley" />
                    </div>
                    <br/>
                     <div class="form-label">
                        <label for="fld-first-name">Prénom : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-name" type="text" class="fld-field" required="required" placeholder="Bob" />
                    </div>
                    <br/>
                     <div class="form-line">
                    <div class="form-label">
                        <label for="fld-email">Email : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-email" type="email" class="fld-field" required="required" placeholder="Votre email ?" />
                    </div>
                    <br/>
                    <div class="form-label">
                        <label for="fld-tel">Téléphone : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-tel" type="tel" class="fld-field" required="required" placeholder="Votre téléphone ?" />
                    </div>
                </div>
                <br/>
                <div class="form-label">
                        <label for="fld-adress">Rue : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-name" type="text" class="fld-field"  placeholder="votre rue" />
                    </div>
                    <br/>
                    <div class="form-label">
                        <label for="fld-code-postal">Code postal : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-name" type="text" class="fld-field"  placeholder="75000" />
                    </div>
                    <br/>
                    <div class="form-label">
                        <label for="fld-city">Ville : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-name" type="text" class="fld-field" placeholder="Paris" />
                    </div>
                    <br/>
                <div class="form-line">
                    <div class="form-label">
                        <label for="fld-password">Mot de passe : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-password" type="password" class="fld-field" required="required" />
                    </div>
                    <br/>
                    <div class="form-label">
                        <label for="fld-repeat-password">Répéter le mot de passe : </label>
                    </div>
                    <div class="form-field">
                        <input id="fld-repeat-password" type="password" class="fld-field" required="required" />
                    </div>
                    </div>
                    <br/>
                    
                     <div id="bouton">
                    <input type="reset" name="btAnnuler" value="Annuler" class="boutonForm" title="Annuler" />
                    <input type="submit" name="btValider" value="Valider" class="boutonForm" title="Valider" />
                </div>
            </form>
            </div>

</body>
</html>