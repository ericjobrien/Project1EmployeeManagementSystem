package spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.boot.model.Manager;
import spring.boot.repository.DepartmentRepository;
import spring.boot.model.Department;
import spring.boot.repository.ManagerRepository;

import java.util.List;

@Component
public class DepartmentService {

    DepartmentRepository departmentRepository;
    ManagerService managerService;

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
        Department department = departmentRepository.findById(id);
        departmentRepository.delete(department);
    }

    public Department update(Department department) {
        return departmentRepository.update(department);
    }

    public Department addManagerToDepartment(int id, Manager manager) {
        Department department = departmentRepository.findById(id);

        List<Manager> managers = department.getManagers();

        managers.add(manager);

        department.setManagers(managers);

        return departmentRepository.save(department);
    }


}
