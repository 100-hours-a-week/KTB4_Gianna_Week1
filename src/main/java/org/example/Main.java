package org.example;

import static org.example.IO.*;

public class Main {
    static void main() {
        try{
            String userChoice = printIntro();
            if (userChoice.equals(Constants.OPTION_QUIT)) {
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
            case Constants.OPTION_SPITO:
                spitoGame(Integer.parseInt(getMoney()));
                break;
            case Constants.OPTION_LOTTO:
                lotteryGame();
                break;
            default:
                printQuit();
        }
    }

    static void spitoGame(int userMoney) {
        Spito spito = new Spito();
        spito.scratch();
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