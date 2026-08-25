import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;
public class Program {

    public static void main(String[] args) {

        // 1. Department

        Department department1 = new Department();
        department1.departmentId = 1;
        department1.departmentName = "Marketing";

        Department department2 = new Department();
        department2.departmentId = 2;
        department2.departmentName = "Sale";

        Department department3 = new Department();
        department3.departmentId = 3;
        department3.departmentName = "IT";

        System.out.println("Department 1: " + department1.departmentName);
        System.out.println("Department 2: " + department2.departmentName);
        System.out.println("Department 3: " + department3.departmentName);

        // 2. Position

        Position position1 = new Position();
        position1.positionId = 1;
        position1.positionName = PositionName.DEV;

        Position position2 = new Position();
        position2.positionId = 2;
        position2.positionName = PositionName.TEST;

        Position position3 = new Position();
        position3.positionId = 3;
        position3.positionName = PositionName.PM;

        System.out.println("Position 1: " + position1.positionName);
        System.out.println("Position 2: " + position2.positionName);
        System.out.println("Position 3: " + position3.positionName);

        // 3. Account

        Account account1 = new Account();
        account1.accountId = 1;
        account1.email = "thinh@gmail.com";
        account1.userName = "thinh";
        account1.fullName = "Nguyen Hung Thinh";
        account1.createDate = new Date();
        account1.departmentId = department1;
        account1.positionId = position1;

        Account account2 = new Account();
        account2.accountId = 2;
        account2.email = "nam@gmail.com";
        account2.userName = "nam";
        account2.fullName = "Nguyen Van Nam";
        account2.createDate = new Date();
        account2.departmentId = department2;
        account2.positionId = position2;

        Account account3 = new Account();
        account3.accountId = 3;
        account3.email = "hung@gmail.com";
        account3.userName = "hung";
        account3.fullName = "Tran Van Hung";
        account3.createDate = new Date();
        account3.departmentId = department3;
        account3.positionId = position3;

        System.out.println("Account 1: " + account1.fullName);
        System.out.println("Account 2: " + account2.fullName);
        System.out.println("Account 3: " + account3.fullName);

        // 4. CategoryQuestion

        CategoryQuestion category1 = new CategoryQuestion();
        category1.categoryId = 1;
        category1.categoryName = CategoryName.JAVA;

        CategoryQuestion category2 = new CategoryQuestion();
        category2.categoryId = 2;
        category2.categoryName = CategoryName.SQL;

        CategoryQuestion category3 = new CategoryQuestion();
        category3.categoryId = 3;
        category3.categoryName = CategoryName.NET;

        System.out.println("Category 1: " + category1.categoryName);
        System.out.println("Category 2: " + category2.categoryName);
        System.out.println("Category 3: " + category3.categoryName);

        // 5. TypeQuestion

        TypeQuestion type1 = new TypeQuestion();
        type1.typeId = 1;
        type1.typeName = TypeName.MULTIPLE_CHOICE;

        TypeQuestion type2 = new TypeQuestion();
        type2.typeId = 2;
        type2.typeName = TypeName.ESSAY;

        TypeQuestion type3 = new TypeQuestion();
        type3.typeId = 3;
        type3.typeName = TypeName.MULTIPLE_CHOICE;

        System.out.println("Type 1: " + type1.typeName);
        System.out.println("Type 2: " + type2.typeName);
        System.out.println("Type 3: " + type3.typeName);

        // 6. Question

        Question question1 = new Question();
        question1.questionId = 1;
        question1.content = "Java la gi?";
        question1.categoryId = category1;
        question1.typeId = type1;
        question1.creatorId = account1;
        question1.createDate = new Date();

        Question question2 = new Question();
        question2.questionId = 2;
        question2.content = "SQL dung de lam gi?";
        question2.categoryId = category2;
        question2.typeId = type2;
        question2.creatorId = account2;
        question2.createDate = new Date();

        Question question3 = new Question();
        question3.questionId = 3;
        question3.content = "Spring Boot la gi?";
        question3.categoryId = category1;
        question3.typeId = type1;
        question3.creatorId = account3;
        question3.createDate = new Date();

        System.out.println("Question 1: " + question1.content);
        System.out.println("Question 2: " + question2.content);
        System.out.println("Question 3: " + question3.content);

        // 7. Answer

        Answer answer1 = new Answer();
        answer1.answerId = 1;
        answer1.content = "Java la ngon ngu lap trinh";
        answer1.questionId = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.answerId = 2;
        answer2.content = "SQL dung de truy van co so du lieu";
        answer2.questionId = question2;
        answer2.isCorrect = true;

        Answer answer3 = new Answer();
        answer3.answerId = 3;
        answer3.content = "Spring Boot la framework Java";
        answer3.questionId = question3;
        answer3.isCorrect = true;

        System.out.println("Answer 1: " + answer1.content);
        System.out.println("Answer 2: " + answer2.content);
        System.out.println("Answer 3: " + answer3.content);

        // 8. Exam

        Exam exam1 = new Exam();
        exam1.examId = 1;
        exam1.code = "EX001";
        exam1.title = "Java Basic";
        exam1.categoryId = category1;
        exam1.duration = LocalDate.now();
        exam1.creatorId = account1;
        exam1.createDate = new Date();

        Exam exam2 = new Exam();
        exam2.examId = 2;
        exam2.code = "EX002";
        exam2.title = "SQL Basic";
        exam2.categoryId = category2;
        exam2.duration = LocalDate.now();
        exam2.creatorId = account2;
        exam2.createDate = new Date();

        Exam exam3 = new Exam();
        exam3.examId = 3;
        exam3.code = "EX003";
        exam3.title = "Java Spring";
        exam3.categoryId = category1;
        exam3.duration = LocalDate.now();
        exam3.creatorId = account3;
        exam3.createDate = new Date();

        System.out.println("Exam 1: " + exam1.title);
        System.out.println("Exam 2: " + exam2.title);
        System.out.println("Exam 3: " + exam3.title);

        // 9. ExamQuestion

        ExamQuestion examQuestion1 = new ExamQuestion();
        examQuestion1.examId = exam1;
        examQuestion1.questionId = question1;

        ExamQuestion examQuestion2 = new ExamQuestion();
        examQuestion2.examId = exam2;
        examQuestion2.questionId = question2;

        ExamQuestion examQuestion3 = new ExamQuestion();
        examQuestion3.examId = exam3;
        examQuestion3.questionId = question3;

        System.out.println("ExamQuestion 1: " + examQuestion1.questionId.content);
        System.out.println("ExamQuestion 2: " + examQuestion2.questionId.content);
        System.out.println("ExamQuestion 3: " + examQuestion3.questionId.content);

        // 10. Group

        Group group1 = new Group();
        group1.groupId = 1;
        group1.groupName = "Java Group";
        group1.creatorId = account1;
        group1.createDate = new Date();

        Group group2 = new Group();
        group2.groupId = 2;
        group2.groupName = "SQL Group";
        group2.creatorId = account2;
        group2.createDate = new Date();

        Group group3 = new Group();
        group3.groupId = 3;
        group3.groupName = "Testing Group";
        group3.creatorId = account3;
        group3.createDate = new Date();

        System.out.println("Group 1: " + group1.groupName);
        System.out.println("Group 2: " + group2.groupName);
        System.out.println("Group 3: " + group3.groupName);

        // 11. GroupAccount

        GroupAccount groupAccount1 = new GroupAccount();
        groupAccount1.group = group1;
        groupAccount1.account = account1;
        groupAccount1.joinDate = new Date();

        GroupAccount groupAccount2 = new GroupAccount();
        groupAccount2.group = group2;
        groupAccount2.account = account2;
        groupAccount2.joinDate = new Date();

        GroupAccount groupAccount3 = new GroupAccount();
        groupAccount3.group = group3;
        groupAccount3.account = account3;
        groupAccount3.joinDate = new Date();

        System.out.println("GroupAccount 1: " + groupAccount1.account.fullName);
        System.out.println("GroupAccount 2: " + groupAccount2.account.fullName);
        System.out.println("GroupAccount 3: " + groupAccount3.account.fullName);

        System.out.println("--------------------------------");

        //IF

        //Question 1
        System.out.println("Question 1:");
        if(account2.departmentId == null){
            System.out.println("Nhan vien nay chua co phong ban");
        }
        else{
            System.out.println("Phong ban cua nhan vien nay la " + account2.departmentId.departmentName);
        }
        System.out.println("==========");
        // Question 2
        System.out.println("Question 2:");
        int countGroup = 0;
        if(groupAccount1.account == account2) countGroup++;
        if(groupAccount2.account == account2) countGroup++;
        if(groupAccount3.account == account2) countGroup++;

        if (countGroup == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (countGroup <= 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (countGroup == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
        System.out.println("==========");
        //Question 3
        System.out.println("Question 3:");
        System.out.println(account2.departmentId == null
        ? "Nhân viên này chưa có phòng ban" :
        "Phòng ban của nhân viên này là "
        + account2.departmentId.departmentName);
        System.out.println("==========");

        //Question 4
        System.out.println("Question 4:");
        System.out.println(account1.positionId.positionName == PositionName.DEV
        ? "Đây là Developer"  : "Người này không phỉa là Developer");
        System.out.println("==========");
        // SWITCH CASE

        // Question 5
        System.out.println("Question 5:");
        int countAccount = 0;
        if(groupAccount1.group == group1) countAccount++;
        if(groupAccount2.group == group1) countAccount++;
        if(groupAccount3.group == group1) countAccount++;

        switch (countAccount){
            case '1':
                System.out.println("Nhóm có 1 thành viên");
                break;
            case '2':
                System.out.println("Nhóm có 2 thành viên");
                break;
            case '3':
                System.out.println("Nhóm có 3 thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
                break;
        }
        System.out.println("==========");
        // Question 6
        System.out.println("Question 6:");
        switch (countGroup){
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println( "Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                break;
        }
        System.out.println("==========");
        // Question 7
        System.out.println("Question 7:");
        switch (account1.positionId.positionName){
            case DEV:
                System.out.println("Đây là Developer");
                break;

            default:
                System.out.println("Người này không phải là Developer");
                break;
        }
        System.out.println("==========");
        // FOR EACH

        //Question 8
        System.out.println("Question 8:");
        Account[] accounts ={account1, account2, account3};
        System.out.println("Thông tin account:");
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", "ID", "Username", "Fullname", "Email", "Department Name", "Position Name");
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        for(Account account : accounts){
            System.out.printf("|%5d|%20s|%20s|%20s|%20s|%20s|\n", account.accountId, account.userName, account.fullName, account.email, account.departmentId.departmentName, account.positionId.positionName);
        }
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");

        // Question 9
        System.out.println("Question 9:");
        Department[] departments = {department1, department2, department3};
        System.out.println("Thông tin phòng ban:");
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Department Name");
        System.out.println("+-----+--------------------+");
        for(Department department : departments){
            System.out.printf("|%5d|%20s|\n", department.departmentId, department.departmentName);
        }
        System.out.println("+-----+--------------------+");

        // FOR

        // Question 10

        System.out.println("Question 10:");
        for(int i = 0; i<accounts.length; i++){
            Account account = accounts[i];
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname",  "Department Name");
            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName,  account.departmentId.departmentName);
            System.out.println("+--------------------+--------------------+--------------------+");
        }

        // Question 11
        System.out.println("Question 11:");
        for(int i = 0; i<departments.length; i++){
            Department department = departments[i];
            System.out.println("Thông tin phòng ban thứ " + (i + 1) + " là:");
            System.out.printf("|%5s|%20s|\n", "ID", "Name");
            System.out.printf("|%5s|%20s|\n", department.departmentId, department.departmentName);
            System.out.println("+-----+--------------------+");
        }

        // Question 12

        System.out.println("Question 12:");
        for(int i = 0; i<departments.length - 1; i++){
            Department department = departments[i];
            System.out.println("Thông tin phòng ban thứ " + (i + 1) + " là:");
            System.out.printf("|%5s|%20s|\n", "ID", "Name");
            System.out.printf("|%5s|%20s|\n", department.departmentId, department.departmentName);
            System.out.println("+-----+--------------------+");
        }

        // Question 13

        System.out.println("Question 13:");
        for(int i = 0; i<accounts.length; i++){
            Account account = accounts[i];
            if(accounts[i] == account2){
                continue;
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname",  "Department Name");
            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName,  account.departmentId.departmentName);
            System.out.println("+--------------------+--------------------+--------------------+");
        }

        //Question 14

        System.out.println("Question 14:");
        for(int i = 0; i<accounts.length; i++){
            Account account = accounts[i];
            if(accounts[i].accountId >= 4){
                break;
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname",  "Department Name");
            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName,  account.departmentId.departmentName);
            System.out.println("+--------------------+--------------------+--------------------+");
        }

        // Question 15
        System.out.println("Question 15:");
        for(int i = 0; i <= 20; i+=2){
            System.out.print(i + " ");
        }

//        // WHILE
//
//        // Question 16
//        // 16.1
//        System.out.println("\nQuestion 16.1:");
//        int i = 0;
//        while (i < accounts.length){
//            Account account = accounts[i];
//            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
//            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname",  "Department Name");
//            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName,  account.departmentId.departmentName);
//            System.out.println("+--------------------+--------------------+--------------------+");
//            i++;
//        }
//
//        //16.2
//        System.out.println("Question 16.2:");
//        int j = 0;
//        while (j < departments.length){
//            Department department = departments[j];
//            System.out.println("Thông tin phòng ban thứ " + (j + 1) + " là:");
//            System.out.printf("|%5s|%20s|\n", "ID", "Name");
//            System.out.printf("|%5s|%20s|\n", department.departmentId, department.departmentName);
//            System.out.println("+-----+--------------------+");
//            j++;
//        }
//
//        //16.3
//        System.out.println("Question 16.3:");
//        int g = 0;
//        while(g < departments.length - 1){
//            Department department = departments[g];
//            System.out.println("Thông tin phòng ban thứ " + (g + 1) + " là:");
//            System.out.printf("|%5s|%20s|\n", "ID", "Name");
//            System.out.printf("|%5s|%20s|\n", department.departmentId, department.departmentName);
//            System.out.println("+-----+--------------------+");
//            g++;
//        }
//
//        //16.4
//        System.out.println("Question 16.4:");
//        int h = 0;
//        while(h < accounts.length){
//            Account account = accounts[h];
//            if(accounts[h] == account2){
//                h++;
//                continue;
//            }
//            System.out.println("Thông tin account thứ " + (h + 1) + " là:");
//            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname",  "Department Name");
//            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName,  account.departmentId.departmentName);
//            System.out.println("+--------------------+--------------------+--------------------+");
//            h++;
//        }
//
//        //16.5
//        System.out.println("Question 16.5:");
//        int k = 0;
//        while(k < accounts.length){
//            Account account = accounts[k];
//            if(accounts[k].accountId >= 4){
//                break;
//            }
//            System.out.println("Thông tin account thứ " + (k + 1) + " là:");
//            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname",  "Department Name");
//            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName,  account.departmentId.departmentName);
//            System.out.println("+--------------------+--------------------+--------------------+");
//            k++;
//        }
//
//        //16.6
//        System.out.println("Question 16.6:");
//        int l = 0;
//        while(l <= 20){
//            System.out.print(l + " ");
//            l+=2;
//        }

        //DO WHILE
        // Question 17

        // 17.1
        System.out.println("\nQuestion 17.1:");

        int i = 0;

        do {
            Account account = accounts[i];
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname", "Department Name");
            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName, account.departmentId.departmentName);
            System.out.println(
                    "+--------------------+--------------------+--------------------+");
            i++;
        } while (i < accounts.length);

        // 17.2
        System.out.println("\nQuestion 17.2:");
        int j = 0;
        do {
            Department department = departments[j];
            System.out.println("Thông tin phòng ban thứ " + (j + 1) + " là:");
            System.out.printf("|%5s|%20s|\n", "ID", "Name");
            System.out.printf( "|%5s|%20s|\n", department.departmentId, department.departmentName);
            System.out.println("+-----+--------------------+");
            j++;
        } while (j < departments.length);

        // 17.3
        System.out.println("\nQuestion 17.3:");
        int g = 0;
        do {
            Department department = departments[g];
            System.out.println("Thông tin phòng ban thứ " + (g + 1) + " là:");
            System.out.printf( "|%5s|%20s|\n", "ID", "Name");
            System.out.printf("|%5s|%20s|\n", department.departmentId, department.departmentName);
            System.out.println("+-----+--------------------+");
            g++;
        } while (g < departments.length - 1);

        // 17.4
        System.out.println("\nQuestion 17.4:");
        int h = 0;
        do {
            Account account = accounts[h];
            if (accounts[h] == account2) {
                h++;
                continue;
            }
            System.out.println("Thông tin account thứ " + (h + 1) + " là:");
            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname", "Department Name");
            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName, account.departmentId.departmentName);
            System.out.println("+--------------------+--------------------+--------------------+");
            h++;
        } while (h < accounts.length);

        // 17.5
        System.out.println("\nQuestion 17.5:");
        int k = 0;
        do {
            Account account = accounts[k];
            if (accounts[k].accountId >= 4) {
                break;
            }
            System.out.println("Thông tin account thứ " + (k + 1) + " là:");
            System.out.printf("|%20s|%20s|%20s|\n", "Email", "Fullname", "Department Name");
            System.out.printf("|%20s|%20s|%20s|\n", account.email, account.fullName, account.departmentId.departmentName);
            System.out.println("+--------------------+--------------------+--------------------+");
            k++;
        } while (k < accounts.length);

        // 17.6
        System.out.println("\nQuestion 17.6:");
        int l = 0;
        do {
            System.out.print(l + " ");
            l+=2;
        } while (l <= 20);
        System.out.println();
        System.out.println("==========");

        //EXERCISE 2
        System.out.println("EX2");
        // QUESTION 1
        System.out.println("Question 1:");
        int number1 = 5;
        System.out.printf("Số nguyên: %d", number1);

        // QUESTION 2

        System.out.println("\nQuestion 2:");
        int number2 = 100000000;
        System.out.printf("Số nguyên: %,d", number2);

        // QUESTION 3

        System.out.println("\nQuestion 3:");
        double number3 = 5.567098;
        System.out.printf("Số thực: %.4f", number3);

        // QUESTION 4
        System.out.println("\nQuestion 4:");

        String fullName = "Nguyễn Văn A";

        System.out.printf(
                "Tên tôi là \"%s\" và tôi đang độc thân", fullName);

        // QUESTION 5
        System.out.println("\nQuestion 5:");

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss's'");
        System.out.printf("Thời gian hiện tại: %s",now.format(formatter));

        // QUESTION 6
        System.out.println("\nQuestion 6:");
        System.out.printf("|%5s|%25s|%25s|%20s|%n", "ID", "Email", "Full Name", "Department");
        System.out.println("+-----+-------------------------+-------------------------+--------------------+");
        for (Account account : accounts) {
            System.out.printf("|%5d|%25s|%25s|%20s|%n", account.accountId, account.email, account.fullName, account.departmentId.departmentName);
        }
        System.out.println("+-----+-------------------------+-------------------------+--------------------+");

        // EXERCISE 3
        System.out.println("EXERCISE 3");
        // Question 1

        System.out.println("\nQuestion 1:");
        SimpleDateFormat formatVietnamese = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Thông tin Exam thứ 1:");
        System.out.println("Exam ID: " + exam1.examId);
        System.out.println("Code: " + exam1.code);
        System.out.println("Title: " + exam1.title);
        System.out.println("Create Date: " + formatVietnamese.format(exam1.createDate));

        // Question 2
        System.out.println("\nQuestion 2:");
        SimpleDateFormat formatQuestion2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        System.out.println("Exam đã tạo ngày: " + formatQuestion2.format(exam1.createDate));

        // Question 3

        System.out.println("\nQuestion 3:");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        System.out.println("Năm tạo Exam: " + formatYear.format(exam1.createDate));

        // Question 4

        System.out.println("\nQuestion 4:");
        SimpleDateFormat formatMonthYear = new SimpleDateFormat("MM-yyyy");
        System.out.println("Tháng và năm tạo Exam: " + formatMonthYear.format(exam1.createDate));

        // Question 5
        System.out.println("\nQuestion 5:");
        SimpleDateFormat formatMonthDay = new SimpleDateFormat("MM-dd");
        System.out.println("MM-DD: " + formatMonthDay.format(exam1.createDate));

        // EXCECISE 4
        System.out.println("EXERCISE 4");
        Random random = new Random();

        // Question 1

        System.out.println("\nQuestion 1:");
        int number4 = random.nextInt();
        System.out.println("Số nguyên ngẫu nhiên: " + number4);

        // Question 2

        System.out.println("\nQuestion 2:");
        double number5 = random.nextDouble();
        System.out.println("Số thực ngẫu nhiên: " + number5);

        // Question 3

        System.out.println("\nQuestion 3:");
        String[] names = {
                "Nguyễn Văn A",
                "Nguyễn Văn B",
                "Nguyễn Văn C",
                "Nguyễn Văn D",
                "Nguyễn Văn E"};
        int randomIndex = random.nextInt(names.length);
        System.out.println("Tên bạn được chọn ngẫu nhiên: " + names[randomIndex]);

        // Question 4

        System.out.println("\nQuestion 4:");
        LocalDate startDate = LocalDate.of(1995, 7, 24);
        LocalDate endDate = LocalDate.of(1995, 12, 20);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        long randomDays = random.nextLong(daysBetween + 1);
        LocalDate randomDate = startDate.plusDays(randomDays);
        System.out.println("Ngày ngẫu nhiên: " + randomDate);

        // Question 5

        System.out.println("\nQuestion 5:");
        LocalDate today = LocalDate.now();
        LocalDate oneYearAgo = today.minusYears(1);
        long daysInOneYear = ChronoUnit.DAYS.between(oneYearAgo, today);
        long randomDaysInYear = random.nextLong(daysInOneYear + 1);
        LocalDate randomDateInYear = oneYearAgo.plusDays(randomDaysInYear);
        System.out.println("Ngày ngẫu nhiên trong 1 năm trở lại đây: " + randomDateInYear);

        // Question 6

        System.out.println("\nQuestion 6:");
        LocalDate randomPastDate = LocalDate.now().minusDays(random.nextLong(3650) + 1);
        System.out.println("Ngày ngẫu nhiên trong quá khứ: " + randomPastDate);

        // Question 7

        System.out.println("\nQuestion 7:");
        int randomThreeDigitNumber = random.nextInt(900) + 100;
        System.out.println("Số có 3 chữ số ngẫu nhiên: " + randomThreeDigitNumber);
        System.out.println("==================");
        // EXERCISE 5
        System.out.println("EXERCISE 5");
        Scanner scanner = new Scanner(System.in);
        // QUESTION 1

        System.out.println("Question 1:");
        System.out.print("Nhập số nguyên thứ 1: ");
        int number6 = scanner.nextInt();

        System.out.print("Nhập số nguyên thứ 2: ");
        int number7 = scanner.nextInt();

        System.out.print("Nhập số nguyên thứ 3: ");
        int number8 = scanner.nextInt();

        System.out.println("3 số bạn vừa nhập:");
        System.out.println(number6 + number7 + number8);
        // QUESTION 2
        // Nhập 2 số thực
        // =========================================================

        System.out.println("\nQuestion 2:");

        System.out.print("Nhập số thực thứ 1: ");
        double double1 = scanner.nextDouble();

        System.out.print("Nhập số thực thứ 2: ");
        double double2 = scanner.nextDouble();

        System.out.println("2 số thực bạn vừa nhập:");
        System.out.println(double1 + double2);
    }
}