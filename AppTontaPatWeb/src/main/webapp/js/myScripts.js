function connect() {
  console.log("test");

  document.body.innerHTML +=
    '<section class="conexion-popup"><div class="container-fluid"><div class="row justify-content-md-center"><div class="col-3"></div><div class="col-9"><ul class="breadcrumbs"><li><a href="" class="current">1. Email </a></li><li><a href="">2. Vos informations</a></li><li><a href="">3. Vos coordonnées</a></li></ul><h3>Rejoignez la communauté</h3><h5>Venez faire paturer votre terrain</h5><div class="mb-3 align-left"><label for="emailInput" class="form-label">Votre email</label><input type="email" class="form-control" id="emailInput" placeholder="jerome@Gmail.com"><label for="password-input" class="form-label ">Votre mot de passe</label><input type="password" class="form-control" id="password-input" rows="3"></input><label for="repeat-password-input" class="form-label ">Confirmer votre mot de passe</label><input type="password" class="form-control" id="repeat-password-input" rows="3"></input><div class="inline-input"><input class="form-check-input " type="checkbox" value="" id="flexCheckChecked" checked><label class="form-check-label" for="flexCheckChecked">J\'ai lu et j\'accepte les conditions d\'utilisation</label></div><div class="d-grid gap-2"><button class="btn btn-primary " type="submit" onclick=informations2()>Submit form</button></div></div></div></div></div></section>';
}

function informations2() {
  document.body.innerHTML +=
    '<section class="conexion-popup"><div class="container-fluid"><div class="row justify-content-md-center"><div class="col-3"></div><div class="col-9"><ul class="breadcrumbs"><li><a href="">1. Email </a></li><li><a href="" class="current">2. Vos informations</a></li><li><a href="">3. Vos coordonnées</a></li></ul><h3>Rejoignez la communauté</h3><h5>Venez faire paturer votre terrain</h5><div class="mb-3 align-left"><label for="surnameInput" class="form-label">Nom</label><input type="text" class="form-control" id="nameInput" placeholder="Cuquemy"><label for="name-input" class="form-label ">Prénom</label><input type="text" class="form-control" id="name-input" rows="3" placeholder="Paul"></input><label for="birth-date-input" class="form-label ">Date de naissance</label><input type="date" class="form-control" id="birth-date-input" rows="3"></input><label for="phone-input" class="form-label ">Numéro de téléphone</label><input type="tel" class="form-control" id="phone-input" rows="3"placeholder="0612345678"></input><div class="d-grid gap-2"><button class="btn btn-primary " type="submit" onclick=informations3()>Suite</button></div></div></div></div></div></section>';
}

function informations3() {
  document.body.innerHTML +=
    '<section class="conexion-popup"><div class="container-fluid"><div class="row justify-content-md-center"><div class="col-3"></div><div class="col-9"><ul class="breadcrumbs"><li><a href="">1. Email </a></li><li><a href="">2. Vos informations</a></li><li><a href="" class="current">3. Vos coordonnées</a></li></ul><h3>Rejoignez la communauté</h3><h5>Venez faire paturer votre terrain</h5><div class="mb-3 align-left"><div class="padding-form"><label for="adresse-input" class="form-label">Adresse</label><input type="text" class="form-control" id="adresse-input" placeholder="149 rue J.B Charcot"><label for="zipcode-input" class="form-label ">Code postal</label><input type="number" class="form-control" id="zipcode-input" rows="3"placeholder="92400"></input><div class="d-grid gap-2"><button class="btn btn-primary " type="submit" >Fin</button></div></div></div></div></div></div></section>';
}

/* global bootstrap: false */
(function () {
  "use strict";
  var tooltipTriggerList = [].slice.call(
    document.querySelectorAll('[data-bs-toggle="tooltip"]')
  );
  tooltipTriggerList.forEach(function (tooltipTriggerEl) {
    new bootstrap.Tooltip(tooltipTriggerEl);
  });
})();





var options = {
  enableHighAccuracy: true,
  timeout: 5000,
  maximumAge: 0,
};

