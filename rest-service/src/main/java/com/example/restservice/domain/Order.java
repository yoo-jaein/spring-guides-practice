package com.example.restservice.domain;

import com.example.restservice.enumeration.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@Table(name = "CUSTOMER_ORDER")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String desc;
    private Status status;

    public Order(String desc, Status status) {
        this.desc = desc;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Order)) {
            return false;
        }

        Order order = (Order) o;
        return Objects.equals(this.id, order.id)
                && Objects.equals(this.desc, order.desc)
                && this.status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.desc, this.status);
    }
}
