-- Q1:
-- a. Create EMPLOYEE table with the most appropriate/economic field/column constraints &amp; types. All
-- fields are mandatory except Note field.
CREATE TABLE EMPLOYEE (
    EmpNo INT PRIMARY KEY,
    EmpName VARCHAR(100) NOT NULL,
    BirthDay DATE NOT NULL,
    DeptNo INT NOT NULL,
    MgrNo INT NOT NULL DEFAULT 0,
    StartDate DATE NOT NULL,
    Salary DECIMAL(15, 2) NOT NULL,
    Level TINYINT NOT NULL CHECK (Level BETWEEN 1 AND 7),
    Status TINYINT NOT NULL DEFAULT 0 CHECK (Status IN (0, 1, 2)),
    Note TEXT,
    Email VARCHAR(255) UNIQUE
);

-- b. Create SKILL table with the most appropriate/economic field/column constraints &amp; types, all fields
-- are mandatory except Note field.

CREATE TABLE SKILL (
    SkillNo INT AUTO_INCREMENT PRIMARY KEY,
    SkillName VARCHAR(100) NOT NULL,
    Note TEXT
);

-- c. Create DEPARTMENT table with the most appropriate/economic field/column constraints &amp; types, all
-- fields are mandatory except Note field.

CREATE TABLE DEPARTMENT (
    DeptNo INT AUTO_INCREMENT PRIMARY KEY,
    DeptName VARCHAR(100) NOT NULL,
    Note TEXT
);

-- d. Create EMP_SKILL table with the most appropriate/economic field/column constraints &amp; types, all
-- fields are mandatory except Description field.
CREATE TABLE EMP_SKILL (
    SkillNo INT,
    EmpNo INT,
    SkillLevel TINYINT NOT NULL CHECK (SkillLevel BETWEEN 1 AND 3),
    RegDate DATE NOT NULL,
    PRIMARY KEY (SkillNo, EmpNo),
    CONSTRAINT FK_EMP_SKILL_SkillNo FOREIGN KEY (SkillNo) REFERENCES SKILL(SkillNo),
    CONSTRAINT FK_EMP_SKILL_EmpNo FOREIGN KEY (EmpNo) REFERENCES EMPLOYEE(EmpNo)
);

-- Q2:
-- a. Add an Email field to EMPLOYEE table and make sure that the database will not allow the value for
-- Email to be inserted into a new row if that value has already been used in another row.
ALTER TABLE EMPLOYEE
ADD Email VARCHAR(255) UNIQUE;

-- b. Modify EMPLOYEE table to set default values to 0 of MgrNo and Status fields.

ALTER TABLE EMPLOYEE
MODIFY MgrNo INT NOT NULL DEFAULT 0,
MODIFY Status TINYINT NOT NULL DEFAULT 0;

-- Q3:
-- a. Add the FOREIGN KEY constrain of DeptNo field to the EMPLOYEE table that will relate the
-- DEPARTMENT table.

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_EMPLOYEE_DeptNo FOREIGN KEY (DeptNo) REFERENCES DEPARTMENT(DeptNo);

-- b. Remove the Description field from the EMP_SKILL table.
ALTER TABLE EMP_SKILL
DROP COLUMN Description;

-- Q4:
-- a. Add at least 5 records into each the created tables.

-- Insert records into DEPARTMENT table
INSERT INTO DEPARTMENT (DeptName, Note) VALUES ('HR', 'Human Resources');
INSERT INTO DEPARTMENT (DeptName, Note) VALUES ('IT', 'Information Technology');
INSERT INTO DEPARTMENT (DeptName, Note) VALUES ('Finance', 'Finance Department');
INSERT INTO DEPARTMENT (DeptName, Note) VALUES ('Marketing', 'Marketing Department');
INSERT INTO DEPARTMENT (DeptName, Note) VALUES ('Sales', 'Sales Department');

-- Insert records into SKILL table
INSERT INTO SKILL (SkillName, Note) VALUES ('Java', 'Java Programming Language');
INSERT INTO SKILL (SkillName, Note) VALUES ('SQL', 'Structured Query Language');
INSERT INTO SKILL (SkillName, Note) VALUES ('Python', 'Python Programming Language');
INSERT INTO SKILL (SkillName, Note) VALUES ('Project Management', 'Managing Projects');
INSERT INTO SKILL (SkillName, Note) VALUES ('Communication', 'Effective Communication');

-- Insert records into EMPLOYEE table
INSERT INTO EMPLOYEE (EmpNo, EmpName, BirthDay, DeptNo, MgrNo, StartDate, Salary, Level, Status, Note, Email)
VALUES (1, 'John Doe', '1985-01-15', 1, 0, '2010-06-01', 5000000, 3, 0, 'Senior HR Specialist', 'john.doe@example.com');
INSERT INTO EMPLOYEE (EmpNo, EmpName, BirthDay, DeptNo, MgrNo, StartDate, Salary, Level, Status, Note, Email)
VALUES (2, 'Jane Smith', '1990-02-20', 2, 0, '2012-09-15', 6000000, 5, 0, 'IT Manager', 'jane.smith@example.com');
INSERT INTO EMPLOYEE (EmpNo, EmpName, BirthDay, DeptNo, MgrNo, StartDate, Salary, Level, Status, Note, Email)
VALUES (3, 'Robert Brown', '1988-03-25', 3, 0, '2014-11-20', 4500000, 4, 0, 'Finance Analyst', 'robert.brown@example.com');
INSERT INTO EMPLOYEE (EmpNo, EmpName, BirthDay, DeptNo, MgrNo, StartDate, Salary, Level, Status, Note, Email)
VALUES (4, 'Emily Davis', '1995-04-30', 4, 0, '2018-01-05', 4000000, 2, 0, 'Marketing Specialist', 'emily.davis@example.com');
INSERT INTO EMPLOYEE (EmpNo, EmpName, BirthDay, DeptNo, MgrNo, StartDate, Salary, Level, Status, Note, Email)
VALUES (5, 'Michael Johnson', '1982-05-10', 5, 0, '2008-12-10', 5500000, 6, 0, 'Sales Director', 'michael.johnson@example.com');

-- Insert records into EMP_SKILL table
INSERT INTO EMP_SKILL (SkillNo, EmpNo, SkillLevel, RegDate) VALUES (1, 1, 3, '2010-06-01');
INSERT INTO EMP_SKILL (SkillNo, EmpNo, SkillLevel, RegDate) VALUES (2, 2, 2, '2012-09-15');
INSERT INTO EMP_SKILL (SkillNo, EmpNo, SkillLevel, RegDate) VALUES (3, 3, 1, '2014-11-20');
INSERT INTO EMP_SKILL (SkillNo, EmpNo, SkillLevel, RegDate) VALUES (4, 4, 3, '2018-01-05');
INSERT INTO EMP_SKILL (SkillNo, EmpNo, SkillLevel, RegDate) VALUES (5, 5, 2, '2008-12-10');

-- b. Create a VIEW called EMPLOYEE_TRACKING that will appear to the user as EmpNo, Emp_Name
-- and Level. It has Level satisfied the criteria: Level &gt;=3 and Level &lt;= 5.
CREATE VIEW EMPLOYEE_TRACKING AS
SELECT EmpNo, EmpName, Level
FROM EMPLOYEE
WHERE Level BETWEEN 3 AND 5;