package com.ballistic.haleemghr.model;

/**
 * Created by Lycus 01 on 6/13/2017.
 */
public class Order {

    public Long id;
    public String name;
    public Long qty;
    public Double rate;
    public Double amount;

    // used the constructor


    public Order(Long id, String name, Long qty, Double rate, Double amount) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.rate = rate;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", rate=" + rate +
                ", amount=" + amount +
                '}';
    }
}
