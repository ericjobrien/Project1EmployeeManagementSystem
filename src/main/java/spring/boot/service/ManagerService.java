package spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
}
