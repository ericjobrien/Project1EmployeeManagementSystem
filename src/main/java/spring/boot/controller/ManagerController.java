package spring.boot.controller;

import org.springframework.web.bind.annotation.*;
import spring.boot.model.Employee;
import spring.boot.model.Manager;
import spring.boot.service.ManagerService;

import java.util.List;

@RestController
public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/manager")
    public List<Manager> findAll() {
        return managerService.findAll();
    }

    @GetMapping("/manager/{id}")
    public Manager findById(@PathVariable int id) {
        return managerService.findById(id);
    }

    @PostMapping("/manager")
    public Manager save(@RequestBody Manager manager) {
        return managerService.save(manager);
    }

    @DeleteMapping("/manager/delete/{id}")
    public void delete(@PathVariable int id) {
        managerService.delete(id);
    }

    @PutMapping("manager/update/{id}")
    public Manager update(@PathVariable int id, @RequestBody Manager manager) {
        Manager manager1 = managerService.findById(id);

        if(manager.getFirstName() != null) {
            manager1.setFirstName(manager.getFirstName());
        } else {
            manager1.setFirstName(manager1.getFirstName());
        }

        if(manager.getLastName() != null) {
            manager1.setLastName(manager.getLastName());
        } else {
            manager1.setLastName(manager1.getLastName());
        }

        if(manager.getEmployees() != null) {
            manager1.setEmployees(manager.getEmployees());
        } else {
            manager1.setEmployees(manager1.getEmployees());
        }
        managerService.save(manager1);

        return managerService.update(manager1);
    }
}
