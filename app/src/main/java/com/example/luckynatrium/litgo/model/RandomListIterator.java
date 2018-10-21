package com.example.luckynatrium.litgo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//Итератор, позволяющий перебрать все элементы List в случайном порядке
public class RandomListIterator<T> implements Iterator {

    private ArrayList<T> list;
    private int count;
    private HashSet<Integer> usedIndex;
    private Random random;

    public RandomListIterator(ArrayList<T> list) {
        this.list = list;
        count = list.size();
        usedIndex = new HashSet<>();
        //TODO нужно будет убрать зерно, чтобы генерировались разные последовательности
        random = new Random(42);
    }

    @Override
    public boolean hasNext() {
        return count>0;
    }

    @Override
    public Object next() {
        if(hasNext()) {
            int nextInd = random.nextInt(list.size());
            while(usedIndex.contains(nextInd))
                nextInd = random.nextInt(list.size());
            count--;
            usedIndex.add(nextInd);
            return list.get(nextInd);
        }
        return null;
    }
}
