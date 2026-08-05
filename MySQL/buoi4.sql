-- Viet lenh lay ra dsach nv va ttin phong ban cua ho
SELECT acc.fullname, dep.department_name FROM `account` acc LEFT JOIN department dep
ON acc.department_id = dep.department_id;

-- Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT * FROM `account` WHERE create_date > '2010-12-20';

-- Viết lệnh để lấy ra tất cả các developer
SELECT * FROM `account` acc JOIN position po
ON acc.position_id = po.position_id
WHERE po.position_name = 'DEV';

-- Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT dep.department_id, count(acc.department_id) AS so_luong
 FROM department dep LEFT JOIN `account` acc
 ON dep.department_id = acc.department_id
 GROUP BY dep.department_id HAVING count(acc.account_id) > 3;
 
 -- Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT q.question_id, q.content, count(eq.exam_id) AS so_luong
FROM question q JOIN exam_question eq 
ON q.question_id = eq.question_id
GROUP BY q.question_id, q.content
HAVING so_luong =
(SELECT count(eq2.exam_id) FROM exam_question eq2
GROUP BY eq2.question_id ORDER BY count(eq2.exam_id) DESC LIMIT 1);

-- Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT cq.category_id, cq.category_name, COUNT(q.question_id) 
AS so_luong
FROM category_question cq LEFT JOIN question q
on cq.category_id = q.category_id
GROUP BY cq.category_id, cq.category_name;

-- Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT q.question_id,COUNT(eq.exam_id) AS so_luong
FROM question q LEFT JOIN exam_question eq
ON q.question_id = eq.question_id
GROUP BY q.question_id;

-- Lấy ra Question có nhiều câu trả lời nhất
SELECT q.question_id, COUNT(a.answer_id) AS so_luong
FROM question q JOIN answer a 
ON q.question_id = a.question_id
GROUP BY q.question_id
HAVING so_luong = (
SELECT COUNT(a2.answer_id) FROM answer a2
GROUP BY a2.question_id
ORDER BY COUNT(a2.answer_id) DESC LIMIT 1);

-- Thống kê số lượng account trong mỗi group
SELECT g.group_id, g.group_name, COUNT(ga.account_id) AS so_luong
FROM `group` g LEFT JOIN group_account ga
ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name;

-- Tìm chức vụ có ít người nhất
SELECT p.position_id, p.position_name, COUNT(acc.account_id) AS so_luong
FROM `position` p LEFT JOIN `account` acc
ON p.position_id = acc.position_id
GROUP BY p.position_id
HAVING so_luong = (
SELECT COUNT(acc2.account_id) FROM `position` p2 
LEFT JOIN `account` acc2 ON p2.position_id = acc2.position_id
    GROUP BY p2.position_id
    ORDER BY COUNT(acc2.account_id) ASC
    LIMIT 1
);

-- Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 
    dep.department_id,
    dep.department_name,
    SUM(CASE WHEN po.position_name = 'DEV' THEN 1 ELSE 0 END) AS so_luong_dev,
    SUM(CASE WHEN po.position_name = 'TEST' THEN 1 ELSE 0 END) AS so_luong_test,
    SUM(CASE WHEN po.position_name = 'SCRUM_MASTER' THEN 1 ELSE 0 END) AS so_luong_scrum_master,
    SUM(CASE WHEN po.position_name = 'PM' THEN 1 ELSE 0 END) AS so_luong_pm,
    COUNT(acc.account_id) AS tong_so_nhan_vien
FROM department dep
LEFT JOIN `account` acc ON dep.department_id = acc.department_id
LEFT JOIN `position` po ON acc.position_id = po.position_id
GROUP BY dep.department_id, dep.department_name;

--  Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT q.question_id,
    q.content AS question_content,
    cq.category_name,
    tq.type_name,
    acc.fullname AS creator_fullname,
    a.content AS answer_content,
    a.is_correct
FROM question q
LEFT JOIN type_question tq ON q.type_id = tq.type_id
LEFT JOIN category_question cq ON q.category_id = cq.category_id
LEFT JOIN `account` acc ON q.creator_id = acc.account_id
LEFT JOIN answer a ON q.question_id = a.question_id;

-- Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT tq.type_id,tq.type_name, COUNT(q.question_id) AS so_luong_cau_hoi
FROM type_question tq
LEFT JOIN question q ON tq.type_id = q.type_id
GROUP BY tq.type_id, tq.type_name;

-- Lấy ra group không có account nào
SELECT g.group_id, g.group_name
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
WHERE ga.account_id IS NULL;

-- Lấy ra question không có answer nào
SELECT q.question_id, q.content
FROM question q
LEFT JOIN answer a ON q.question_id = a.question_id
WHERE a.answer_id IS NULL;