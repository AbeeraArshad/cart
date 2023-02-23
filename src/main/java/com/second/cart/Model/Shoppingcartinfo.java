package com.second.cart.Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Indexed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="addtocart")

public class Shoppingcartinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable =false)
    private String name;
    
    @Lob
    @Column(columnDefinition ="TEXT",nullable = false)
    private String image_Link;

    @Column(nullable = false)
    private Integer quantity;


    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long totalPrice;

    public Shoppingcartinfo(Long id, String name, String image_Link, Integer quantity, Long price,Long totalprice){
        this.id = id;
        this.name=name;
        this.image_Link= image_Link;
        this.quantity= quantity;
        this.price=price;
        this.totalPrice=totalprice;
    }
}
