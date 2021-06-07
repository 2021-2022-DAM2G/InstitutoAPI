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
	
function newEnrrollment(json) {
	if (json.nifStudent==''|| json.enroleYear=='' || json.title=='' 
		|| json.course=='' || json.status==''){
		window.alert("Hay que rellenar ambas secciones.");
	} else{
		$.ajax({
          url:"/student",
          type:"POST",
          data: JSON.stringify(json),
          contentType:"application/json; charset=utf-8",
          success: function(){
            alert("Matricula creada");
          }
        });
}
}