var navLatitude;
var navLongitude;
var mymap
function success(pos) {
  var crd = pos.coords;

  navLatitude = crd.latitude;
  navLongitude = crd.longitude;
  console.log("Votre position actuelle est :");
  console.log(`Latitude : ${crd.latitude}`);
  console.log(`Longitude : ${crd.longitude}`);
  console.log(`La précision est de ${crd.accuracy} mètres.`);
  
 mymap = L.map("mapid").setView([navLatitude, navLongitude], 7);



var greenIcon = new L.Icon({
  iconUrl:
    "https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-green.png",
  shadowUrl:
    "https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png",
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  shadowSize: [41, 41],
});

var redIcon = new L.Icon({
  iconUrl:
    "https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-red.png",
  shadowUrl:
    "https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png",
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  shadowSize: [41, 41],
});
var sheepIcon = new L.Icon({
  iconUrl: "https://img.icons8.com/cotton/64/000000/sheep2--v2.png",
  shadowUrl:
    "https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png",
  iconSize: [32, 32],
  iconAnchor: [16, 16],
  popupAnchor: [1, -16],
  shadowSize: [41, 41],
});
var fieldIcon = new L.Icon({
  iconUrl:
    "https://img.icons8.com/material-two-tone/48/000000/house-with-a-garden.png",
  shadowUrl:
    "https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png",
  iconSize: [32, 32],
  iconAnchor: [16, 16],
  popupAnchor: [1, -16],
  shadowSize: [41, 41],
});

// var mymap = L.map("mapid").setView([navLatitude, navLongitude], 7);

// https://api.mapbox.com/styles/v1/pcuquemy/cks827ivm1pfh18s8prk9qzwv/wmts?access_token=pk.eyJ1IjoicGN1cXVlbXkiLCJhIjoiY2txNW82c3hlMGQxODJ2cW80a20wdXVhaCJ9.Xa-faAijdGvYFWDsKC-Zzw

L.tileLayer(
  "https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}",
  {
    attribution:
      'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: "pcuquemy/cks827ivm1pfh18s8prk9qzwv",
    tileSize: 512,
    zoomOffset: -1,
    accessToken:
      "pk.eyJ1IjoicGN1cXVlbXkiLCJhIjoiY2txNW82c3hlMGQxODJ2cW80a20wdXVhaCJ9.Xa-faAijdGvYFWDsKC-Zzw",
  }
).addTo(mymap);

var latitudeOffre = document.getElementsByClassName("herdlong");
var longitudeOffre = document.getElementsByClassName("herdlat");

console.log("latitude length: " + latitudeOffre.length);
for (var i = 0; i < latitudeOffre.length; i++) {
  console.log("latitude: " + latitudeOffre[i].value);
  platitudeOffre = parseFloat(latitudeOffre[i].value.replace(",", "."));
  plongitudeOffre = parseFloat(longitudeOffre[i].value.replace(",", "."));
  marcker = new L.marker([platitudeOffre, plongitudeOffre], { icon: sheepIcon })
    .bindPopup("Troupeau")
    .addTo(mymap);
}

var latitudeTerrain = document.getElementsByClassName("fieldlong");
var longitudeTerrain = document.getElementsByClassName("fieldlat");

console.log("latitude length: " + latitudeTerrain.length);

for (var i = 0; i < latitudeTerrain.length; i++) {
  console.log("latitude: " + latitudeTerrain[i].value);
  plattitudeTerrain = parseFloat(latitudeTerrain[i].value.replace(",", "."));
  plongitudeTerrain = parseFloat(longitudeTerrain[i].value.replace(",", "."));
  marcker = new L.marker([plattitudeTerrain, plongitudeTerrain], {
    icon: fieldIcon,
  })
    .bindPopup("Terrain")
    .addTo(mymap);
}
}

function error(err) {
  console.warn(`ERREUR (${err.code}): ${err.message}`);
}

navigator.geolocation.getCurrentPosition(success, error, options);

