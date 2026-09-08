import java.util.Scanner;

public class Exercise4 {
    // Question 1
    public static void question1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        str = str.trim();
        if (str.isEmpty()) {
            System.out.println("Số từ: 0");
            return;
        }
        String[] words = str.split("\\s+");
        System.out.println("Số từ: " + words.length);
    }

    // Question 2
    public static void question2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Nhập s2: ");
        String s2 = scanner.nextLine();
        StringBuilder s = new StringBuilder().append(s1).append(s2);
        System.out.println("Kết quả: " + s);
    }

    // Question 3
    public static void question3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        name = name.trim();
        if (!name.isEmpty()) {
            name = name.substring(0, 1).toUpperCase()
                    + name.substring(1).toLowerCase();
        }

        System.out.println("Tên sau khi viết hoa: " + name);
    }

    // Question 4
    public static void question4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        for (int i = 0; i < name.length(); i++) {
            System.out.println(
                    "Ký tự thứ " + (i + 1)
                            + " là: "
                            + name.charAt(i)
            );
        }
    }

    // Question 5
    public static void question5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ: ");
        String ho = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.println("Họ và tên: " + ho + " " + ten);
    }

    // Question 6
    public static void question6() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        String fullName = scanner.nextLine();
        fullName = fullName.trim();
        String[] words = fullName.split("\\s+");
        if (words.length >= 3) {
            System.out.println("Họ là: " + words[0]);
            String middleName = "";
            for (int i = 1; i < words.length - 1; i++) {
                middleName += words[i];
                if (i < words.length - 2) {
                    middleName += " ";
                }
            }

            System.out.println("Tên đệm là: " + middleName);
            System.out.println("Tên là: " + words[words.length - 1]);
        } else if (words.length == 2) {
            System.out.println("Họ là: " + words[0]);
            System.out.println("Tên đệm là: ");
            System.out.println("Tên là: " + words[1]);
        } else {
            System.out.println("Tên không hợp lệ");
        }
    }

    // Question 7
    public static void question7() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        String fullName = scanner.nextLine();
        fullName = fullName.trim();
        fullName = fullName.replaceAll("\\s+", " ");
        String[] words = fullName.split(" ");
        String result = "";
        for (String word : words) {
            String newWord = word.substring(0, 1).toUpperCase()
                            + word.substring(1).toLowerCase();
            result += newWord + " ";
        }
        System.out.println(
                "Tên sau khi chuẩn hóa: "
                        + result.trim()
        );
    }

    // Question 8
    public static void question8() {
        Group[] groups = getGroups();
        for (Group group : groups) {
            if (group.groupName.contains("Java")) {
                System.out.println(group.groupName);
            }
        }
    }

    // Question 9
    public static void question9() {
        Group[] groups = getGroups();
        for (Group group : groups) {
            if (group.groupName.equals("Java")) {
                System.out.println(group.groupName);
            }
        }
    }

    // Question 10
    public static void question10() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi 1: ");
        String s1 = scanner.nextLine();
        System.out.print("Nhập chuỗi 2: ");
        String s2 = scanner.nextLine();
        String reverse = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            reverse += s1.charAt(i);
        }
        if (reverse.equals(s2)) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
        }
    }

    // Question 11
    public static void question11() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện a: " + count);
    }

    // Question 12
    public static void question12() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println("Chuỗi đảo ngược: " + reverse);
    }

    // Question 13
    public static void question13() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        boolean result = true;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
    // Question 14
    public static void question14() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        System.out.print("Nhập ký tự cần thay: ");
        char oldChar = scanner.nextLine().charAt(0);
        System.out.print("Nhập ký tự mới: ");
        char newChar = scanner.nextLine().charAt(0);
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == oldChar) {
                result += newChar;
            } else {
                result += str.charAt(i);
            }
        }
        System.out.println("Kết quả: " + result);
    }

    // Question 15
    public static void question15() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        str = str.trim();
        String[] words = str.split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i != 0) {
                result += " ";
            }
        }
        System.out.println("Kết quả: " + result);
    }

    // Question 16
    public static void question16() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        System.out.print("Nhập n: ");
        int n = scanner.nextInt();
        if (n <= 0 || str.length() % n != 0) {
            System.out.println("KO");
            return;
        }
        for (int i = 0; i < str.length(); i += n) {
            System.out.println(
                    str.substring(i, i + n)
            );
        }
    }

    public static Group[] getGroups() {

        Group group1 = new Group();
        group1.groupId = 1;
        group1.groupName = "Java";

        Group group2 = new Group();
        group2.groupId = 2;
        group2.groupName = "Java Backend";

        Group group3 = new Group();
        group3.groupId = 3;
        group3.groupName = "SQL";

        Group group4 = new Group();
        group4.groupId = 4;
        group4.groupName = "Java Spring";

        Group group5 = new Group();
        group5.groupId = 5;
        group5.groupName = "Testing";

        return new Group[]{
                group1,
                group2,
                group3,
                group4,
                group5
        };
    }
}