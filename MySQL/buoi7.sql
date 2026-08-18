-- QUESTION 1 

DELIMITER $$

CREATE TRIGGER trg_group_check_create_date
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
    IF NEW.create_date < DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Group create date cannot be older than 1 year';
    END IF;
END $$

DELIMITER ;

INSERT INTO `group`(group_name,creator_id, create_date) VALUES ('TESTER','2','2025-01-01');

-- QUESTION 2 
DELIMITER $$
CREATE TRIGGER trg_account_not_sale
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    DECLARE v_department_name VARCHAR(100);

    SELECT department_name
    INTO v_department_name
    FROM department
    WHERE department_id = NEW.department_id;

    IF v_department_name = 'SALE' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END $$
DELIMITER ;

INSERT INTO `account`
(email, username, fullname, department_id, position_id)
VALUES
('test@gmail.com', 'test', 'TEST USER', 1, 1);

-- QUESTION 3 

DELIMITER $$
CREATE TRIGGER trg_group_max_5_users
BEFORE INSERT ON group_account
FOR EACH ROW
BEGIN
    DECLARE v_count INT;
    SELECT COUNT(*)
    INTO v_count
    FROM group_account
    WHERE group_id = NEW.group_id;

    IF v_count >= 5 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'A group can have maximum 5 users';
    END IF;
END $$

DELIMITER ;


-- QUESTION 4 
DELIMITER $$

CREATE TRIGGER trg_exam_max_10_questions
BEFORE INSERT ON exam_question
FOR EACH ROW
BEGIN
    DECLARE v_count INT;

    SELECT COUNT(1) INTO v_count
    FROM exam_question
    WHERE exam_id = NEW.exam_id;

    IF v_count >= 10 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'An exam can have maximum 10 questions';
    END IF;
END $$

DELIMITER ;


-- QUESTION 5 
DELIMITER $$

CREATE TRIGGER trg_account_before_delete
BEFORE DELETE ON account
FOR EACH ROW
BEGIN 
	IF OLD.email = 'admin@gmail.com' THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'cannot delete admin account';
	ELSE 
		DELETE FROM group_account
		WHERE account_id = OLD.account_id;
	END IF;

END $$

DELIMITER ;

-- QUESTION 6
DELIMITER $$

CREATE TRIGGER tg_waiting_department
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
	DECLARE v_id_waiting_dept INT;
	
	IF NEW.department_id IS NULL THEN
		SELECT d.department_id INTO v_id_waiting_dept
		FROM department d 
		WHERE d.department_name = 'waiting Department';
		
		SET NEW.department_id = v_id_waiting_dept;
	END IF;
END $$

DELIMITER ; 


-- QUESTION 7  
DELIMITER $$

CREATE TRIGGER tg_answer_limit
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
	DECLARE v_total_answer INT;
	DECLARE v_correct_total INT;

	SELECT count(1) INTO v_total_answer
	FROM answer as a
	WHERE a.question_id = NEW.question_id
	GROUP BY a.question_id;

	IF v_total_answer >= 4 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Maximum 4 answers';
	END IF;

	IF NEW.is_correct = TRUE THEN
		SELECT count(1) INTO v_correct_total
		FROM answer as a
		WHERE a.answer_id = NEW.answer_id AND a.is_correct = TRUE;
		
		IF v_correct_total >= 2 THEN 
 			SIGNAL SQLSTATE '45000'
            		SET MESSAGE_TEXT='Maximum 2 correct answers';
		END IF;
	END IF;

END $$

DELIMITER ;

-- QUESTION 8
ALTER TABLE account ADD gender ENUM('M','F','U');

DELIMITER $$

CREATE TRIGGER trg_gender
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
	IF LOWER(NEW.gender) = 'nữ' THEN
		SET NEW.gender = 'F';
	ELSEIF LOWER(NEW.gender) = 'nam' THEN
		SET NEW.gender = 'M';
	ELSEIF LOWER(NEW.gender) = 'chưa xác định' THEN
		SET NEW.gender = 'U';	
	END IF;
END $$

DELIMITER ;

-- QUESTION 9 
DELIMITER $$

CREATE TRIGGER trg_exam_cannot_delete_2_days
BEFORE DELETE ON exam
FOR EACH ROW
BEGIN

    IF OLD.create_date >= DATE_SUB(NOW(), INTERVAL 2 DAY) THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'Cannot delete exam created within the last 2 days';

    END IF;

END $$

DELIMITER ;

-- QUESTION 10 
DELIMITER $$

CREATE TRIGGER trg_question_before_update
BEFORE UPDATE ON question
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1
        FROM exam_question
        WHERE question_id = OLD.question_id) THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'Cannot update question because it is used in an exam';
    END IF;
END $$
DELIMITER ;

DROP TRIGGER IF EXISTS trg_question_before_delete;
DELIMITER $$
CREATE TRIGGER trg_question_before_delete
BEFORE DELETE ON question
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1
        FROM exam_question
        WHERE question_id = OLD.question_id
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'Cannot delete question because it is used in an exam';
END IF;
END $$
DELIMITER ;

-- QUESTION 12  
SELECT exam_id, code, title, duration,
CASE WHEN TIME_TO_SEC(duration) / 60 <= 30 THEN 'Short time'
WHEN TIME_TO_SEC(duration) / 60 <= 60 THEN 'Medium time'
ELSE 'Long time'
END AS duration_type
FROM exam;

-- QUESTION 13  
SELECT g.group_id, g.group_name, COUNT(ga.account_id) AS so_luong_user,
CASE WHEN COUNT(ga.account_id) <= 5
THEN 'few' WHEN COUNT(ga.account_id) <= 20
THEN 'normal' ELSE 'higher'
END AS the_number_user_amount
FROM `group` g
LEFT JOIN group_account ga
ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name;


-- QUESTION 14 
SELECT d.department_id, d.department_name,
CASE  WHEN COUNT(a.account_id) = 0
THEN 'Không có User'
ELSE CAST(COUNT(a.account_id) AS CHAR)
END AS so_luong_user
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id, d.department_name;