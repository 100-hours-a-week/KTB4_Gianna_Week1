package org.example;

import static org.example.IO.*;

public class Main {
    static void main() {
        try{
            String userChoice = printIntro();
            if (userChoice.equals("3")) {
                printQuit();
            } else {
                progress(userChoice);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            main();
        }

    }

    static void progress(String userChoice) {

        switch (userChoice) {
            case "1":
                spitoGame(Integer.parseInt(getMoney()));
                break;
            case "2":
                lotteryGame();
                break;
            default:
                printQuit();
        }
    }

    static void spitoGame(int userMoney) {
        Spito spito = new Spito();
        //spito.scratch();
    }

    static void lotteryGame() {
        IO.printBlockedOption();
        main();
//        InstantLottery instantLottery = new InstantLottery(userMoney);
//        instantLottery.draw();
//        instantLottery.scratch();
//        instantLottery.makeResultMsg();
    }
}