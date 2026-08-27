public class Exercise3 {
    // Question 1
    public static void question1() {
        Integer salary = 5000;
        float salaryFloat = salary.floatValue();
        System.out.printf("Lương: %.2f%n", salaryFloat);
    }

    // Question 2
    public static void question2() {
        String numberString = "1234567";
        int number = Integer.parseInt(numberString);
        System.out.println("Number: " + number);
    }

    // Question 3
    public static void question3() {
        Integer integerNumber = Integer.valueOf("1234567");
        int number = integerNumber;
        System.out.println("Integer: " + integerNumber);
        System.out.println("int: " + number);
    }
}