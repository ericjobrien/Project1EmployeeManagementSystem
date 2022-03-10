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

    @PostMapping("/employee")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("employee/delete/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @PutMapping("employee/update/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee employee) {
        Employee employee1 = employeeService.findById(id);

        if(employee.getFirstName() != null) {
            employee1.setFirstName(employee.getFirstName());
        } else {
            employee1.setFirstName(employee1.getFirstName());
        }

        if(employee.getLastName() != null) {
            employee1.setLastName(employee.getLastName());
        } else {
            employee1.setLastName(employee1.getLastName());
        }
        employeeService.save(employee1);
        return employeeService.update(employee1);

    }
}
