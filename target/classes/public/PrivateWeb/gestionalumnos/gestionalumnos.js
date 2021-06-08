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