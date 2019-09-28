

document.getElementById("rat-der-stadt").addEventListener('click', function(event) {
    var container = document.getElementById("container");  
    
    container.innerHTML = '';

    // müssen wir dynamiusch holen vom server holen
    var linkList = [
        'http://google.de',
        'http://google.de1',
        'http://google.de2',
        'http://google.de3',
        'http://google.de4',
    ];
    
    var ul = document.createElement("ul");
    linkList.forEach(function(link, i) {
        var li = document.createElement("li");

        // link erzeugen
        var a = document.createElement("a");
        a.href = '#';
        a.text = link;
        a.class = "rat-der-stadt-pdf";

        li.appendChild(a);                 
        ul.appendChild(li);  
    });

    container.appendChild(ul);  
});

document.body.addEventListener( 'click', function ( event ) {
    if( event.srcElement.class == "rat-der-stadt-pdf" ) {
        var container = document.getElementById("container"); 

        container.innerHTML = '';

        // zu dem link das document holen
    
        var o = document.createElement("object");
        o.data = "test.pdf";
        o.style = "width:100%;height:1000px";

        container.appendChild(o);
    };
});