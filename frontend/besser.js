var form = document.forms.namedItem("formular");
form.addEventListener('submit', function(ev) {

  var oOutput = document.querySelector("div"),
      oData = new FormData(form);
      console.log(oData);
  fetch("http://10.4.125.235:8080/dokument/erstellen", {
      method: "POST",
      body: oData
  })
.then(response => response.text()
).then(html =>console.log(html));
  ev.preventDefault();
}, false);