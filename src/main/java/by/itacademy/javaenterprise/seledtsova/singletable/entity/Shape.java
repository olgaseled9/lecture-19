package by.itacademy.javaenterprise.seledtsova.singletable.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "shape")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
        (
                name = "discriminator",
                discriminatorType = DiscriminatorType.STRING
        )
@DiscriminatorValue(value = "S")
public class Shape {

    @Id
    @SequenceGenerator(name = "shape_id_seq", sequenceName = "shape_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shape_id_seq")
    @Column(name = "shape_id")
    Long shapeId;
    @Column(name = "shape_name")
    String shapeName;


    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }
}
