package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SpitoKioskProcess {
    private static HashMap<String, User> userList;
    private  static List<Thread> threadList;

    static void initializeProcess(SpitoKiosk spitoKiosk){
        userList= new HashMap<>();
        threadList = new ArrayList<>();

        //스피또를 플레이 할 총 인원 수. 랜덤 친구 수 + 나
        int totalCustCount = new Random().nextInt(Constants.FRIEND_MAX_COUNT) + 1;
            for(int i =0; i<totalCustCount; i++){
                String name = "손님"+ (i+1);
                userList.put(name, new User(name));
                threadList.add(new Thread(()->{
                    String curThreadName = Thread.currentThread().getName();
                    spitoKiosk.tryBuy(userList.get(curThreadName));
                }, name));
            }

    }

    static void startSpito(SpitoKiosk spitoKiosk){
        System.out.printf("stock : %d\n\n", spitoKiosk.getStock());
        System.out.println(userList.size());
        if(spitoKiosk.isSaleable){
            try {
                for (Thread thread : threadList){
                    thread.start();
                }
                for (Thread thread : threadList){
                    thread.join();
                }
                for(User user : userList.values()){
                    System.out.println(user.getResultMsgSB());
                    System.out.println("===================");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("오류 : 재고 부족1");
            spitoKiosk.setSaleableFalse();
        }
        spitoKiosk.checkStockSaleable();
    }
}
