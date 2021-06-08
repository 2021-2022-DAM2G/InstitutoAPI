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
    var form = document.getElementById('formulario');
    form.reset();
  }
}

function getGrupo(grupo){
  var table = document.getElementById('table');
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
  table.appendChild(crow);
}
