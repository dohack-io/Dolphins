document.querySelector('#anmelden').addEventListener('click', toggleDialog);
	
  
function toggleDialog(){ 
	var dialog = document.querySelector('dialog'),
    	closebutton = document.getElementById('Abbruch'),
    	pagebackground = document.querySelector('body');
			
	if (!dialog.hasAttribute('open')) {
		// show the dialog 
        dialog.setAttribute('open','open');
        var div = document.createElement('div');
		div.id = 'backdrop';
		document.body.appendChild(div);
		// after displaying the dialog, focus the closebutton inside it
		closebutton.focus();
		closebutton.addEventListener('click', toggleDialog);
    }
    
	else {		
 		dialog.removeAttribute('open');  
        var div = document.querySelector('#backdrop');
		div.parentNode.removeChild(div);
		lastFocus.focus(); 
	}
}