package spring.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import spring.boot.model.Department;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {


    List<Department> findAll();
}
