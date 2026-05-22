package org.example;

import java.util.List;

public class NumberMatcher {
    public NumberMatcher(){}
    public boolean SpitoMatcher(List<Integer> list, int winningNumber){
        return list.contains(winningNumber);
    }
}
