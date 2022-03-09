package spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.boot.model.Manager;
import spring.boot.service.ManagerService;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    List<Manager> findAll();

    Manager save(Manager manager);

    Manager findById(int id);

    @Override
    void delete(Manager manager);
}
