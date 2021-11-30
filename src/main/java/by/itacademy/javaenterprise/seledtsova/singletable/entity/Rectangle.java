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
@DiscriminatorValue(value = "R")
public class Rectangle extends Shape {

    @Column(name = "rectangle_length")
    int length;
    @Column(name = "rectangle_breadth")
    int breadth;

    public Rectangle(String shapeName, int length, int breadth) {
        super(shapeName);
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", breadth=" + breadth +
                '}';
    }
}
