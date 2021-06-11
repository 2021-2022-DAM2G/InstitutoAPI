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

PRIMARY KEY (title_id, title_name)
);

CREATE TABLE IF NOT EXISTS titleGroup (
group_id			INT AUTO_INCREMENT PRIMARY KEY,
course 				VARCHAR (10) NOT NULL,
grade				INT NOT NULL,
title				VARCHAR (40) NOT NULL,
group_year			INT NOT NULL
);

CREATE TABLE IF NOT EXISTS enrollment(
enrollment_id		INT AUTO_INCREMENT PRIMARY KEY,
nif			        VARCHAR (9) NOT NULL,
enrollment_year	    INT NOT NULL,
title_id 			INT NOT NULL,
group_id			INT,
enrollment_status	VARCHAR (30) NOT NULL,

CONSTRAINT FK_Student_Enrollment
FOREIGN KEY (student_nif) 
REFERENCES student (nif)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
    

CONSTRAINT FK_Title_Enrollment
FOREIGN KEY (title_id)
REFERENCES title (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
    

CONSTRAINT FK_Group_Enrollment
FOREIGN KEY (group_id)
REFERENCES titleGroup (group_id)
	ON UPDATE CASCADE
    ON DELETE CASCADE
);
