package spring.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.model.Department;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {


    List<Department> findAll();

    Department save(Department department);

    Department findById(int id);

    @Override
    void deleteById(Integer integer);
}
