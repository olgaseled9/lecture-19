package by.itacademy.javaenterprise.seledtsova.joinedtable.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cheque")
@PrimaryKeyJoinColumn(name = "cheque_number")
public class Cheque extends Payment {

    private int chequeNumber;
    @Column(name = "cheque_type")
    private String chequeType;

    @Override
    public String toString() {
        return "Cheque{" +
                "chequeNumber=" + chequeNumber +
                ", chequeType='" + chequeType + '\'' +
                '}';
    }
}
