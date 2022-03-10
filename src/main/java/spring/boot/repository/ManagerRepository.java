package spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.boot.model.Manager;
import spring.boot.service.ManagerService;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    List<Manager> findAll();

    Manager save(Manager manager);

    Manager findById(int id);

    @Override
    void delete(Manager manager);

    @Query("FROM Manager WHERE manager_id = :manager_id")
    Manager update(@Param("manager_id")Manager manager);

    @Query("FROM Manager WHERE department_id = :department_id")
    Manager addManagerToDepartmentById(@Param("department_id") Manager manager);
}
