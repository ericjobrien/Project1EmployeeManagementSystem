package spring.boot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Department")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Department {


    @Id
    private int departmentId;

    @Column(name = "name")
    private String name;
}
