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
			addStudentFormed(json);
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
			addGroupFormed(json);
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
			addEnrollmentFormed(json);
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
			addTitleFormed(json);
			alert("Titulo creado");
		}
	});
}
}

function newTitleFormed() {
    $.get("/title", function(titles, status) {
        for (title of titles) {
            addTitleFormed(title);
        }
    });
}

function addTitleFormed(title) {
    var titlesTable = document.getElementById("infoTabla");

    var titleTr = document.createElement("tr");

    var idTitleTD = document.createElement("td");
    idTitleTD.appendChild(document.createTextNode(title.id));

    var nameTitleTd = document.createElement("td");
    nameTitleTd.appendChild(document.createTextNode(title.name));

    var levelTd = document.createElement("td");
    levelTd.appendChild(document.createTextNode(title.level));

    var familyTd = document.createElement("td");
    familyTd.appendChild(document.createTextNode(title.area));

    var descriptionTd = document.createElement("td");
    descriptionTd.appendChild(document.createTextNode(title.description));

    titleTr.appendChild(idTitleTD);
    titleTr.appendChild(nameTitleTd);
    titleTr.appendChild(levelTd);
    titleTr.appendChild(familyTd);
    titleTr.appendChild(descriptionTd);

    titlesTable.appendChild(titleTr);
}

function newStudentFormed() {
    $.get("/student", function(students, status) {
        for (student of students) {
            addStudentFormed(student);
        }
    });
}

function addStudentFormed(studentFormedJson) {
    var table = document.getElementById("infoTabla");

    var tr = document.createElement("tr");

    var nifTd = document.createElement("td");
    nifTd.appendChild(document.createTextNode(studentFormedJson.nif));

    var nameTd = document.createElement("td");
    nameTd.appendChild(document.createTextNode(studentFormedJson.name));

    var surnameTd = document.createElement("td");
    surnameTd.appendChild(document.createTextNode(studentFormedJson.surname));

    var zipCodeTd = document.createElement("td");
    zipCodeTd.appendChild(document.createTextNode(studentFormedJson.zipCode));

    var addressTd = document.createElement("td");
    addressTd.appendChild(document.createTextNode(studentFormedJson.address));

    var emailTd = document.createElement("td");
    emailTd.appendChild(document.createTextNode(studentFormedJson.email));

    tr.appendChild(nifTd);
    tr.appendChild(nameTd);
    tr.appendChild(surnameTd);
    tr.appendChild(zipCodeTd);
    tr.appendChild(addressTd);
    tr.appendChild(emailTd);

    table.appendChild(tr);
}

function newGroupFormed() {
    $.get("/group", function(groups, status) {
        for (group of groups) {
            addGroupFormed(group);
        }
    });
}

function addGroupFormed(newGroup) {
    var table = document.getElementById("infoTabla");

    var tr = document.createElement("tr");

    var idGroup = document.createElement("td");
    idGroup.appendChild(document.createTextNode(newGroup.id));

    var course = document.createElement("td");
    course.appendChild(document.createTextNode(newGroup.course));

    var letter = document.createElement("td");
    letter.appendChild(document.createTextNode(newGroup.letter));

    var title = document.createElement("td");
    title.appendChild(document.createTextNode(newGroup.title));

    var year = document.createElement("td");
    year.appendChild(document.createTextNode(newGroup.year));

    tr.appendChild(idGroup);
    tr.appendChild(course);
    tr.appendChild(letter);
    tr.appendChild(title);
    tr.appendChild(year);

    table.appendChild(tr);
}

function newEnrollmentFormed() {
    $.get("/enrollment", function(enrollments, status) {
        for (enrollment of enrollments) {
            addEnrollmentFormed(enrollment);
        }
    });
}

function addEnrollmentFormed(e) {
    var table = document.getElementById("infoTabla");

    var enrollmentTr = document.createElement("tr");

    var studentNif = document.createElement("td");
    studentNif.appendChild(document.createTextNode(e.studentNif));

    var year = document.createElement("td");
    year.appendChild(document.createTextNode(e.year));

    var title = document.createElement("td");
    title.appendChild(document.createTextNode(e.title));

    var course = document.createElement("td");
    course.appendChild(document.createTextNode(e.course));

    var status = document.createElement("td");
    status.appendChild(document.createTextNode(e.status));

    enrollmentTr.appendChild(studentNif);
    enrollmentTr.appendChild(year);
    enrollmentTr.appendChild(title);
    enrollmentTr.appendChild(course);
    enrollmentTr.appendChild(status);

    table.appendChild(enrollmentTr);
}