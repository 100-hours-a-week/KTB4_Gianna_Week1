package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private boolean isSpitoEmpty = false;
    private int prizeMoney = 0;
    private List<Spito> spitoList = new ArrayList<>();
    StringBuilder resultMsgSB = new StringBuilder();

    public User (String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSpitoList(List<Spito> spitoList){
        this.spitoList = spitoList;
    }

    public void setSpitoListEmpty(){
        this.isSpitoEmpty= true;
    }

    public void makeResultMsg(){
        String userInfoMsg = "[ " + this.name + " ]님의 결과 ) \n";
        this.resultMsgSB.append(userInfoMsg);

        if(isSpitoEmpty){
            String lackOfStockMsg = "[ "+ name + " ] 님 : 재고가 부족해 구매하지 못했습니다. 죄송합니다.";
            this.resultMsgSB.append(lackOfStockMsg);
        }else{
            for(Spito spito : spitoList){
                this.resultMsgSB.append(spito.getResultMsg());
                this.prizeMoney+=spito.getPrize();
            }
            //종료 했을 때만 상금 출력
            this.resultMsgSB.append("[ "+ this.name+ " ] 님의 상금은 " + this.prizeMoney + "원 입니다.");
        }
    }

    public StringBuilder getResultMsgSB(){
        return this.resultMsgSB;
    }

}
