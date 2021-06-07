	-- DROP DATABASE IF EXISTS Instituto;

CREATE DATABASE IF NOT EXISTS Instituto;
    
USE Instituto;

CREATE TABLE IF NOT EXISTS student (
nif					VARCHAR (9) PRIMARY KEY,
student_name		VARCHAR (40) NOT NULL,
student_surname		VARCHAR (80) NOT NULL,
zipcode				INT NOT NULL,
address				VARCHAR (100) NOT NULL,
email				VARCHAR (40) NOT NULL
);

CREATE TABLE IF NOT EXISTS title (
title_id			INT AUTO_INCREMENT,
title_name			VARCHAR (40) UNIQUE NOT NULL,
title_level			VARCHAR (10) NOT NULL,
family				VARCHAR (20) NOT NULL,
title_description	VARCHAR (100) NOT NULL,

PRIMARY KEY (title_Id, title_Name)
);

CREATE TABLE IF NOT EXISTS studentGroup (	
group_id			INT AUTO_INCREMENT PRIMARY KEY,
class 				VARCHAR (10) NOT NULL,
grade				INT NOT NULL,
title				VARCHAR (40) NOT NULL,
groupYear			INT NOT NULL
);

CREATE TABLE registration(
registration_id		INT AUTO_INCREMENT PRIMARY KEY,
student_nif			VARCHAR (9) NOT NULL,
registration_year	INT NOT NULL,
title 				VARCHAR (20) NOT NULL,
grade_id			INT NOT NULL,
registration_status	VARCHAR (30) NOT NULL,

CONSTRAINT FK_Student_Registration
FOREIGN KEY (student_nif) 
REFERENCES student (nif)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
    

CONSTRAINT FK_Title_Registration
FOREIGN KEY (title)
REFERENCES title (title_name)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
    

CONSTRAINT FK_Group_Registration
FOREIGN KEY (grade_id)
REFERENCES studentGroup (group_id)
	ON UPDATE CASCADE
    ON DELETE CASCADE

);



