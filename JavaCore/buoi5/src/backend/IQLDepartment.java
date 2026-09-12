package backend;
import java.sql.SQLException;
import entity.Department;
public interface IQLDepartment {
    void hienThiDepartment() throws SQLException;

    void themDepartment(Department department);

    void xoaDepartment(int departmentId);

    void suaDepartmentName(int departmentId, String departmentName);
}
