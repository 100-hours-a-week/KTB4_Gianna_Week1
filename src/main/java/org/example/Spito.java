package org.example;

import java.util.ArrayList;
import java.util.List;

public class Spito extends InstantLottery {
    private final NumberGenerator numberGenerator;
    private boolean isWin;
    protected List<Integer> gameList = new ArrayList<>();
    protected int winningNumber;

    public Spito() {
        this.numberGenerator = new NumberGenerator();
        this.draw();
    }

    @Override
    protected void draw() {
        this.gameList = numberGenerator.draw(Constants.SPITO_MAX_NUMBER, Constants.LOTTERY_COUNT);
        this.winningNumber =numberGenerator.draw(Constants.SPITO_MAX_NUMBER, Constants.SPITO_WINNINGNUM_COUNT).getFirst();
    }

    @Override
    protected void scratch(){
        isWin = this.gameList.contains(this.winningNumber);
    }
}
