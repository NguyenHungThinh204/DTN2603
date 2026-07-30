create database dtn2603_testing_system;
use dtn2603_testing_system;
create table department(
	department_id int primary key auto_increment,
    department_name varchar(100)
);
create table `position`(
	position_id int primary key auto_increment,
    position_name enum('DEV','TEST','SCRUM MASTER','PM')
);
create table `account`(
	account_id int primary key auto_increment,
    email varchar(100) unique,
    username varchar(100) unique,
    full_name varchar(100),
    department_id int,
    position_id int,
    create_date datetime,
    constraint fk_account_department foreign key (department_id) references department(department_id), 
	constraint fk_account_position foreign key (position_id) references `position`(position_id)
);
create table `group` (
	group_id int primary key auto_increment,
    group_name varchar(100),
    creator_id int,
    create_date datetime
);
create table group_account(
	group_id int,
    account_id int, 
    join_date datetime,
    primary key (group_id, account_id)
);
create table type_question(
	type_id int primary key auto_increment,
    type_name enum('ESSAY','MULTIPLE-CHOICE')
);
create table category_question(
	category_id int primary key auto_increment,
    category_name enum('JAVA', '.NET', 'SQL', 'POSTMAN', 'RUBY')
);
create table question(
	question_id int primary key auto_increment,
    content varchar(100),
    category_id int,
    type_id int,
    creator_id int,
    create_date datetime,
    constraint fk_question_category_question foreign key (category_id) references category_question(category_id), 
    constraint fk_question_type_question foreign key (type_id) references type_question(type_id)
);
create table answer(
	answer_id int primary key auto_increment,
    content varchar(100),
    question_id int,
    is_correct boolean,
    constraint fk_answer_question foreign key (question_id) references question(question_id)
);
create table exam(
	exam_id int primary key auto_increment,
    code int,
    title varchar(100),
    category_id int,
    duration int,
    creator_id int,
    create_date int
);
create table exam_question(
	exam_id int,
    question_id int,
    primary key (exam_id, question_id),
    constraint fk_exam_question_exam foreign key (exam_id) references exam(exam_id),
    constraint fk_exam_question_question foreign key (question_id) references question(question_id)
);
