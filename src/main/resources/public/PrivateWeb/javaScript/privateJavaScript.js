function makeStudents(){
	var nifInput = document.getElementById('nif');
	var nameInput = document.getElementById('name');
	var surnameInput = document.getElementById('surname');
	var zipInput = document.getElementById('zipCode');
	var addressInput = document.getElementById('address');
	var emailInput = document.getElementById('email');

	var alumnosJson={
		nif: nifInput.value,
		name: nameInput.value,
		surname: surnameInput.value,
		zipCode:zipInput.value,
		address:addressInput.value,
		email:emailInput.value
	};

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
	$.ajax({
		url:"/student",
		type:"POST",
		data: JSON.stringify(json),
		contentType:"application/json; charset=utf-8",
		success: function(){
			alert("Estudiante creado");
		}
	});

}
}

function addGrupo(){
	var courseInput = document.getElementById('course');
	var letterInput = document.getElementById('letter');
	var titleInput = document.getElementById('title');
	var yearInput = document.getElementById('year');

	var grupo = {
		curso:courseInput.value,
		letra:letterInput.value,
		titulo:titleInput.value,
		año:yearInput.value
	}

	if (courseInput.value == ' ' || letterInput.value == ' ' || titleInput.value == ' ' || yearInput.value == ' ') {
		alert("Rellena todos los campos")
	} else {
		getGrupo(grupo);
		document.getElementById('formulario').reset();
	}
}

function getGrupo(grupo){
	var table = document.getElementById('infoTabla');
	var row = document.createElement('tr');
	var courseInput = document.createElement('td');
	courseInput.appendChild(document.createTextNode(grupo.curso));
	var letterInput = document.createElement('td');
	letterInput.appendChild(document.createTextNode(grupo.letra));
	var titleInput = document.createElement('td');
	titleInput.appendChild(document.createTextNode(grupo.titulo));
	var yearInput = document.createElement('td');
	yearInput.appendChild(document.createTextNode(grupo.año));

	row.appendChild(courseInput);
	row.appendChild(letterInput);
	row.appendChild(titleInput);
	row.appendChild(yearInput);
	table.appendChild(row);
}

function makeEnrollment(){
	var nifStudentInput = document.getElementById('nifStudent');
	var enroleYearInput = document.getElementById('enroleYear');
	var titleInput = document.getElementById('title');
	var courseInput = document.getElementById('course');
	var statusInput = document.getElementById('status');

	var titleJson={nifStudent:nifStudentInput.value, enroleYear:enroleYearInput.value, 
		title:titleInput.value, course:courseInput.value, status:statusInput.value};

		addEnrollment(titleJson);

		nifStudentInput.value='';
		enroleYearInput.value='';
		title.value='';
		courseInput.value='';
		statusInput.value='';
	}

	function addEnrollment(json) {
		if (json.nifStudent==''|| json.enroleYear=='' || json.title=='' 
			|| json.course=='' || json.status==''){
			window.alert("Hay que rellenar todas las secciones.");
	} else{
		var trTable = document.createElement("tr");

		var nifStudentTD = document.createElement("td");
		nifStudentTD.appendChild(document.createTextNode(json.nifStudent));
		trTable.appendChild(nifStudentTD);

		var enroleYearTD = document.createElement("td");
		enroleYearTD.appendChild(document.createTextNode(json.enroleYear));
		trTable.appendChild(enroleYearTD);

		var titleTD = document.createElement("td");
		titleTD.appendChild(document.createTextNode(json.title));
		trTable.appendChild(titleTD);

		var courseTD = document.createElement("td");
		courseTD.appendChild(document.createTextNode(json.course));
		trTable.appendChild(courseTD);

		var statusTD = document.createElement("td");
		statusTD.appendChild(document.createTextNode(json.status));
		trTable.appendChild(statusTD);

		var tablaPrincipal = document.getElementById('infoTabla');
		tablaPrincipal.appendChild(trTable);

	}
}

function newEnrrollment(json) {
	if (json.nifStudent==''|| json.enroleYear=='' || json.title=='' 
		|| json.course=='' || json.status==''){
		window.alert("Hay que rellenar ambas secciones.");
} else{
	$.ajax({
		url:"/title",
		type:"POST",
		data: JSON.stringify(json),
		contentType:"application/json; charset=utf-8",
		success: function(){
			alert("Matricula creada");
		}
	});
}
}

function makeTitle(){
	var nameInput = document.getElementById('name');
	var levelInput = document.getElementById('level');
	var familyInput = document.getElementById('family');
	var descriptionInput = document.getElementById('description');

	var titleJson={name:nameInput.value, level:levelInput.value, 
		family:familyInput.value, description:descriptionInput.value};

		addTitle(titleJson);

		nameInput.value='';
		levelInput.value='';
		family.value='';
		descriptionInput.value='';
	}

	function addTitle(json) {
		if (json.name==''|| json.enroleYear=='' || json.title=='' 
			|| json.description==''){
			window.alert("Hay que rellenar todas las secciones.");
	} else{
		var trTable = document.createElement("tr");

		var nameTD = document.createElement("td");
		nameTD.appendChild(document.createTextNode(json.name));
		trTable.appendChild(nameTD);

		var levelTD = document.createElement("td");
		levelTD.appendChild(document.createTextNode(json.level));
		trTable.appendChild(levelTD);

		var familyTD = document.createElement("td");
		familyTD.appendChild(document.createTextNode(json.family));
		trTable.appendChild(familyTD);

		var descriptionTD = document.createElement("td");
		descriptionTD.appendChild(document.createTextNode(json.description));
		trTable.appendChild(descriptionTD);

		var tablaPrincipal = document.getElementById('infoTabla');
		tablaPrincipal.appendChild(trTable);

	}
}
