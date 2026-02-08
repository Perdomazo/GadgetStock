package com.perdomazo.firstproject.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

import java.math.BigDecimal;

// gente no me lo puedo creer es mi primer objeto relacionado a un proyecto 100% personal

// entity which is going to save
// ser la tabla para la base de datos
@Entity
@Table( name = "Gadgets")
public class GadgetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private String name;
    private String model;
    private BigDecimal price; // more accurate with decimals
    private String comments;
    private Boolean repair;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime registerDate;
    private LocalDateTime soldDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRepair() {return repair;}

    public void setRepair(Boolean repair) {this.repair = repair;}

    public GadgetModel(){

    }
    public GadgetModel(String name, String model, BigDecimal price, String comments, Boolean repair){
        this.name = name;
        this.model = model;
        this.price = price;
        this.comments = comments;
        this.repair = repair;
    }
}
