import java.time.LocalDate;
import java.util.Date;

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
    }
}