function addStudent(){
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
		zipCode: zipInput.value,
		address: addressInput.value,
		email: emailInput.value
	};

	createStudent(alumnosJson);

	nifInput.value='';
	nameInput.value='';
	surname.value='';
	zipInput.value='';
	addressInput.value='';
	emailInput.value='';
}

function createStudent(json) {
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

function addGroup(){
	var idInput = document.getElementById('groupId');
	var courseInput = document.getElementById('course');
	var letterInput = document.getElementById('letter');
	var titleInput = document.getElementById('title');
	var yearInput = document.getElementById('year');

	var grupo = {
		id : idInput.value,
		course: courseInput.value,
		letter: letterInput.value,
		title: titleInput.value,
		year: yearInput.value
	};

	createGroup(grupo);

	document.getElementById('formulario').reset();
}

function createGroup(json){
	if (json.id=='' || json.course==''|| json.letter=='' || json.title=='' 
		|| json.year==''){
		window.alert("Hay que rellenar ambas secciones.");
} else{
	$.ajax({
		url:"/group",
		type:"POST",
		data: JSON.stringify(json),
		contentType:"application/json; charset=utf-8",
		success: function(){
			alert("Grupo creado");
		}
	});

}
}

function addEnrollment(){
	var nifStudentInput = document.getElementById('nifStudent');
	var enroleYearInput = document.getElementById('enroleYear');
	var titleInput = document.getElementById('title');
	var courseInput = document.getElementById('course');
	var statusInput = document.getElementById('status');

	var titleJson={
		studentNif: nifStudentInput.value,
		year: enroleYearInput.value, 
		title: titleInput.value,
		course: courseInput.value,
		status: statusInput.value
	};

	createEnrollment(titleJson);

	nifStudentInput.value='';
	enroleYearInput.value='';
	title.value='';
	courseInput.value='';
	statusInput.value='';
}

function createEnrollment(json) {
	if (json.studentNif==''|| json.year=='' || json.title=='' 
		|| json.course=='' || json.status==''){
		window.alert("Hay que rellenar ambas secciones.");
} else{
	$.ajax({
		url:"/enrollment",
		type:"POST",
		data: JSON.stringify(json),
		contentType:"application/json; charset=utf-8",
		success: function(){
			alert("Matricula creada");
		}
	});
}
}

function addTitle(){
	var idInput = document.getElementById('titleId')
	var nameInput = document.getElementById('name');
	var levelInput = document.getElementById('level');
	var familyInput = document.getElementById('family');
	var descriptionInput = document.getElementById('description');

	var titleJson={
		id:titleId.value,
		name:nameInput.value,
		level:levelInput.value,
		area:familyInput.value,
		description:descriptionInput.value
	};

	createTitle(titleJson);

	titleId.value='';
	nameInput.value='';
	levelInput.value='';
	familyInput.value='';
	descriptionInput.value='';
}

function createTitle(json) {
		if (json.id=='' || json.name==''|| json.level=='' || json.area=='' 
		|| json.description==''){
		window.alert("Hay que rellenar ambas secciones.");
} else{
	$.ajax({
		url:"/title",
		type:"POST",
		data: JSON.stringify(json),
		contentType:"application/json; charset=utf-8",
		success: function(){
			alert("Titulo creado");
		}
	});
}
}
