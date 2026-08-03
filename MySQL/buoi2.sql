create database dtn2603_testing_system;
use dtn2603_testing_system;
CREATE TABLE department (
    department_id   INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);

CREATE TABLE `position` (
    position_id   INT AUTO_INCREMENT PRIMARY KEY,
    position_name ENUM('DEV', 'TEST', 'SCRUM_MASTER', 'PM') NOT NULL
);


CREATE TABLE `account` (
    account_id    INT AUTO_INCREMENT PRIMARY KEY,
    email         VARCHAR(100) NOT NULL UNIQUE,
    username      VARCHAR(100) NOT NULL UNIQUE,
    fullname      VARCHAR(100) NOT NULL,
    department_id INT,
    position_id   INT,
    create_date   DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_account_department
        FOREIGN KEY (department_id)
        REFERENCES department(department_id),

    CONSTRAINT fk_account_position
        FOREIGN KEY (position_id)
        REFERENCES `position`(position_id)
);


CREATE TABLE `group` (
    group_id    INT AUTO_INCREMENT PRIMARY KEY,
    group_name  VARCHAR(100) UNIQUE,
    creator_id  INT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_group_account
        FOREIGN KEY (creator_id)
        REFERENCES `account`(account_id)
);


CREATE TABLE group_account (
    group_id   INT,
    account_id INT,
    join_date  DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (group_id, account_id),

    CONSTRAINT fk_group_account_group
        FOREIGN KEY (group_id)
        REFERENCES `group`(group_id),

    CONSTRAINT fk_group_account_account
        FOREIGN KEY (account_id)
        REFERENCES `account`(account_id)
);


CREATE TABLE type_question (
    type_id   INT AUTO_INCREMENT PRIMARY KEY,
    type_name ENUM('ESSAY', 'MULTIPLE_CHOICE')
);


CREATE TABLE category_question (
    category_id   INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
);

CREATE TABLE question (
    question_id INT AUTO_INCREMENT PRIMARY KEY,
    content     VARCHAR(100) NOT NULL,
    category_id INT,
    type_id     INT,
    creator_id  INT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_question_category
        FOREIGN KEY (category_id)
        REFERENCES category_question(category_id),

    CONSTRAINT fk_question_type
        FOREIGN KEY (type_id)
        REFERENCES type_question(type_id),

    CONSTRAINT fk_question_account
        FOREIGN KEY (creator_id)
        REFERENCES `account`(account_id)
);


CREATE TABLE answer (
    answer_id   INT AUTO_INCREMENT PRIMARY KEY,
    content     VARCHAR(100),
    question_id INT,
    is_correct  BOOLEAN,

    CONSTRAINT fk_answer_question
        FOREIGN KEY (question_id)
        REFERENCES question(question_id)
);


CREATE TABLE exam (
    exam_id     INT AUTO_INCREMENT PRIMARY KEY,
    code        INT UNIQUE,
    title       VARCHAR(100),
    category_id INT,
    duration    TIME,
    creator_id  INT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_exam_category
        FOREIGN KEY (category_id)
        REFERENCES category_question(category_id),

    CONSTRAINT fk_exam_account
        FOREIGN KEY (creator_id)
        REFERENCES `account`(account_id)
);


CREATE TABLE exam_question (
    exam_id     INT,
    question_id INT,

    PRIMARY KEY (exam_id, question_id),

    CONSTRAINT fk_exam_question_exam
        FOREIGN KEY (exam_id)
        REFERENCES exam(exam_id),

    CONSTRAINT fk_exam_question_question
        FOREIGN KEY (question_id)
        REFERENCES question(question_id)
);

INSERT INTO department(department_name)
VALUES ('SALE'), ('MARKETING'), ('THƯ KÍ'), ('GIÁM ĐỐC'),
('BẢO VỆ');

INSERT INTO `position`(position_name) VALUES
('DEV'), ('TEST'), ('SCRUM_MASTER'), ('DEV'), ('PM');

INSERT INTO `account` (email, username, fullname, department_id, position_id) VALUES 
('nguyenhungthinh@gmail.com', 'nht', 'NGUYỄN HƯNG THỊNH',1,1),
('nguyenthanhnam@gmail.com', 'ntn', 'NGUYỄN THÀNH NAM',2,2),
('nguyenkhanhduy@gmail.com', 'nkd', 'NGUYỄN KHÁNH DUY',3,4),
('nguyenduclong@gmail.com', 'ndl', 'NGUYỄN ĐỨC LONG',4,3),
('nguyenthingocquynh@gmail.com', 'ntnq', 'NGUYỄN THỊ NGỌC QUỲNH',5,5);

INSERT INTO `group` (group_name, creator_id) 
VALUES 
    ('DEV ELITE', 1),
    ('TESTING TEAM PRO', 2),
    ('SCRUM MASTER HUB', 5),
    ('BOARD OF DIRECTORS', 4),
    ('MARKETING STRATEGY 2026', 1);
    
INSERT INTO group_account (group_id, account_id) 
VALUES (1, 1), (1, 3), (2, 2), (3, 5), (4, 4);

INSERT INTO type_question (type_name) 
VALUES ('ESSAY'), ('MULTIPLE_CHOICE'),
('ESSAY'),('MULTIPLE_CHOICE'),('MULTIPLE_CHOICE');

INSERT INTO category_question (category_name) 
VALUES ('JAVA'), ('SQL'), ('C#'), ('PYTHON'), ('C++');

INSERT INTO question (content, category_id, type_id, creator_id) 
VALUES ('JAVA LÀ GÌ?', 1, 1, 1),
    ('CÂU LỆNH SELECT DÙNG ĐỂ LÀM GÌ?', 2, 2, 2),
    ('OOP CÓ MẤY TÍNH CHẤT CƠ BẢN?', 1, 2, 1),
    ('PYTHON LÀ GÌ?', 4, 2, 3),
    ('STATIC LÀ GÌ?', 5, 1, 4);
    
INSERT INTO answer (content, question_id, is_correct) 
VALUES 
    ('NGÔN NGỮ LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG', 1, 1),
    ('NGÔN NGỮ MÁY TÍNH CẤP THẤP', 1, 0),
    ('TRUY VẤN DỮ LIỆU', 2, 1),
    ('THÊM DỮ LIỆU MỚI', 2, 0),
    ('CÓ 4 TÍNH CHẤT', 3, 1);
    
INSERT INTO exam (code, title, category_id, duration, creator_id) 
VALUES 
    (101, 'ĐỀ THI JAVA CƠ BẢN', 1, '00:45:00', 1),
    (102, 'ĐỀ THI SQL NÂNG CAO', 2, '01:00:00', 2),
    (103, 'ĐỀ THI C# TRẮC NGHIỆM', 3, '00:30:00', 1),
    (104, 'ĐỀ THI PYTHON CƠ BẢN', 4, '00:45:00', 3),
    (105, 'ĐỀ THI C++', 5, '00:15:00', 4);
    
INSERT INTO exam_question (exam_id, question_id) 
VALUES (1, 1), (1, 3), (2, 2), (4, 4), (5, 5);

