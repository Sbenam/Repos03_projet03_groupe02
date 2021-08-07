
function connect(){
    console.log("test")

    document.body.innerHTML +="<section class=\"conexion-popup\"><div class=\"container-fluid\"><div class=\"row justify-content-md-center\"><div class=\"col-3\"></div><div class=\"col-9\"><ul class=\"breadcrumbs\"><li><a href=\"\" class=\"current\">1. Email </a></li><li><a href=\"\">2. Vos informations</a></li><li><a href=\"\">3. Vos coordonnées</a></li></ul><h3>Rejoignez la communauté</h3><h5>Venez faire paturer votre terrain</h5><div class=\"mb-3 align-left\"><label for=\"emailInput\" class=\"form-label\">Votre email</label><input type=\"email\" class=\"form-control\" id=\"emailInput\" placeholder=\"jerome@Gmail.com\"><label for=\"password-input\" class=\"form-label \">Votre mot de passe</label><input type=\"password\" class=\"form-control\" id=\"password-input\" rows=\"3\"></input><label for=\"repeat-password-input\" class=\"form-label \">Confirmer votre mot de passe</label><input type=\"password\" class=\"form-control\" id=\"repeat-password-input\" rows=\"3\"></input><div class=\"inline-input\"><input class=\"form-check-input \" type=\"checkbox\" value=\"\" id=\"flexCheckChecked\" checked><label class=\"form-check-label\" for=\"flexCheckChecked\">J'ai lu et j'accepte les conditions d'utilisation</label></div><div class=\"d-grid gap-2\"><button class=\"btn btn-primary \" type=\"submit\" onclick=informations2()>Submit form</button></div></div></div></div></div></section>"
}

function informations2(){
    document.body.innerHTML +="<section class=\"conexion-popup\"><div class=\"container-fluid\"><div class=\"row justify-content-md-center\"><div class=\"col-3\"></div><div class=\"col-9\"><ul class=\"breadcrumbs\"><li><a href=\"\">1. Email </a></li><li><a href=\"\" class=\"current\">2. Vos informations</a></li><li><a href=\"\">3. Vos coordonnées</a></li></ul><h3>Rejoignez la communauté</h3><h5>Venez faire paturer votre terrain</h5><div class=\"mb-3 align-left\"><label for=\"surnameInput\" class=\"form-label\">Nom</label><input type=\"text\" class=\"form-control\" id=\"nameInput\" placeholder=\"Cuquemy\"><label for=\"name-input\" class=\"form-label \">Prénom</label><input type=\"text\" class=\"form-control\" id=\"name-input\" rows=\"3\" placeholder=\"Paul\"></input><label for=\"birth-date-input\" class=\"form-label \">Date de naissance</label><input type=\"date\" class=\"form-control\" id=\"birth-date-input\" rows=\"3\"></input><label for=\"phone-input\" class=\"form-label \">Numéro de téléphone</label><input type=\"tel\" class=\"form-control\" id=\"phone-input\" rows=\"3\"placeholder=\"0612345678\"></input><div class=\"d-grid gap-2\"><button class=\"btn btn-primary \" type=\"submit\" onclick=informations3()>Suite</button></div></div></div></div></div></section>"

}

function informations3(){
    document.body.innerHTML +="<section class=\"conexion-popup\"><div class=\"container-fluid\"><div class=\"row justify-content-md-center\"><div class=\"col-3\"></div><div class=\"col-9\"><ul class=\"breadcrumbs\"><li><a href=\"\">1. Email </a></li><li><a href=\"\">2. Vos informations</a></li><li><a href=\"\" class=\"current\">3. Vos coordonnées</a></li></ul><h3>Rejoignez la communauté</h3><h5>Venez faire paturer votre terrain</h5><div class=\"mb-3 align-left\"><div class=\"padding-form\"><label for=\"adresse-input\" class=\"form-label\">Adresse</label><input type=\"text\" class=\"form-control\" id=\"adresse-input\" placeholder=\"149 rue J.B Charcot\"><label for=\"zipcode-input\" class=\"form-label \">Code postal</label><input type=\"number\" class=\"form-control\" id=\"zipcode-input\" rows=\"3\"placeholder=\"92400\"></input><div class=\"d-grid gap-2\"><button class=\"btn btn-primary \" type=\"submit\" >Fin</button></div></div></div></div></div></div></section>"

}

/* global bootstrap: false */
(function () {
  'use strict'
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  tooltipTriggerList.forEach(function (tooltipTriggerEl) {
    new bootstrap.Tooltip(tooltipTriggerEl)
  })
})()
