package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "full_time_employee")
public class FullTimeEmployee extends Employee {
    private int salary;
}
