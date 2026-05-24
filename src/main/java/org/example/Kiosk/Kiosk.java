package org.example.Kiosk;

public class Kiosk {
    protected int availableStock;
    public boolean isSaleable;
    public boolean isSoldOut = false;

    Kiosk(int dailyStockCount){
        this.availableStock = dailyStockCount;
        this.isSaleable = true;
    }

    public void setSaleableFalse(){ this.isSaleable = false; }
    public void checkStockSaleable(){
        if(this.availableStock==0){
            this.isSaleable = false;
            this.isSoldOut = true;
        }
    }

    public int getAvailableStock(){
        return this.availableStock;
    }
}
