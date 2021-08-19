function test(){
console.log("entrer dans le js de la map")	
	

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
    maxZoom: 3,
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
}