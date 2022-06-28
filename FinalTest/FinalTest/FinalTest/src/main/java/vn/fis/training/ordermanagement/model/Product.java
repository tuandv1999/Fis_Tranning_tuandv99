package vn.fis.training.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tbl_product")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Double price;

    @Column(name="avaiable")
    private Long avaiable;

}
