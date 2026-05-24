package org.example.Lottery;

import org.example.Composition.NumberGenerator;
import org.example.Composition.NumberMatcher;

public class InstantLottery extends Lottery {
    protected final NumberGenerator numberGenerator;
    protected final NumberMatcher numberMatcher;

    public InstantLottery(){
        this.numberGenerator = new NumberGenerator();
        this.numberMatcher = new NumberMatcher();
    }

    public void setAvailableStock(int stockCount) {
        super.setAvailableStock(stockCount);
    }

    protected void draw(){}
    protected void scratch(){}
    protected void setPrize(int prize){ super.setPrize(prize); }
    protected int getPrize(){ return super.getPrize(); }

}
