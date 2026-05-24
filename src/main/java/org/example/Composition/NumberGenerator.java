package org.example.Composition;

import java.util.*;

public class NumberGenerator {
    public NumberGenerator(){}
    private int pickRandomNum(int maxNumber){
        Random random = new Random();
        return random.nextInt(maxNumber) + 1;
    }

    public List<Integer> draw(int maxNumber, int count){
        //6자리 랜덤 뽑기
        HashSet<Integer> hashSet = new HashSet<>();
        while (hashSet.size() < count) {
            int number = pickRandomNum(maxNumber);
            hashSet.add(number);
        }
        List<Integer> sortedList = new ArrayList<>(hashSet);
        sortedList.sort(Comparator.naturalOrder());
        return sortedList;
    }
}
