-- THÊM 10 RECORD VÀO MỖI TABLE
INSERT INTO department(department_name)
VALUES ('IT'), ('LOGISTIC'), ('FINANCE'), ('PHÓ GIÁM ĐỐC'),
('LEGAL'), ('PRODUCTION'), ('PUBLIC RELATIONS'), ('HUMAN RESOURCE'),
('CUSTOMER SERVICE'), ('DESIGN');

INSERT INTO `position`(position_name) VALUES
('DEV'), ('DEV'), ('SCRUM_MASTER'), ('DEV'), ('PM'),
('DEV'), ('TEST'), ('PM'), ('DEV'), ('PM');

INSERT INTO `account` (email, username, fullname, department_id, position_id) VALUES 
('tranminhquan@gmail.com', 'tmq', 'TRẦN MINH QUÂN', 1, 1),
('lethithao@gmail.com', 'ltt', 'LÊ THỊ THẢO', 2, 2),
('phamquanghuy@gmail.com', 'pqh', 'PHẠM QUANG HUY', 3, 3),
('hoangthilan@gmail.com', 'htl', 'HOÀNG THỊ LAN', 4, 4),
('vuduchai@gmail.com', 'vdh', 'VŨ ĐỨC HẢI', 5, 5),
('buihoangnam@gmail.com', 'bhn', 'BÙI HOÀNG NAM', 1, 2),
('dangthimai@gmail.com', 'dtm', 'ĐẶNG THỊ MAI', 2, 3),
('ngoquochuy@gmail.com', 'nqh', 'NGÔ QUỐC HUY', 3, 1),
('duongthithu@gmail.com', 'dtt', 'DƯƠNG THỊ THU', 4, 5),
('buituananh@gmail.com', 'bta', 'BÙI TUẤN ANH', 5, 4);

INSERT INTO `group` (group_name, creator_id) 
VALUES 
    ('CLOUD ARCHITECTS', 1),
    ('DATABASE TUNING EXPERTS', 2),
    ('UI/UX DESIGN HUB', 3),
    ('CYBER SECURITY SHIELD', 4),
    ('MOBILE APP NINJAS', 5),
    ('AI & MACHINE LEARNING LAB', 6),
    ('DEVOPS AUTOMATION SQUAD', 7),
    ('QUALITY CONTROL MASTERS', 8),
    ('AGILE TRANSFORMATION TEAM', 9),
    ('ENTERPRISE SOLUTIONS GROUP', 10);
    
INSERT INTO group_account (group_id, account_id) 
VALUES (1, 2), (2, 3), (3, 4), (4, 5), (5, 1),
(2, 1), (3, 2), (4, 3), (5, 4), (1, 5);

INSERT INTO type_question (type_name) 
VALUES ('ESSAY'), ('MULTIPLE_CHOICE'),
('ESSAY'),('MULTIPLE_CHOICE'),('MULTIPLE_CHOICE'),
('ESSAY'), ('MULTIPLE_CHOICE'),
('ESSAY'),('MULTIPLE_CHOICE'),('MULTIPLE_CHOICE');

INSERT INTO category_question (category_name) 
VALUES ('HTML/CSS'), ('JAVASCRIPT'), ('REACTJS'), 
    ('NODEJS'), ('PHP'), ('RUBY'), ('GO'), ('SWIFT'), 
    ('KOTLIN'), ('DEVOPS');

INSERT INTO question (content, category_id, type_id, creator_id) 
VALUES ('HTML LÀ GÌ?', 6, 2, 1),
    ('CSS DÙNG ĐỂ LÀM GÌ?', 6, 2, 2),
    ('CLOSURE TRONG JAVASCRIPT LÀ GÌ?', 7, 1, 3),
    ('REACTJS LÀ THƯ VIỆN HAY FRAMEWORK?', 8, 2, 4),
    ('EVENT LOOP TRONG NODEJS HOẠT ĐỘNG NHƯ THẾ NÀO?', 9, 1, 5),
    ('SESSION VÀ COOKIE KHÁC NHAU NHƯ THẾ NÀO?', 10, 1, 6),
    ('BLOCKING VÀ NON-BLOCKING TRONG PHP KHÁC NHAU Ở ĐÂU?', 10, 2, 7),
    ('GEM TRONG RUBY LÀ GÌ?', 11, 2, 8),
    ('GOROUTINE TRONG GO LÀ GÌ?', 12, 1, 9),
    ('CONTAINERIZATION LÀ GÌ?', 15, 2, 10);
    
