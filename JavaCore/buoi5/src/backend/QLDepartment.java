package backend;
import entity.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment implements IQLDepartment {
    private List<Department> departments = new ArrayList<>();
    public QLDepartment() {
    }
    @Override
    public void hienThiDepartment(){
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbdbUsername = "root";
        String dbdbPassword = "root";
        try{
            Connection connection = DriverManager.getConnection(url, dbdbUsername, dbdbPassword);
            if (connection != null) {
                System.out.println("Ket noi DB thanh cong");
            } else {
                System.out.println("Ket noi DB khong thanh cong");
            }
            String sql = "SELECT * FROM Department;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);// resultSet chứa dữ liệu khi chạy câu sql
            while (resultSet.next()) {
                int departmentId =  resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");
                Department department = new Department(departmentId, departmentName);
                departments.add(department);
            }
        } catch (SQLException e) {
            System.out.println("Ket noi DB that bai!");
        }
        System.out.println("+---------------+-------------------------+");
        System.out.printf("|%15s|%25s|\n", "Ma phong ban", "Ten phong ban");
        System.out.println("+---------------+-------------------------+");
        if (departments.size() > 0) {
            for (Department department : departments) {
                System.out.printf("|%15s|%25s|\n", department.getDepartmentId(), department.getDepartmentName());
            }
        } else {
            System.out.printf("|%77s|\n", "Khong co thong tin");
        }
        System.out.println("+---------------+-------------------------+");
    }

    // THÊM
    @Override
    public void themDepartment(Department department) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "INSERT INTO Department " + "(department_name) " + "VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartmentName());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Them Department thanh cong!");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(
                    "Them Department that bai!"
            );
        }
    }

    // XÓA
    @Override
    public void xoaDepartment(int departmentId) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "DELETE FROM Department " + "WHERE department_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, departmentId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Xoa Department thanh cong!");
            } else {
                System.out.println("Khong tim thay Department co ID = " + departmentId);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Xoa Department that bai!");
        }
    }

    // SỬA
    @Override
    public void suaDepartmentName(int departmentId, String departmentNameMoi) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "UPDATE Department " + "SET department_name = ? " + "WHERE department_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, departmentNameMoi);
            preparedStatement.setInt(2, departmentId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Sua Department thanh cong!");
            } else {
                System.out.println("Khong tim thay Department co ID = " + departmentId);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Sua Department that bai!");
        }
    }


    public static void main(String[] args) throws SQLException {
        QLDepartment qlDepartment = new QLDepartment();
        qlDepartment.hienThiDepartment();
    }

}
