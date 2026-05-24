package org.example.Kiosk;

import org.example.Constants;
import org.example.User;

import java.util.*;

import static org.example.IO.*;

public class SpitoKioskProcess {
    private static HashMap<String, User> userList;
    private static List<Thread> threadList;

    static void initializeProcess(SpitoKiosk spitoKiosk){
        userList= new HashMap<>();
        threadList = new ArrayList<>();

        int totalCustCount = new Random().nextInt(Constants.FRIEND_MAX_COUNT) + 1;
        List<String> nameList = pickRandomName(totalCustCount);
        //스피또를 플레이 할 총 인원 수. 랜덤 친구 수 + 나
        for(int i =0; i<totalCustCount; i++){
            String name = nameList.get(i);
            userList.put(name, new User(name));
            threadList.add(new Thread(()->{
                String curThreadName = Thread.currentThread().getName();
                spitoKiosk.tryBuy(userList.get(curThreadName));
                }, name));
        }

        try{
            printMsg("Kiosk가 준비 중입니다 ...\n");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            printErrorMsg(e.getMessage());
        }
    }

    static void startSpito(SpitoKiosk spitoKiosk){
        printAvailableStock(spitoKiosk.getAvailableStock());
        printCountOfPeople(userList.size());

        if(spitoKiosk.isSaleable){
            try {
                for (Thread thread : threadList){
                    thread.start();
                }
                for (Thread thread : threadList){
                    thread.join();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            spitoKiosk.setSaleableFalse();
        }
        spitoKiosk.checkStockSaleable();
        printAvailableStock(spitoKiosk.getAvailableStock());
    }

    static private List<String> pickRandomName(int nameCount){
        List<String> nameArray = Arrays.asList(Constants.NAME_LIST);
        Collections.shuffle(nameArray);
        return nameArray.subList(0,nameCount);
    }
}
