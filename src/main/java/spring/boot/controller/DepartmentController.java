package spring.boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.model.Manager;
import spring.boot.service.DepartmentService;
import spring.boot.model.Department;

import java.util.List;

@RestController
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<Department> findAll() {
        return departmentService.findAll();
        }

    @GetMapping("/department/{id}")
    public Department findById(@PathVariable int id) {
        return departmentService.findById(id);
    }

    @PostMapping("/department")
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("/department/delete/{id}")
    public void delete(@PathVariable int id) {
        departmentService.delete(id);
    }

    @PutMapping("/department/update/{id}")
    public Department update(@PathVariable int id, @RequestBody Department department) {
        Department department1 = departmentService.findById(id);

        if(department.getName() != null) {
            department1.setName(department.getName());
        } else {
            department1.setName(department1.getName());
        }

        List<Manager> managers = department.getManagers();
        int nullCounter = 0;
        if(managers != null) {
            System.out.println("Working check for !null managers");
            for (int i = 0; i < managers.size(); i++) {
                if (managers.get(i).getEmployees() == null) {
                    System.out.println("Increasing null counter");
                    nullCounter++;
                }
            }
            if (nullCounter > 0) {
                department1.setManagers(department1.getManagers());
            } else {
                department1.setManagers(department.getManagers());
            }
        } else {
            department1.setManagers(department1.getManagers());
        }

        departmentService.save(department1);
        return departmentService.update(department1);
    }

    @PutMapping("/department/update/addManager/{id}")
    public Department addManagerToDepartment(@PathVariable int id, @RequestBody Manager manager) {
        return departmentService.addManagerToDepartment(id, manager);
    }


}