package backend;
import entity.Position;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLPosition implements IQLPosition{
    private List<Position> positions = new ArrayList<>();
    @Override
    public void hienThiPosition() {
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
            String sql = "SELECT * FROM Position;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);// resultSet chứa dữ liệu khi chạy câu sql

            while (resultSet.next()) {
                int positionId =  resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                Position position = new Position(positionId, positionName);
                positions.add(position);
            }
        } catch (SQLException e) {
            System.out.println("Kết nối DB thất bại!");
        }
        System.out.println("+---------------+-------------------------+");
        System.out.printf("|%15s|%25s|\n", "Ma chuc vu", "Ten chuc vu");
        System.out.println("+---------------+-------------------------+");
        if (positions.size() > 0) {
            for (Position position : positions) {
                System.out.printf("|%15s|%25s|\n", position.getPositionId(), position.getPositionName());
            }
        } else {
            System.out.printf("|%77s|\n", "Khong co thong tin");
        }
        System.out.println("+---------------+-------------------------+");
    }

    // THÊM
    @Override
    public void themPosition(Position position) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "INSERT INTO Position " + "(position_name) " + "VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, position.getPositionName());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Them Position thanh cong!");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Them Position that bai!");
        }
    }

    // XÓA

    @Override
    public void xoaPosition(int positionId) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "DELETE FROM Position " + "WHERE position_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, positionId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Xoa Position thanh cong!");
            } else {
                System.out.println("Khong tim thay Position co ID = " + positionId);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Xoa Position that bai!");
        }
    }

    // SỬA

    @Override
    public void suaPositionName(int positionId, String positionNameMoi) {
        String url = "jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "UPDATE Position " + "SET position_name = ? " + "WHERE position_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, positionNameMoi);
            preparedStatement.setInt(2, positionId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Sua Position thanh cong!");
            } else {
                System.out.println("Khong tim thay Position co ID = " + positionId);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Sua Position that bai!");
        }
    }
    
    public static void main(String[] args) throws SQLException {
        QLPosition qlDepartment = new QLPosition();
        qlDepartment.hienThiPosition();
    }

}