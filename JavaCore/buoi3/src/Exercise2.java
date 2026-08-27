import java.util.Date;

public class Exercise2 {
    // Question 1
    public static void question1() {
        Account[] accounts = new Account[5];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            accounts[i].email = "Email " + (i + 1);
            accounts[i].userName = "User name " + (i + 1);
            accounts[i].fullName = "Full name " + (i + 1);
            accounts[i].createDate = new Date();
        }

        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Username: " + accounts[i].userName);
            System.out.println("FullName: " + accounts[i].fullName);
            System.out.println("CreateDate: " + accounts[i].createDate);
        }
    }
}