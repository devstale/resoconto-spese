<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Material Design icon font -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" type="text/css">
		<!-- Material Design Lite -->
		<script src="<spring:url value="/resources/vendor/material-design-lite/material.min.js"/>"></script>
		<link href="<spring:url value="/resources/vendor/material-design-lite/material.min.css"/>" rel="stylesheet" type="text/css">
		<!-- Font Awesome -->
		<link href="<spring:url value="/resources/vendor/fontAwesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
		<!-- Handlebars -->
		<script src="<spring:url value="/resources/vendor/handlebars/handlebars-v4.0.10.js"/>"></script>
		<!-- jQuery -->
		<script src="<spring:url value="/resources/vendor/jQuery/jquery-3.2.1.min.js"/>"></script>
		<!-- Load the css and js file in your document -->
		<link href="<spring:url value="/resources/vendor/HoldOn/HoldOn.min.css"/>" rel="stylesheet" type="text/css">
		<script src="<spring:url value="/resources/vendor/HoldOn/HoldOn.min.js"/>"></script>
		<!-- custom -->
		<script src="<spring:url value="/resources/js/homeController.js"/>"></script>
		<script src="<spring:url value="/resources/js/loader.js"/>"></script>
		<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.teal-green.min.css" type="text/css"/>
	</head>
	
	
	<body>
		<div class="mdl-layout__container">
  
			<!-- Always shows a header, even in smaller screens. -->
			<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header mdl-layout--fixed-tabs">
				<header class="mdl-layout__header">
					<div class="mdl-layout__header-row">
						<!-- Title -->
						<span class="mdl-layout-title">
							Resoconto Spese
						</span>
						<!-- Add spacer, to align navigation to the right -->
						<div class="mdl-layout-spacer"></div>
						<!-- Navigation. We hide it in small screens. -->
						<nav class="mdl-navigation mdl-layout--large-screen-only">
							<a class="mdl-navigation__link" href=""></a>
							<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" 
								onclick="apriModaleConnettiti()" style="margin-right: 20px;">Connettiti
							</button>
							<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" 
								onclick="apriModaleIscriviti()">Iscriviti
							</button>
						</nav>
					</div>
				</header>
				<div class="mdl-layout__drawer">
					<span class="mdl-layout-title">
						Resoconto Spese
					</span>
					<nav class="mdl-navigation">
						<a class="mdl-navigation__link" onclick="apriModaleConnettiti()">Connettiti</a>
						<a class="mdl-navigation__link" onclick="apriModaleIscriviti()">Iscriviti</a>
					</nav>
				</div>
				<main class="mdl-layout__content">
				
					<!-- PAGE CONTENT -->				
					<div class="page-content" style="height: 300px;">
						
						prova
						
						
					</div>
					<!-- END PAGE CONTENT -->
					
					<footer class="mdl-mega-footer">
					  <div class="mdl-mega-footer__middle-section">

						<div class="mdl-mega-footer__drop-down-section">
						  <input class="mdl-mega-footer__heading-checkbox" type="checkbox" checked>
						  <h1 class="mdl-mega-footer__heading">Features</h1>
						  <ul class="mdl-mega-footer__link-list">
							<li><a href="#">About</a></li>
							<li><a href="#">Terms</a></li>
							<li><a href="#">Partners</a></li>
							<li><a href="#">Updates</a></li>
						  </ul>
						</div>

						<div class="mdl-mega-footer__drop-down-section">
						  <input class="mdl-mega-footer__heading-checkbox" type="checkbox" checked>
						  <h1 class="mdl-mega-footer__heading">Details</h1>
						  <ul class="mdl-mega-footer__link-list">
							<li><a href="#">Specs</a></li>
							<li><a href="#">Tools</a></li>
							<li><a href="#">Resources</a></li>
						  </ul>
						</div>

						<div class="mdl-mega-footer__drop-down-section">
						  <input class="mdl-mega-footer__heading-checkbox" type="checkbox" checked>
						  <h1 class="mdl-mega-footer__heading">Technology</h1>
						  <ul class="mdl-mega-footer__link-list">
							<li><a href="#">How it works</a></li>
							<li><a href="#">Patterns</a></li>
							<li><a href="#">Usage</a></li>
							<li><a href="#">Products</a></li>
							<li><a href="#">Contracts</a></li>
						  </ul>
						</div>

						<div class="mdl-mega-footer__drop-down-section">
						  <input class="mdl-mega-footer__heading-checkbox" type="checkbox" checked>
						  <h1 class="mdl-mega-footer__heading">FAQ</h1>
						  <ul class="mdl-mega-footer__link-list">
							<li><a href="#">Questions</a></li>
							<li><a href="#">Answers</a></li>
							<li><a href="#">Contact us</a></li>
						  </ul>
						</div>

					  </div>

					  <div class="mdl-mega-footer__bottom-section">
						<div class="mdl-logo">Resoconto Spese</div>
						<ul class="mdl-mega-footer__link-list">
						  <li><a href="#">Help</a></li>
						  <li><a href="#">Privacy and Terms</a></li>
						</ul>
					  </div>

					</footer>
					
				</main>
			</div>
			
		</div>
		
		<!-- DIALOG -->
		<dialog class="mdl-dialog" id="modale-connettiti">
			<form action='<spring:url value="/loginAction"/>' method="post">
				<div class="mdl-dialog__content">
					<p>
						Inserisci le tue credenziali per accedere.
					</p>
						<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<input class="mdl-textfield__input" type="text" id="username" name="username">
							<label class="mdl-textfield__label" for="sample3">Username</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<input class="mdl-textfield__input" type="password" id="password" name="password">
							<label class="mdl-textfield__label" for="password">Password</label>
						</div>
				</div>
				<div class="mdl-dialog__actions">
					<button class="mdl-button" type="submit">Connettiti</button>
					<button type="button" class="mdl-button close" onclick="closest('dialog').close();">Annulla</button>
				</div>
			</form>
		</dialog>
		<dialog class="mdl-dialog" id="modale-iscriviti">
			<div class="mdl-dialog__content">
				<p>
					Inserisci le informazioni richieste per completare l'iscrizione.
				</p>
				<form action="#">
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="nome">
						<label class="mdl-textfield__label" for="nome">Nome</label>
					</div>
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="cognome">
						<label class="mdl-textfield__label" for="cognome">Cognome</label>
					</div>
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="nuovoUsername">
						<label class="mdl-textfield__label" for="username">Username</label>
					</div>
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="email" id="email">
						<label class="mdl-textfield__label" for="email">Email</label>
					</div>
				</form>
			</div>
			<div class="mdl-dialog__actions">
				<button type="button" class="mdl-button">Iscriviti</button>
				<button type="button" class="mdl-button close" onclick="closest('dialog').close();">Annulla</button>
			</div>
		</dialog>

		
	</body>
  
</html>