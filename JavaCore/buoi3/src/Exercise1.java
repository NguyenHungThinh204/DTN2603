import java.util.Random;

public class Exercise1 {

    // Question 1
    public static void question1() {

        float salary1 = 5240.5f;
        float salary2 = 10970.055f;

        int salary1Int = (int) salary1;
        int salary2Int = (int) salary2;

        System.out.println("Salary 1: " + salary1Int);
        System.out.println("Salary 2: " + salary2Int);
    }

    // Question 2
    public static void question2() {

        Random random = new Random();

        int number = random.nextInt(100000);

        System.out.printf("%05d%n", number);
    }

    // Question 3
    public static void question3() {

        Random random = new Random();

        int number = random.nextInt(100000);

        System.out.printf("Số ban đầu: %05d%n", number);

        int result = number % 100;

        System.out.println("2 số cuối: " + result);
    }

    // Question 4
    public static int question4(int a, int b) {

        return a / b;
    }
}