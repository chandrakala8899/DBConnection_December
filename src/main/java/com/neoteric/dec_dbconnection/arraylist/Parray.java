package com.neoteric.dec_dbconnection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Parray {
    public static void main(String[] args) {

        List<Integer> array3 = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            array3.add(i);
        }

        List<Integer> array4 = new ArrayList<>();
        for (int i = 500; i < 1000; i++) {
            array4.add(i);

        }

        List<Integer> commonnumbers = new ArrayList<>(array3);
        commonnumbers.retainAll(array4);

        System.out.println(commonnumbers);
    }



}

