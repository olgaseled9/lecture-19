package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "part_time_employee")
public class PartTimeEmployee extends Employee {

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;
}
