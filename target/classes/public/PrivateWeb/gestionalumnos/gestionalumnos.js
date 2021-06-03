function makeStudents(){
	var nifInput = document.getElementById('nif');
	var nameInput = document.getElementById('name');
	var surnameInput = document.getElementById('surname');
	var zipInput = document.getElementById('zipCode');
	var addressInput = document.getElementById('address');
	var emailInput = document.getElementById('email');

	var alumnosJson={nif: nifInput.value, name: nameInput.value, 
		surname: surnameInput.value, zip:zipInput.value, address:addressInput.value, email:emailInput.value};

	addAlumno(alumnosJson);

	nifInput.value='';
	nameInput.value='';
	surname.value='';
	zipInput.value='';
	addressInput.value='';
	emailInput.value='';
}

function addAlumno(json) {
	if (json.nif==''|| json.name=='' || json.surname=='' 
		|| json.zip=='' || json.address=='' || json.email==''){
		window.alert("Hay que rellenar ambas secciones.");
	} else{
		var fila = document.createElement("tr");
		var nifTD = document.createElement("td");
		var nameTD = document.createElement("td");
		var surnameTD = document.createElement("td");
		var zipTD = document.createElement("td");
		var addressTD = document.createElement("td");
		var emailTD = document.createElement("td");

		nifTD.appendChild(document.createTextNode(json.nif));
		nameTD.appendChild(document.createTextNode(json.name));
		surnameTD.appendChild(document.createTextNode(json.surname));
		zipTD.appendChild(document.createTextNode(json.zip));
		addressTD.appendChild(document.createTextNode(json.address));
		emailTD.appendChild(document.createTextNode(json.email));

		fila.appendChild(nifTD);
		fila.appendChild(nameTD);
		fila.appendChild(surnameTD);
		fila.appendChild(zipTD);
		fila.appendChild(addressTD);
		fila.appendChild(emailTD);

		var tablaPrincipal = document.getElementById('infoTabla');
		tablaPrincipal.appendChild(fila);

	}
}