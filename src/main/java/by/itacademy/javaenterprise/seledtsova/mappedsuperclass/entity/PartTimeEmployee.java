package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "part_time_employee")
public class PartTimeEmployee extends Employee {

    private int hourlyRate;
}