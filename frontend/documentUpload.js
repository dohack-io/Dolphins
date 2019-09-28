 document.getElementById("submit").addEventListener("click", async function(event){
        
    
    const hochgeladeneDatei = document.getElementById("hochgeladene-datei").files[0];
    const doctitle = document.getElementById("doctitle").value;
    const gremiumliste = document.getElementById("gremiumliste").value;
    const kurzbeschr = document.getElementById("kurzbeschr").value;
    const tags = document.getElementById("tags").value;

    console.log(hochgeladeneDatei);
    console.log(doctitle.value);
    console.log(gremiumliste);
    console.log(kurzbeschr);
    console.log(tags);


var data = new FormData();
data.append('Dokumenttitel', doctitle);
data.append('Gremium', gremiumliste);
data.append('Kurzbeschreibung', kurzbeschr);
data.append('Tags', tags);
data.append('File', hochgeladeneDatei);


(async () => {
    const response = await fetch('http://10.4.125.235:8080/dokument/erstellen',{
        method: 'POST',
        headers:{
            'Accept': 'application/json',
            'boundary': '--WebKitFormBoundaryfgtsKTYLsT7PNUVD',
             'Access-Control-Allow-Origin': '*'
        },
        body: data
    })
})();


 event.preventDefault()
 

});