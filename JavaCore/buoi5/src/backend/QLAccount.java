package backend;
import entity.Account;
import entity.Department;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QLAccount implements IQLAccount{
    private List<Account> accounts = new ArrayList<>();

    public QLAccount() {
    }

    @Override
    public void hienThiAccount() {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try{
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            if (connection != null) {
                System.out.println("Kết nối DB thành công");
            } else {
                System.out.println("Kết nối DB không thành công");
            }
            String sql = "SELECT * FROM `Account`;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);// resultSet chứa dữ liệu khi chạy câu sql

            while (resultSet.next()) {
                int accountId =  resultSet.getInt("account_id");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                String fullName = resultSet.getString("fullname");
                LocalDate createDate = resultSet.getObject("create_date", LocalDate.class);
                int departmentId =  resultSet.getInt("department_id");
                int positionId =  resultSet.getInt("position_id");

                Account account = new Account(accountId, email, userName, fullName, departmentId, positionId, createDate);
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.out.println("Kết nối DB thất bại!");
        }

        System.out.println("+---------------+-------------------------+---------------+-------------------------+---------------+---------------+---------------+");
        System.out.printf("|%15s|%25s|%15s|%25s|%15s|%15s|%15s|\n", "Ma dinh danh", "Email", "Ten", "Ten day du", "Ma phong ban", "Ma chuc vu", "Ngay tao");
        System.out.println("+---------------+-------------------------+---------------+-------------------------+---------------+---------------+---------------+");
        if (accounts.size() > 0) {
            for (Account account: accounts) {
                System.out.printf("|%15s|%25s|%15s|%25s|%15s|%15s|%15s|\n", account.getAccountId(), account.getEmail(), account.getUsername(), account.getFullName(), account.getDepartmentId(), account.getPositionId(), account.getCreateDate());
            }
        } else {
            System.out.printf("|%77s|\n", "Khong co thong tin");
        }
        System.out.println("+---------------+-------------------------+---------------+-------------------------+---------------+---------------+---------------+");
    }

    //Them
    @Override
    public void themAccount(Account account) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "INSERT INTO `Account` " + "(email, username, fullname, department_id, position_id, create_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getFullName());
            preparedStatement.setInt(4, account.getDepartmentId());
            preparedStatement.setInt(5, account.getPositionId());
            preparedStatement.setDate(6, Date.valueOf(account.getCreateDate()));
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Them Account thanh cong!");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Them Account that bai!");
        }
    }

    // XÓA

    @Override
    public void xoaAccount(int accountId) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "DELETE FROM `Account` WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Xoa Account thanh cong!");
            } else {
                System.out.println("Khong tim thay Account co ID = " + accountId);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Xoa Account that bai!");
        }
    }

    // SỬA

    @Override
    public void suaUsername(int accountId, String usernameMoi) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "UPDATE `Account` " + "SET username = ? " + "WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usernameMoi);
            preparedStatement.setInt(2, accountId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Sua username thanh cong!");
            } else {
                System.out.println("Khong tim thay Account co ID = " + accountId);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Sua username that bai!");
        }
    }
    public static void main(String[] args) throws SQLException {
        QLAccount qlAccount = new QLAccount();
        qlAccount.hienThiAccount();
    }
}