INSERT INTO answer (content, question_id, is_correct) 
VALUES 
    ('NGÔN NGỮ KỊCH BẢN PHÍA CLIENT', 4, 1),
    ('NGÔN NGỮ QUẢN TRỊ CƠ SỞ DỮ LIỆU', 4, 0),
    ('SIÊU VĂN BẢN MARKUP LANGUAGE', 6, 1),
    ('NGÔN NGỮ LẬP TRÌNH HỆ THỐNG', 6, 0),
    ('DÙNG ĐỂ ĐỊNH DẠNG GIAO DIỆN TRANG WEB', 7, 1),
    ('DÙNG ĐỂ TẠO CƠ SỞ DỮ LIỆU', 7, 0),
    ('MỘT HÀM ĐƯỢC NHỚ KÈM MÔI TRƯỜNG KHỞI TẠO CỦA NÓ', 8, 1),
    ('MỘT BIẾN TOÀN CỤC TRONG JAVASCRIPT', 8, 0),
    ('THƯ VIỆN JAVASCRIPT DO FACEBOOK PHÁT TRIỂN', 9, 1),
    ('MỘT HỆ QUẢN TRỊ CƠ SỞ DỮ LIỆU', 9, 0);
    
INSERT INTO exam (code, title, category_id, duration, creator_id) 
VALUES
(106, 'ĐỀ THI HTML/CSS CƠ BẢN', 6, '00:30:00', 1),
(107, 'ĐỀ THI JAVASCRIPT NÂNG CAO', 7, '01:00:00', 2),
(108, 'ĐỀ THI REACTJS THỰC HÀNH', 8, '00:45:00', 3),
(109, 'ĐỀ THI NODEJS API', 9, '00:45:00', 4),
(110, 'ĐỀ THI PHP & MYSQL', 10, '01:00:00', 5),
(111, 'ĐỀ THI RUBY ON RAILS', 11, '00:30:00', 1),
(112, 'ĐỀ THI GO PROGRAMMING', 12, '00:45:00', 2),
(113, 'ĐỀ THI SWIFT MOBILE', 13, '00:30:00', 3),
(114, 'ĐỀ THI KOTLIN ANDROID', 14, '01:00:00', 4),
(115, 'ĐỀ THI DEVOPS PIPELINE', 15, '00:15:00', 5);
    
INSERT INTO exam_question (exam_id, question_id) 
VALUES (1, 2), (2, 3), (3, 4), (4, 5), (5, 6),
    (6, 7), (7, 8), (8, 9), (9, 10), (10, 1);

-- LẤY RA TẤT CẢ PHÒNG BAN
SELECT * FROM department; 

-- LẤY RA ID CỦA PHÒNG BAN SALE
SELECT department_id FROM department WHERE department_name = 'SALE'; 

-- LẤY RA THÔNG TIN ACCOUNT CÓ FULLNAME DÀI NHẤT
SELECT * FROM `account` WHERE LENGTH(fullname) = 
(SELECT MAX(LENGTH(fullname)) FROM `account`);

-- LẤY RA THÔNG TIN ACCOUNT CÓ FULLNAME DÀI NHẤT VÀ 
-- THUỘC PHÒNG BAN CÓ ID = 3
SELECT * FROM `account` WHERE department_id = 3 AND 
LENGTH(fullname) = (SELECT MAX(LENGTH(fullname)) FROM `account`
WHERE department_id = 3);

-- LẤY TÊN GROUP ĐÃ THAM GIA TRƯỚC NGÀY 20/12/2019
SELECT DISTINCT g.group_name
FROM `group` g
JOIN group_account ga ON g.group_id = ga.group_id
WHERE ga.join_date < '2019-12-20';

-- LẤY RA ID CỦA QUESTION CÓ >=4 CÂU TRẢ LỜI
SELECT question_id FROM answer 
GROUP BY question_id HAVING COUNT(1) >= 4;

-- LẤY RA CÁC MÃ ĐỀ THI CÓ THỜI GIAN THI >= 60 PHÚT VÀ TẠO TRƯỚC 20/12/2019
SELECT code FROM exam WHERE duration >= '01:00:00'
AND create_date < '2019-12-20';

-- LẤY RA 5 GROUP TẠO GẦN ĐÂY
SELECT * FROM `group` ORDER BY create_date DESC LIMIT 5;

-- ĐẾM SỐ NV THUỘC department_id = 2
SELECT COUNT(1) AS total_account FROM `account` WHERE department_id = 2;

-- LẤY RA NHÂN VIÊN CÓ TÊN BẮT ĐẦU BẰNG D VÀ KẾT THÚC BẰNG o
SELECT * FROM `account` WHERE fullname LIKE 'D%o';

-- XÓA TẤT CẢ EXAM TẠO TRƯỚC NGÀY 20/12/2019
DELETE FROM exam WHERE create_date < '2019-12-20';

-- XÓA TẤT CẢ QUESTION CÓ NỘI DUNG BẮT ĐẦU BẰNG "câu hỏi"
DELETE FROM question WHERE content LIKE 'Câu hỏi%';

-- UPDATE THÔNG TIN account_id = 5 thành tên NGUYỄN BÁ LỘC và EMAIL thành loc.nguyenba@vti.com.vn
UPDATE `account` SET fullname = 'NGUYỄN BÁ LỘC',
email = 'loc.nguyenba@vti.com.vn' WHERE account_id = 5;

-- UPDATE ACCOUNT CÓ ID = 5 SẼ THUỘC GROUP CÓ ID = 4
UPDATE group_account SET group_id = 4
WHERE account_id = 5;
