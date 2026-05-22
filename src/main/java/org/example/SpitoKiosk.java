package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.example.SpitoKioskProcess.*;

public class SpitoKiosk {
    private final Lock lock = new ReentrantLock();
    private int availableStock;

    public boolean isSaleable;
    public boolean isSoldOut = false;

    public SpitoKiosk(int dailyStockCount) {
        this.availableStock = dailyStockCount;
        this.isSaleable = true;
    }
    public void startKiosk(){
        if(this.isSaleable){
            initializeProcess(this);
            startSpito(this);
        }
    }

    public int getStock(){ return this.availableStock; }
    public void checkStockSaleable(){
        if(this.availableStock==0){
            this.isSaleable = false;
            this.isSoldOut = true;
        }
    }
    public void setSaleableFalse(){ this.isSaleable = false; }

    public void tryBuy(User user){
        lock.lock();
        try {
            Thread.sleep(100);
            if(this.availableStock == 0) {
                user.setSpitoListEmpty();
            }else{
                int userSpitoCount = new Random().nextInt(this.availableStock) + 1;
                this.availableStock -= userSpitoCount;
                user.setSpitoList(spitoGame(userSpitoCount));
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            user.makeResultMsg();
            lock.unlock();
        }
    }

    private List<Spito> spitoGame(int count) {
        List<Spito> spitoList = new ArrayList<>();
        for(int i =0; i< count; i++){
            Spito spito = new Spito();
            spito.scratch();
            spitoList.add(spito);
        }
        return spitoList;
    }
}
