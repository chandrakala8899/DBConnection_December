package com.neoteric.dec_dbconnection.jpainheritance;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // different tables
//@DiscriminatorColumn(name = "stock_type", discriminatorType = DiscriminatorType.STRING) // all stocks in  single table
@Table(name = "Stock",schema = "sonar")
public abstract class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    private int duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
