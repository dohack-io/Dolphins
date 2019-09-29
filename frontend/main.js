document.getElementById("registrieren").addEventListener("click", function(event){
    alert('submit abgeschickt');
});


//Daten Überprüfung
function ueberpruefung(){
console.log("start überprüfung..");
//hier finden Überprüfungen statt
var geschl = document.getElementById('geschl').value;
alert(geschl);
var name = document.getElementById('name').value;
var Vorname = document.getElementById('Vorname').value;
var Nachname = document.getElementById('Nachname').value;
var Strasse = document.getElementById('Strasse').value;
var PLZ = document.getElementById('PLZ').value;
var Ort = document.getElementById('Ort').value;
var Benutzername = document.getElementById('Benutzername').value;
var Email = document.getElementById('Email').value;
var Passwort1 = document.getElementById('Passwort1').value;
var Passwort2 = document.getElementById('Passwort2').value;
  

if(geschl == 0 ){
    alert("Anrede fehlt");
    return;
}


if(Vorname == ""){
alert("Vorname fehlt");
return;
}

if(Nachname == ""){
    alert("Nachname fehlt");
    return;
    }
    
if(Strasse == ""){
alert("Straße fehlt");
return;
}

if(PLZ == ""){
alert("PLZ fehlt");
return;
}

if(Ort == ""){
alert("Ort fehlt");
return;
}

if(Benutzername == ""){
alert("Benutzername fehlt");
return;
}

if(Email == ""){
alert("E-Mail fehlt");
return;
}

if(Passwort1 == ""){
alert("Passwort fehlt");
return;
}

if(Passwort2 == ""){
alert("Passwort fehlt");
return;
}


if(PLZ.length != 5 ){
    alert("PLZ nicht 5 Zahlen groß");
    return;
}

if(Benutzername.length < 3){
    alert("Benutzername kleiner 3 Zeichen");
    return;
}

if(Passwort1 != Passwort2){
alert("Passwörter stimmen nicht überein");
    return;
}

if(Passwort1.length <8){
    alert("Passwort mindestens 8 Zeichen lang");
        return;
    }
    

//Nach überprüfung 
var postObject = {
    'Geschlecht': geschl,
    'Vorname': Vorname,
    'Nachname': Nachname,
    'Strasse': Strasse,
    'PLZ': PLZ,
    'Ort': Ort,
    'Benutzer': Benutzername,
    'E-Mail': Email,
    'Passwort': Passwort1
};

document.write("<h1>Bestätigungsmail wurde Verschickt</h1>");
//const data = await postData('http://ziel.de', postObject );

}


