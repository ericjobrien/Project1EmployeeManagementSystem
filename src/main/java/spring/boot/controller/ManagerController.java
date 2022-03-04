package spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/manager")
    public Manager save(@RequestBody Manager manager) {
        return managerService.save(manager);
    }
}
