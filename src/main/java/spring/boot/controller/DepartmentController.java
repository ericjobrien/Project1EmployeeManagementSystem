package spring.boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public List<Department> findAll() {
        return departmentService.findAll();
        }
}