package org.example.Kiosk;

import org.example.Constants;
import org.example.Lottery.Spito;
import org.example.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.example.IO.printErrorMsg;
import static org.example.Kiosk.SpitoKioskProcess.*;

public class SpitoKiosk extends Kiosk{
    private final Lock lock = new ReentrantLock();

    public SpitoKiosk(int dailyStockCount) {
        super(dailyStockCount);
    }

    public void startKiosk(){
        if(this.isSaleable){
            //SpitoKioskProcess에서 진행
            initializeProcess(this);
            startSpito(this);
        }
    }

    public void tryBuy(User user){
        lock.lock();
        try {
            Thread.sleep(100);
            if(this.availableStock == Constants.EMPTY_COUNT) {
                user.setSpitoListEmpty();
            }else{
                int userSpitoCount = new Random().nextInt(this.availableStock) + 1;
                this.availableStock -= userSpitoCount;
                user.setSpitoList(makeSpitoList(userSpitoCount));
            }
        } catch (InterruptedException e) {
            printErrorMsg(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            user.makeResultMsg();
            user.printResultMsg();
            lock.unlock();
        }
    }

    private List<Spito> makeSpitoList(int count) {
        List<Spito> spitoList = new ArrayList<>();
        for(int i =0; i< count; i++){
            Spito spito = new Spito();
            spito.scratch();
            spitoList.add(spito);
        }
        return spitoList;
    }
}
