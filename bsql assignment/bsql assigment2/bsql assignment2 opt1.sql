CREATE DATABASE fsotf_training;

USE fsotf_training;

-- a) Create the tables (with the most appropriate/economic field/column constraints &amp; types) and add at
-- least 10 records into each created table.

CREATE TABLE Trainee (
    TraineeID INT AUTO_INCREMENT PRIMARY KEY,
    Full_Name VARCHAR(255) NOT NULL,
    Birth_Date DATE NOT NULL,
    Gender ENUM('male', 'female') NOT NULL,
    ET_IQ INT NOT NULL CHECK (ET_IQ BETWEEN 0 AND 20),
    ET_Gmath INT NOT NULL CHECK (ET_Gmath BETWEEN 0 AND 20),
    ET_English INT NOT NULL CHECK (ET_English BETWEEN 0 AND 50),
    Training_Class VARCHAR(50) NOT NULL,
    Evaluation_Notes TEXT,
    CONSTRAINT unique_ET_IQ_ET_Gmath UNIQUE (ET_IQ, ET_Gmath)
);

INSERT INTO Trainee (Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes)
VALUES 
('Doan Van Huy', '1995-04-12', 'male', 18, 15, 45, 'f01', 'Excellent performance'),
('Le Vtraineetraineean Teo', '1996-07-23', 'female', 16, 17, 42, 'f02', 'Good in mathematics'),
('Vo Van Hoang', '1994-11-05', 'female', 20, 18, 50, 'f03', 'Outstanding in all subjects'),
('Truong Duy Minh', '1997-02-14', 'male', 10, 12, 38, 'f01', 'Needs improvement in math'),
('Truong Hoang Hieu', '1995-09-30', 'male', 12, 14, 40, 'f01', 'Good performance overall'),
('Le My Trang', '1996-06-18', 'female', 19, 16, 44, 'f03', 'Very good in English'),
('Dang Thi Huyen Lan', '1994-12-22', 'female', 15, 13, 41, 'f02', 'Consistent performance'),
('Le Quoc Bao', '1995-05-25', 'male', 14, 17, 39, 'f02', 'Strong in GMath'),
('Nguyen Thi Oanh', '1997-03-11', 'female', 13, 12, 35, 'f03', 'Needs improvement in IQ test'),
('Le Thanh Dai', '1996-10-08', 'male', 17, 15, 43, 'f01', 'Good performance in all subjects');

-- b) Change the table TRAINEE to add one more field named Fsoft_Account which is a not-null &amp; unique
-- field.
ALTER TABLE fsotf_training.Trainee
ADD COLUMN Fsoft_Account VARCHAR(100);

UPDATE Trainee SET Fsoft_Account = CONCAT('fsoft_', TraineeID);

ALTER TABLE Trainee
MODIFY COLUMN Fsoft_Account VARCHAR(100) NOT NULL UNIQUE;

-- c) Create a VIEW which includes all the ET-passed trainees. One trainee is considered as ET-passed
-- when he/she has the entry test points satisfied below criteria:
-- ET_IQ + ET_Gmath &gt;=20
-- ET_IQ&gt;=8
-- ET_Gmath&gt;=8
-- ET_English&gt;=18

CREATE VIEW ET_Passed_Trainees AS
SELECT 
    TraineeID,
    Full_Name,
    Birth_Date,
    Gender,
    ET_IQ,
    ET_Gmath,
    ET_English,
    Training_Class,
    Evaluation_Notes,
    Fsoft_Account
FROM 
    Trainee
WHERE 
    (ET_IQ + ET_Gmath) >= 20
    AND ET_IQ >= 8
    AND ET_Gmath >= 8
    AND ET_English >= 18;

SELECT * FROM ET_Passed_Trainees;

-- d) Query all the trainees who is passed the entry test, group them into different birth months.

SELECT 
    MONTH(Birth_Date) AS Birth_Month,
    COUNT(*) AS Number_of_Trainees,
    GROUP_CONCAT(Full_Name SEPARATOR ', ') AS Trainee_Names
FROM Trainee
WHERE 
    (ET_IQ + ET_Gmath) >= 20
    AND ET_IQ >= 8
    AND ET_Gmath >= 8
    AND ET_English >= 18
GROUP BY MONTH(Birth_Date)
ORDER BY Birth_Month;

-- e) Query to find the trainee with the longest name, showing his/her age along with basic information

SELECT 
    Trainee.*,
    TIMESTAMPDIFF(YEAR, Birth_Date, CURDATE()) AS Age
FROM 
    Trainee
ORDER BY 
    CHAR_LENGTH(Full_Name) DESC
LIMIT 1;


