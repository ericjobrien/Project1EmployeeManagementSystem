package spring.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.boot.model.Department;
import spring.boot.model.Employee;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {


    List<Department> findAll();

    Department save(Department department);

    Department findById(int id);

    @Override
    void delete(Department department);

    @Query("FROM Department WHERE department_id = :department_id")
    Department update(@Param("department_id") Department department);

//    @Query("FROM ")
//    List<Employee> findAllDepartmentEmployees();
}
