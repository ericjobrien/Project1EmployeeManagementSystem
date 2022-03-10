package spring.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.boot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(int id);

    void delete(Employee employee);

    @Query("FROM Employee WHERE employee_id = :employee_id")
    Employee update(@Param("employee_id") Employee employee);

}
