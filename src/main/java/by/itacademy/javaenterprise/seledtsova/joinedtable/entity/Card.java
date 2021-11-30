package by.itacademy.javaenterprise.seledtsova.joinedtable.entity;

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
@Entity
@Table(name = "card")
@PrimaryKeyJoinColumn(name = "card_number")
public class Card extends Payment {

    private int cardNumber;
    @Column(name = "card_type")
    private String cardType;

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
