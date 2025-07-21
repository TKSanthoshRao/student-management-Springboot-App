CREATE SEQUENCE student_id_seq START WITH 1221925;

create table student(
    id INT PRIMARY KEY DEFAULT nextval('student_id_seq'),
    name varchar(50),
    marks float,
    gender char(1) check(gender IN ('M','F'))
);