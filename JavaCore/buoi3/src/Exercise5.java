import java.util.Arrays;
import java.util.Comparator;

public class Exercise5 {

    // Question 1
    public static void question1() {

        Department department1 = new Department();

        department1.departmentId = 1;
        department1.departmentName = "Marketing";
        department1.address = "Ha Noi";

        System.out.println(department1.toString());
    }

    // Question 2
    public static void question2() {

        Department[] departments = getDepartments();

        for (Department department : departments) {

            System.out.println(department.toString());
        }
    }

    // Question 3
    public static void question3() {

        Department[] departments = getDepartments();

        System.out.println(
                "Địa chỉ: " + departments[0].address
        );
    }

    // Question 4
    public static void question4() {

        Department[] departments = getDepartments();

        if (departments[0].departmentName.equals("Phòng A")) {

            System.out.println("Có");

        } else {

            System.out.println("Không");
        }
    }

    // Question 5
    public static void question5() {

        Department[] departments = getDepartments();

        if (departments[0].equals(departments[1])) {

            System.out.println("Bằng nhau");

        } else {

            System.out.println("Không bằng nhau");
        }
    }

    // Question 6
    public static void question6() {

        Department[] departments = new Department[5];

        departments[0] = createDepartment("Marketing");
        departments[1] = createDepartment("Sale");
        departments[2] = createDepartment("IT");
        departments[3] = createDepartment("Accounting");
        departments[4] = createDepartment("Waiting room");

        Arrays.sort(
                departments,
                Comparator.comparing(
                        department -> department.departmentName
                )
        );

        for (Department department : departments) {
            System.out.println(department.departmentName);
        }
    }

    // Question 7
    public static void question7() {
        Department[] departments = new Department[5];

        departments[0] = createDepartment("Accounting");
        departments[1] = createDepartment("Boss of director");
        departments[2] = createDepartment("Marketing");
        departments[3] = createDepartment("waiting room");
        departments[4] = createDepartment("Sale");
        Arrays.sort(
                departments,
                Comparator.comparing(department -> department.departmentName, String.CASE_INSENSITIVE_ORDER)
        );

        for (Department department : departments) {
            System.out.println(department.departmentName);
        }
    }

    // Tạo Department
    public static Department createDepartment(String name) {
        Department department = new Department();
        department.departmentName = name;
        return department;
    }

    // Dữ liệu Department
    public static Department[] getDepartments() {

        Department department1 = new Department();
        department1.departmentId = 1;
        department1.departmentName = "Marketing";
        department1.address = "Ha Noi";

        Department department2 = new Department();
        department2.departmentId = 2;
        department2.departmentName = "Sale";
        department2.address = "Ho Chi Minh";

        Department department3 = new Department();
        department3.departmentId = 3;
        department3.departmentName = "IT";
        department3.address = "Da Nang";

        Department department4 = new Department();
        department4.departmentId = 4;
        department4.departmentName = "Accounting";
        department4.address = "Ha Noi";

        Department department5 = new Department();
        department5.departmentId = 5;
        department5.departmentName = "Waiting room";
        department5.address = "Ha Noi";

        return new Department[]{
                department1,
                department2,
                department3,
                department4,
                department5
        };
    }
}