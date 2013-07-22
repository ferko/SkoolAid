-- You can use this file to load seed data into the database using SQL statements
insert into Users (User_name, Password, Email, Role, Course_Option) values ('frank', 'd6098675afaf311aaf9f63e8826bd96485d69781e543868508e27a546757de2d', 'ferko1177@gmail.com', 'ADMIN', 1)
insert into Option_Course (Option_ID, Course_ID) values (1, 'COMP4911')
insert into Option_Course (Option_ID, Course_ID) values (1, 'COMP4100')
insert into Option_Course (Option_ID, Course_ID) values (1, 'COMP4900')
insert into Option_Course (Option_ID, Course_ID) values (1, 'BLAW3600')
insert into Option_Course (Option_ID, Course_ID) values (1, 'COMP4870')
insert into Option_Course (Option_ID, Course_ID) values (1, 'COMP4735')
insert into Option_Course (Option_ID, Course_ID) values (1, 'COMP4915')
insert into Course_Options (OPTION_ID, COURSE_NAME, INSTRUCTOR) values (1, 'Info Systems', 'Bruce Link')
insert into Courses (Course_ID, Course_name, Instructor) values ('COMP4911', 'Managing IS Development', 'Bruce Link')
insert into Courses (Course_ID, Course_name, Instructor) values ('COMP4100', 'Career Preperation', 'Richard Chau')
insert into Courses (Course_ID, Course_name, Instructor) values ('COMP4900', 'Projects Practicum', 'N/A')
insert into Courses (Course_ID, Course_name, Instructor) values ('BLAW3600', 'Computers and Law', 'Catherine Ryan')
insert into Courses (Course_ID, Course_name, Instructor) values ('COMP4870', 'Intranet Planning and Development', 'Medhat Elmasry')
insert into Courses (Course_ID, Course_name, Instructor) values ('COMP4735', 'Operating Systems', 'Dennis Richards')
insert into Courses (Course_ID, Course_name, Instructor) values ('COMP4915', 'Special Topics in MIS', 'Bruce Link')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (1, 'Chapter 1', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (2, 'Chapter 2', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (3, 'Chapter 3', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (4, 'Chapter 4', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (5, 'Chapter 5', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (6, 'Chapter 6', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (7, 'Chapter 7', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (8, 'Chapter 8', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (9, 'Chapter 9', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (10, 'Chapter 10', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (11, 'Chapter 11', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (12, 'Chapter 12', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (13, 'Chapter 13', 'COMP4911')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (14, 'Chapter 1', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (15, 'Chapter 2', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (16, 'Chapter 3', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (17, 'Chapter 4', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (18, 'Chapter 5', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (19, 'Chapter 6', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (20, 'Chapter 7', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (21, 'Chapter 8', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (22, 'Chapter 9', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (23, 'Chapter 10', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (24, 'Chapter 11', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (25, 'Chapter 12', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (26, 'Chapter 13', 'COMP4100')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (27, 'Chapter 1', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (28, 'Chapter 2', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (29, 'Chapter 3', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (30, 'Chapter 4', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (31, 'Chapter 5', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (32, 'Chapter 6', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (33, 'Chapter 7', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (34, 'Chapter 8', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (35, 'Chapter 9', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (36, 'Chapter 10', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (37, 'Chapter 11', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (38, 'Chapter 12', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (39, 'Chapter 13', 'COMP4900')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (40, 'Chapter 1', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (41, 'Chapter 2', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (42, 'Chapter 3', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (43, 'Chapter 4', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (44, 'Chapter 5', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (45, 'Chapter 6', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (46, 'Chapter 7', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (47, 'Chapter 8', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (48, 'Chapter 9', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (49, 'Chapter 10', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (50, 'Chapter 11', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (51, 'Chapter 12', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (52, 'Chapter 13', 'BLAW3600')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (53, 'Chapter 1', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (54, 'Chapter 2', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (55, 'Chapter 3', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (56, 'Chapter 4', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (57, 'Chapter 5', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (58, 'Chapter 6', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (59, 'Chapter 7', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (60, 'Chapter 8', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (61, 'Chapter 9', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (62, 'Chapter 10', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (63, 'Chapter 11', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (64, 'Chapter 12', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (65, 'Chapter 13', 'COMP4870')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (66, 'Chapter 1', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (67, 'Chapter 2', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (68, 'Chapter 3', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (69, 'Chapter 4', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (70, 'Chapter 5', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (71, 'Chapter 6', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (72, 'Chapter 7', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (73, 'Chapter 8', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (74, 'Chapter 9', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (75, 'Chapter 10', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (76, 'Chapter 11', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (77, 'Chapter 12', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (78, 'Chapter 13', 'COMP4735')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (79, 'Chapter 1', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (80, 'Chapter 2', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (81, 'Chapter 3', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (82, 'Chapter 4', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (83, 'Chapter 5', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (84, 'Chapter 6', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (85, 'Chapter 7', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (86, 'Chapter 8', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (87, 'Chapter 9', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (88, 'Chapter 10', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (89, 'Chapter 11', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (90, 'Chapter 12', 'COMP4915')
insert into Chapters (Chapter_ID, Chapter, Course_ID) values (91, 'Chapter 13', 'COMP4915')
insert into Events (Event_ID, Event_title, Date, Time, Course_ID) values (1, 'This is where I would put the description for an event', '01/09/13', '12:30am', 'COMP4911')