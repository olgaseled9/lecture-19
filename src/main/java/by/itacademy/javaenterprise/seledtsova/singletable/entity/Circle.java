package by.itacademy.javaenterprise.seledtsova.singletable.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "C")
public class Circle extends Shape {

    @Column(name = "circle_radius")
    int radius;

    public Circle(String shapeName, int radius) {
        super(shapeName);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

