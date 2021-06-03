function newStudent() {
    var studentJson = { nif: '12345678L', name: 'Pepe', surname: 'Díaz', zipCode: '28574', address: 'Calle falsa, 13', email: 'email@fake.com' };
    addStudent(studentJson);
}

function addStudent(student) {
    var studentsTable = document.getElementById("table");

    var studentTr = document.createElement("tr");

    var nifTd = document.createElement("td");
    nifTd.appendChild(document.createTextNode(student.nif));

    var nameTd = document.createElement("td");
    nameTd.appendChild(document.createTextNode(student.name));

    var surnameTd = document.createElement("td");
    surnameTd.appendChild(document.createTextNode(student.surname));

    var zipCodeTd = document.createElement("td");
    zipCodeTd.appendChild(document.createTextNode(student.zipCode));

    var addressTd = document.createElement("td");
    addressTd.appendChild(document.createTextNode(student.address));

    var emailTd = document.createElement("td");
    emailTd.appendChild(document.createTextNode(student.email));

    studentTr.appendChild(nifTd);
    studentTr.appendChild(nameTd);
    studentTr.appendChild(surnameTd);
    studentTr.appendChild(zipCodeTd);
    studentTr.appendChild(addressTd);
    studentTr.appendChild(emailTd);

    studentsTable.appendChild(studentTr);
}

function newTitle() {
    var titleJson = { idTitulo: 1, name: 'Título', level: 'Superior', family: 'Informática', description: 'Descripción' };
<<<<<<< HEAD
    addTitleFormed(titleJson);
=======
    addTitle(titleJson);
<<<<<<< HEAD
}

function addTitle(title) {
    var titlesTable = document.getElementById("table");

    var titleTr = document.createElement("tr");

    var idTitleTD = document.createElement("td");
    idTitleTD.appendChild(document.createTextNode(title.idTitulo));

    var nameTitleTd = document.createElement("td");
    nameTitleTd.appendChild(document.createTextNode(title.name));

    var levelTd = document.createElement("td");
    levelTd.appendChild(document.createTextNode(title.level));

    var familyTd = document.createElement("td");
    familyTd.appendChild(document.createTextNode(title.family));

    var descriptionTd = document.createElement("td");
    descriptionTd.appendChild(document.createTextNode(title.description));

    titleTr.appendChild(idTitleTD);
    titleTr.appendChild(nameTitleTd);
    titleTr.appendChild(levelTd);
    titleTr.appendChild(familyTd);
    titleTr.appendChild(descriptionTd);

    titlesTable.appendChild(titleTr);
}

=======
>>>>>>> a7698bd5dd8f0aee679a2875337ddce72d546dc3
}

function addTitleFormed(title) {
    var titlesTable = document.getElementById("table");

    var titleTr = document.createElement("tr");

    var idTitleTD = document.createElement("td");
    idTitleTD.appendChild(document.createTextNode(title.idTitulo));

    var nameTitleTd = document.createElement("td");
    nameTitleTd.appendChild(document.createTextNode(title.name));

    var levelTd = document.createElement("td");
    levelTd.appendChild(document.createTextNode(title.level));

    var familyTd = document.createElement("td");
    familyTd.appendChild(document.createTextNode(title.family));

    var descriptionTd = document.createElement("td");
    descriptionTd.appendChild(document.createTextNode(title.description));

    titleTr.appendChild(idTitleTD);
    titleTr.appendChild(nameTitleTd);
    titleTr.appendChild(levelTd);
    titleTr.appendChild(familyTd);
    titleTr.appendChild(descriptionTd);

    titlesTable.appendChild(titleTr);
}

>>>>>>> 1faf408b425e4eded3a8388fe585ce6702e22e62
function newTitleFormed() {
    $.get("/title", function(title, status) {
        for (title of titles) {
            addTitleFormed(title);
        }
    });
}

function newStudentFormed() {
    $.get("/student", function(students, status) {
        for (student of students) {
            addStudentFormed(student);
        }
    });
}

function addStudentFormed(studentFormedJson) {
    var table = document.getElementById("table");

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

function newGroup() {
    var group = { id: 1, course: "Dam1", letter: "A", title: "Nombre Titulo", year: 2021 }
    addGroupFormed(group);
}

<<<<<<< HEAD
function addGroup(newGroup) {
=======
function addGroupFormed(newGroup) {
>>>>>>> 1faf408b425e4eded3a8388fe585ce6702e22e62
    var table = document.getElementById("table");

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


function newGroupFormed() {
    $.get("/group", function(groups, status) {
        for (group of groups) {
<<<<<<< HEAD
            addGroup(group);
=======
            addGroupFormed(group);
>>>>>>> 1faf408b425e4eded3a8388fe585ce6702e22e62
        }
    });
}