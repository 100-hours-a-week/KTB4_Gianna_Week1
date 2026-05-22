package org.example;

public class Lottery {
    protected int availableStock = 0;
    protected int price = 0;

    protected void setAvailableStock(int amount){
        this.availableStock = amount;
    }
    protected void setPrice(int price){this.price = price; }
}
