package spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.boot.repository.DepartmentRepository;
import spring.boot.model.Department;

import java.util.List;

@Component
public class DepartmentService {

    DepartmentRepository departmentRepository;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }


    public Department findById(int id) {
        return departmentRepository.findById(id);
    }

    public void delete(int id) {
        List<Department> departments = departmentRepository.findAll();
        Department department = departments.get(id - 1);
        departmentRepository.delete(department);
    }
}
