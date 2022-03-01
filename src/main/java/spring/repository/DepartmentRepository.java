package spring.repository;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import spring.model.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class DepartmentRepository {

    List<Department> departmentList;

    public DepartmentRepository() {
        departmentList = new ArrayList<Department>();
    }

    public List<Department> getAllDepartments() {

        try{
            Session session = HibernateUtil.getSession();
            departmentList = session.createQuery("FROM Department", Department.class).getResultList();
            session.close();
            return departmentList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Department getDepartmentById(Integer id) {
        return departmentList.get(id - 1);
    }
}
