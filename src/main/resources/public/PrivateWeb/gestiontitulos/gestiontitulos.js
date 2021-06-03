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