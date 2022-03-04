package spring.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();

}
