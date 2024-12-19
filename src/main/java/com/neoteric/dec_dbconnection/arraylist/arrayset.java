package com.neoteric.dec_dbconnection.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class arrayset {
    public static void main(String[] args) {
        List<Integer> array5 = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            array5.add(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 500; i <= 1500; i++) {
            set.add(i);
        }
        long starttime=System.currentTimeMillis();
        List<Integer> commonnumbers = new ArrayList<>();
        for (int a : array5) {
            if (set.contains(a)) {
                commonnumbers.add(a);
            }

        }
        long endtime=System.currentTimeMillis();
        long totaltime=endtime-starttime;
        System.out.println(commonnumbers);
        System.out.println(totaltime);
    }
}