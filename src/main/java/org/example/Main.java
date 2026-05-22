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
        int userMoney = Integer.parseInt(getMoney());

        switch (userChoice) {
            case "1":
                spitoGame(userMoney);
                break;
            case "2":
                lotteryGame(userMoney);
                break;
            default:
                printQuit();
        }
    }

    static void spitoGame(int userMoney) {
        Spito spito = new Spito(userMoney);
        spito.make();
        spito.match();
        spito.makeResultMsg();
    }

    static void lotteryGame(int userMoney) {
        Lottery lottery = new Lottery(userMoney);
        lottery.draw();
        lottery.match();
        lottery.makeResultMsg();
    }
}