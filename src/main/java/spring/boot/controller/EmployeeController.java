package spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.model.Employee;
import spring.boot.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping("/employee/manager/{id}")
    public List<Employee> findAllByManagerId(@PathVariable int id) {
        return employeeService.findAllByManagerId(id);
    }

    @PostMapping("/employee")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("employee/delete/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}
