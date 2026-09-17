package backend.service.implement;

import backend.repository.IDepartmentRepository;
import backend.repository.implement.DepartmentRepositoryImplement;
import backend.service.IDepartmentService;
import entity.Department;

import java.util.List;

public class DepartmentServiceImplement implements IDepartmentService {
    IDepartmentRepository departmentRepository;
    public DepartmentServiceImplement() {
        departmentRepository = new DepartmentRepositoryImplement();
    }
    @Override
    public boolean kiemTraTonTaiDepartmentId(Integer departmentId) {
        return departmentRepository.kiemTraTonTaiDepartmentId(departmentId);
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return departmentRepository.getDepartmentById(departmentId);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.getDepartments();
    }
}
