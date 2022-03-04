package spring.boot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentId;

    @Column
    private String name;

    @OneToMany(targetEntity = Manager.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "departmentId")
    private List<Manager> managers;


}
