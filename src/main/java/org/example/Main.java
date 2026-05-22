package org.example;

import java.util.Random;

import static org.example.IO.*;

public class Main {
    private static SpitoKiosk spitoKiosk;
    static void main() {
        spitoKiosk = initializeKiosk();
        while(spitoKiosk.isSaleable){
            try{
                customerVisitProcess();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                //main();
            }
        }
        if(spitoKiosk.isSoldOut) {
            //재고가 인원수에 맞게 딱 떨어졌을 때
            System.out.println("재고가 모두 소진되어 판매를 종료합니다.");
        }else{
            //재고가 인원 수 보다 적을 때
            System.out.println("오신 손님 수보다 남아있는 재고의 수가 적어 판매를 종료합니다. 죄송합니다. ");
        }

        printQuit();
    }

    static SpitoKiosk initializeKiosk(){
        int dailyStockCount = new Random().nextInt(40)+1;
        printOpenStore();
        return new SpitoKiosk(dailyStockCount);
    }

    static void customerVisitProcess(){
        printIntro();
        String userChoice = getOption();
        if (!userChoice.equals(Constants.OPTION_QUIT)) {
            kioskProgress(userChoice);
        }
    }

    static void kioskProgress(String userChoice) {
        switch (userChoice) {
            case Constants.OPTION_SPITO:
                spitoKiosk.startKiosk();
                break;
            case Constants.OPTION_LOTTO:
                lotteryGame();
                break;
        }
    }


    static void lotteryGame() {
        IO.printBlockedOption();
//        InstantLottery instantLottery = new InstantLottery(userMoney);
//        instantLottery.draw();
//        instantLottery.scratch();
//        instantLottery.makeResultMsg();
    }
}