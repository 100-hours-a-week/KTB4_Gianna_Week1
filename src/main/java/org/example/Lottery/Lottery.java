package org.example.Lottery;

public class Lottery {
    protected int prize;
    protected int availableStock = 0;
    protected void setAvailableStock(int amount){
        this.availableStock = amount;
    }
    protected void setPrize(int prize){
        this.prize = prize;
    }
    protected int getPrize(){
        return this.prize;
    }
}
