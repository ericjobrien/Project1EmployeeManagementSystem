package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.model.Department;
import spring.repository.DepartmentRepository;


import java.util.List;

@Component
@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        System.out.println("Making a new departmentRepo");
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    public Department getDepartment(Integer id) {
        return departmentRepository.getAllDepartments().get(id - 1);
    }
}
