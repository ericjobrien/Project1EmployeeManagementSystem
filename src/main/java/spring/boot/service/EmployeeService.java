package spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.boot.model.Employee;
import spring.boot.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    public void delete(int id) {
        Employee employee = employeeRepository.findById(id);
        employeeRepository.delete(employee);
    }

    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }


    public Employee update(Employee employee) {

        return employeeRepository.update(employee);
    }
}
