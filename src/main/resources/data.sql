-- H2 啟動時載入的少量示範資料。
-- ID 由 API 呼叫者提供，方便初學者直接看懂資料內容。

INSERT INTO college (CollegeName, CollegeTotalStudents)
VALUES ('SCCC', 26711);

INSERT INTO buildings (BuildingID, BuildingName, CollegeName)
VALUES (1, 'Riverhead', 'SCCC');

INSERT INTO classrooms (RoomNumber, HasProjector, BuildingID)
VALUES (201, 'Y', 1);

INSERT INTO textbook (TextbookISBN, TextbookTitle, TextbookAuthor)
VALUES (200, 'Computer Science Illustrated', 'John Smith');

INSERT INTO course (CourseID, CourseName, TextbookISBN)
VALUES (1, 'Computer Science I', 200);

INSERT INTO person (PersonID, PersonPhoneNumber, PersonName)
VALUES (1, '02-12345678', 'Tanya Ferguson');

INSERT INTO faculty (FacultyID, FacultyTitle, FacultySalary, FacultyName, PersonID)
VALUES (1, 'Head Of Computer Science', 100000, 'Tanya Ferguson', 1);

INSERT INTO interns (InternID, PersonID, InternHourlyWage)
VALUES (1, 1, 14);

INSERT INTO student (StudentID, StudentGPA, StudentName, PersonID)
VALUES (1, 4.0, 'Jerry Ryan', 1);

INSERT INTO student (StudentID, StudentGPA, StudentName, PersonID)
VALUES (2, 3.2, 'Hugo Jurgens', 1);

INSERT INTO school_section (SectionID, SectionDate, RoomNumber, CourseID, BuildingID, PersonID)
VALUES (100, '2024-09-01', 201, 1, 1, 1);
