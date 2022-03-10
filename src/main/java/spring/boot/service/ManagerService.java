package spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.boot.model.Department;
import spring.boot.model.Manager;
import spring.boot.repository.ManagerRepository;

import java.util.List;

@Component
public class ManagerService {

    private ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager findById(int id) {
        return managerRepository.findById(id);
    }

    public void delete(int id) {
        Manager manager = managerRepository.findById(id);
        managerRepository.delete(manager);
    }

    public Manager update(Manager manager) {
        return managerRepository.update(manager);
    }

    public Manager addManagerToDepartmentById(int id, int department_id) {

        Manager manager = managerRepository.findById(id);
        return managerRepository.addManagerToDepartmentById(manager);
    }
}
