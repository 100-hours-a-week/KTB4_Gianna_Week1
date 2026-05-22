package org.example;

import java.util.ArrayList;
import java.util.List;

public class Spito extends InstantLottery {
    private boolean isWin;
    protected List<Integer> gameList = new ArrayList<>();
    private int winningNumber;

    public Spito() {
        super.setPrize(Constants.SPITO_PRIZE);
        this.draw();
    }

    @Override
    protected void draw() {
        this.gameList = this.numberGenerator.draw(Constants.SPITO_MAX_NUMBER, Constants.LOTTERY_COUNT);
        this.winningNumber = this.numberGenerator.draw(Constants.SPITO_MAX_NUMBER, Constants.SPITO_WINNINGNUM_COUNT).getFirst();
    }

    @Override
    protected void scratch(){
        this.isWin = this.numberMatcher.SpitoMatcher(gameList, winningNumber);
    }

    public StringBuilder getResultMsg(){
        StringBuilder sb = new StringBuilder(String.valueOf(gameList));
        String winningNumberMsg = " - 당첨 번호 : " + winningNumber;
        sb.append(winningNumberMsg);
        if(isWin){
            sb.append(" ( 당첨 )");
        }

        sb.append("\n");
        return sb;
    }

    public int getPrize(){
        return isWin ? super.getPrize() : 0;
    }
}
