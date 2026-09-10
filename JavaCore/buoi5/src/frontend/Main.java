package frontend;
import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;
import java.util.Scanner;

public class Main {
    QLDepartment qlDepartment = new QLDepartment();
    QLPosition qlPosition = new QLPosition();
    QLAccount qlAccount = new QLAccount();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        while (true) {
            System.out.println("====================");
            System.out.println("1. Hien thi danh sach Department");
            System.out.println("2. Hien thi danh sach Position");
            System.out.println("3. Hien thi danh sach Account");
            System.out.println("4. Thoát");
            System.out.println("====================");
            System.out.print("Chọn chức năng: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    qlDepartment.hienThiDepartment();
                    break;
                case "2":
                    qlPosition.hienThiPosition();
                    break;
                case "3":
                    qlAccount.hienThiAccount();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Nhap lai");
            }
        }
    }
}